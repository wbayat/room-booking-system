package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.payment.PaymentContext;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.BookingRepository;
import com.group13.roombookingsystem.repository.PaymentMethodRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Manual mutation tests for {@link PaymentService}. Each test introduces a hand-crafted
 * mutant and asserts that the production implementation rejects the faulty behaviour.
 * This makes explicit that the existing specification is strong enough to kill these mutants.
 */
class PaymentServiceManualMutationTest {

    private PaymentService controlService;
    private PaymentService skipValidationMutant;
    private PaymentService negatedProcessMutant;

    private PaymentContext controlContext;
    private PaymentContext skipValidationContext;
    private PaymentContext negatedProcessContext;

    private TestPaymentRepository controlRepository;
    private TestPaymentRepository mutantRepository;
    private TestBookingRepository bookingRepository;
    private BookingService bookingService;

    private User user;
    private Room room;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;

    @BeforeEach
    void setUp() {
        controlContext = new PaymentContext();
        skipValidationContext = new LoosePaymentContext();
        negatedProcessContext = new PaymentContext();
        controlRepository = new TestPaymentRepository();
        mutantRepository = new TestPaymentRepository();
        bookingRepository = new TestBookingRepository();
        bookingService = instantiateBookingService();

        controlService = new PaymentService(controlContext, controlRepository, bookingService);
        skipValidationMutant = new SkipAmountValidationMutant(skipValidationContext, new TestPaymentRepository(), bookingService);
        negatedProcessMutant = new NegatedProcessResultMutant(negatedProcessContext, mutantRepository, bookingService);

        user = buildUser(1);
        room = buildRoom(10);
        date = LocalDate.now().plusDays(1);
        checkIn = LocalTime.of(9, 0);
        checkOut = LocalTime.of(11, 0);
    }

    @AfterEach
    void resetSingletons() throws Exception {
        Field paymentInstance = PaymentService.class.getDeclaredField("instance");
        paymentInstance.setAccessible(true);
        paymentInstance.set(null, null);

        Field bookingInstance = BookingService.class.getDeclaredField("instance");
        bookingInstance.setAccessible(true);
        bookingInstance.set(null, null);
    }

    @Test
    void mutationSkippingAmountValidationIsKilled() {
        StubPaymentStrategy strategy = new StubPaymentStrategy();
        strategy.setResult(true);

        IllegalArgumentException controlException = assertThrows(IllegalArgumentException.class,
                () -> controlService.processPayment(strategy, -50));
        assertEquals("Payment amount cannot be negative.", controlException.getMessage());

        assertDoesNotThrow(() -> skipValidationMutant.processPayment(strategy, -50),
                "Mutant skips the non-negative guard and should therefore behave incorrectly.");
        assertSame(strategy, skipValidationContext.getPaymentStrategy());
        assertEquals(-50, strategy.getLastAmount());
    }

    @Test
    void mutationNegatingProcessPaymentResultIsKilled() throws SQLException {
        StubPaymentStrategy failingStrategy = new StubPaymentStrategy();
        failingStrategy.setResult(false);

        assertThrows(IllegalStateException.class, () -> controlService.createBookingWithPayment(
                user, room, date, checkIn, checkOut, failingStrategy, 120.0));

        Booking mutantBooking = negatedProcessMutant.createBookingWithPayment(
                user, room, date, checkIn, checkOut, failingStrategy, 120.0);

        assertNotNull(mutantBooking);
        assertEquals(1, bookingRepository.getCreateCalls(), "Booking repository should be invoked once by the mutant.");
        assertEquals(1, mutantRepository.callCount, "Mutant records the payment even though the strategy failed.");
        assertEquals(120.0, failingStrategy.getLastAmount());
        assertSame(failingStrategy, negatedProcessContext.getPaymentStrategy());
    }

    private BookingService instantiateBookingService() {
        try {
            Constructor<BookingService> constructor = BookingService.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            BookingService service = constructor.newInstance();
            Field repoField = BookingService.class.getDeclaredField("bookingRepository");
            repoField.setAccessible(true);
            repoField.set(service, bookingRepository);
            Field bookingsField = BookingService.class.getDeclaredField("bookings");
            bookingsField.setAccessible(true);
            bookingsField.set(service, new ArrayList<>());
            return service;
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate BookingService for manual mutation tests", e);
        }
    }

    private User buildUser(int id) {
        User newUser = new User("user" + id + "@example.com", "pwd", id, "USER", true);
        newUser.setId(id);
        return newUser;
    }

    private Room buildRoom(int id) {
        Room newRoom = new Room();
        newRoom.setRoomId(id);
        return newRoom;
    }

    private static final class SkipAmountValidationMutant extends PaymentService {
        SkipAmountValidationMutant(PaymentContext paymentContext,
                                   PaymentMethodRepository paymentMethodRepository,
                                   BookingService bookingService) {
            super(paymentContext, paymentMethodRepository, bookingService);
        }

        @Override
        public synchronized boolean processPayment(PaymentStrategy paymentStrategy, double amount) {
            if (paymentStrategy == null) {
                throw new IllegalArgumentException("Payment strategy must be provided.");
            }
            getPaymentContext().setPaymentStrategy(paymentStrategy);
            return getPaymentContext().pay(amount);
        }
    }

    private static final class NegatedProcessResultMutant extends PaymentService {
        NegatedProcessResultMutant(PaymentContext paymentContext,
                                   PaymentMethodRepository paymentMethodRepository,
                                   BookingService bookingService) {
            super(paymentContext, paymentMethodRepository, bookingService);
        }

        @Override
        public synchronized boolean processPayment(PaymentStrategy paymentStrategy, double amount) {
            return !super.processPayment(paymentStrategy, amount);
        }
    }

    private static final class LoosePaymentContext extends PaymentContext {
        @Override
        public synchronized boolean pay(double amount) {
            PaymentStrategy strategy = getPaymentStrategy();
            if (strategy == null) {
                throw new IllegalStateException("Payment strategy has not been set.");
            }
            return strategy.pay(amount);
        }
    }

    private static final class StubPaymentStrategy implements PaymentStrategy {
        private boolean nextResult = true;
        private double lastAmount;
        private int id;

        void setResult(boolean nextResult) {
            this.nextResult = nextResult;
        }

        double getLastAmount() {
            return lastAmount;
        }

        @Override
        public boolean pay(double amount) {
            this.lastAmount = amount;
            return nextResult;
        }

        @Override
        public void setID(int id) {
            this.id = id;
        }

        @Override
        public int getID() {
            return id;
        }
    }

    private static final class TestPaymentRepository extends PaymentMethodRepository {
        private int callCount;

        @Override
        public PaymentStrategy create(int userId, int bookingId, double amount, String date, PaymentStrategy strategy) {
            callCount++;
            return strategy;
        }
    }

    private static final class TestBookingRepository extends BookingRepository {
        private int nextId = 1;
        private int createCalls;

        int getCreateCalls() {
            return createCalls;
        }

        @Override
        public Booking create(Booking booking) {
            createCalls++;
            booking.setBookingId(nextId++);
            return booking;
        }
    }
}


