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

class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentContext paymentContext;
    private TestPaymentRepository paymentMethodRepository;
    private BookingService bookingService;
    private TestBookingRepository bookingRepository;
    private StubPaymentStrategy paymentStrategy;

    private User user;
    private Room room;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;

    @BeforeEach
    void setUp() {
        paymentContext = new PaymentContext();
        paymentMethodRepository = new TestPaymentRepository();
        bookingRepository = new TestBookingRepository();
        bookingService = instantiateBookingService();
        paymentStrategy = new StubPaymentStrategy();
        paymentService = new PaymentService(paymentContext, paymentMethodRepository, bookingService);
        user = buildUser(1);
        room = buildRoom(10);
        date = LocalDate.now().plusDays(1);
        checkIn = LocalTime.of(9, 0);
        checkOut = LocalTime.of(11, 0);
    }

    @AfterEach
    void resetSingleton() throws Exception {
        Field instanceField = PaymentService.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
        Field bookingInstance = BookingService.class.getDeclaredField("instance");
        bookingInstance.setAccessible(true);
        bookingInstance.set(null, null);
    }

    @Test
    void constructorRejectsNullDependencies() {
        assertThrows(IllegalArgumentException.class,
                () -> new PaymentService(null, paymentMethodRepository, bookingService));
        assertThrows(IllegalArgumentException.class,
                () -> new PaymentService(new PaymentContext(), null, bookingService));
        assertThrows(IllegalArgumentException.class,
                () -> new PaymentService(new PaymentContext(), paymentMethodRepository, null));
    }

    @Test
    void getInstanceReturnsSingleton() throws Exception {
        resetSingleton();
        PaymentService first = PaymentService.getInstance();
        PaymentService second = PaymentService.getInstance();
        assertSame(first, second);
    }

    @Test
    void processPaymentDelegatesToContext() {
        paymentStrategy.setResult(true);

        assertTrue(paymentService.processPayment(paymentStrategy, 200.0));

        assertSame(paymentStrategy, paymentContext.getPaymentStrategy());
        assertEquals(200.0, paymentStrategy.getLastAmount());
    }

    @Test
    void processPaymentRejectsNullStrategy() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> paymentService.processPayment(null, 100));
        assertEquals("Payment strategy must be provided.", ex.getMessage());
    }

    @Test
    void processPaymentRejectsNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> paymentService.processPayment(paymentStrategy, -10));
        assertNull(paymentContext.getPaymentStrategy());
        assertEquals(0, paymentStrategy.getCalls());
    }

    @Test
    void createBookingWithPaymentCompletesWorkflow() throws SQLException {
        paymentStrategy.setResult(true);
        bookingRepository.setNextId(42);

        Booking result = paymentService.createBookingWithPayment(
                user, room, date, checkIn, checkOut, paymentStrategy, 150.0);

        assertEquals(42, result.getBookingID());
        assertSame(paymentStrategy, paymentContext.getPaymentStrategy());
        assertEquals(150.0, paymentStrategy.getLastAmount());
        assertEquals(1, paymentMethodRepository.callCount);
        assertEquals(user.getId(), paymentMethodRepository.userId);
        assertEquals(result.getBookingID(), paymentMethodRepository.bookingId);
        assertEquals(150.0, paymentMethodRepository.amount);
        assertEquals(date.toString(), paymentMethodRepository.date);
        assertSame(paymentStrategy, paymentMethodRepository.strategy);
        assertEquals(1, bookingRepository.getCreateCalls());
    }

    @Test
    void createBookingWithPaymentThrowsWhenProcessingFails() throws SQLException {
        paymentStrategy.setResult(false);

        IllegalStateException ex = assertThrows(IllegalStateException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, date, checkIn, checkOut, paymentStrategy, 150.0));

        assertEquals("Payment could not be processed.", ex.getMessage());
        assertEquals(0, paymentMethodRepository.callCount);
        assertEquals(0, bookingRepository.getCreateCalls());
    }

    @Test
    void createBookingWithPaymentRollsBackWhenRepositoryFails() throws SQLException {
        paymentStrategy.setResult(true);
        bookingRepository.setNextId(84);
        RuntimeException failure = new RuntimeException("db down");
        paymentMethodRepository.failWith(failure);

        RuntimeException thrown = assertThrows(RuntimeException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, date, checkIn, checkOut, paymentStrategy, 150.0));

        assertSame(failure, thrown);
        assertTrue(user.getBookings().isEmpty(), "Booking should be removed after rollback");
    }

    @Test
    void createBookingWithPaymentValidatesInputs() {
        assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        null, room, date, checkIn, checkOut, paymentStrategy, 150.0));
        assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        user, null, date, checkIn, checkOut, paymentStrategy, 150.0));
        assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, null, checkIn, checkOut, paymentStrategy, 150.0));
        assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, date, null, checkOut, paymentStrategy, 150.0));
        assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, date, checkIn, null, paymentStrategy, 150.0));
        assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, date, checkIn, checkOut, null, 150.0));
        IllegalArgumentException negative = assertThrows(IllegalArgumentException.class, () ->
                paymentService.createBookingWithPayment(
                        user, room, date, checkIn, checkOut, paymentStrategy, -1));
        assertEquals("Payment amount cannot be negative.", negative.getMessage());
    }

    @Test
    void getPaymentContextReturnsBackingInstance() {
        assertSame(paymentContext, paymentService.getPaymentContext());
    }

    private User buildUser(int id) {
        User user = new User("user" + id + "@example.com", "pwd", id, "USER", true);
        user.setId(id);
        return user;
    }

    private Room buildRoom(int id) {
        Room room = new Room();
        room.setRoomId(id);
        return room;
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
            throw new RuntimeException("Unable to instantiate BookingService for tests", e);
        }
    }

    private static final class StubPaymentStrategy implements PaymentStrategy {
        private boolean nextResult = true;
        private double lastAmount;
        private int id;
        private int calls;

        void setResult(boolean nextResult) {
            this.nextResult = nextResult;
        }

        double getLastAmount() {
            return lastAmount;
        }

        int getCalls() {
            return calls;
        }

        @Override
        public boolean pay(double amount) {
            calls++;
            lastAmount = amount;
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
        private int userId;
        private int bookingId;
        private double amount;
        private String date;
        private PaymentStrategy strategy;
        private int callCount;
        private RuntimeException failure;

        void failWith(RuntimeException failure) {
            this.failure = failure;
        }

        @Override
        public PaymentStrategy create(int userId, int bookingId, double amount, String date, PaymentStrategy strategy) {
            callCount++;
            if (failure != null) {
                throw failure;
            }
            this.userId = userId;
            this.bookingId = bookingId;
            this.amount = amount;
            this.date = date;
            this.strategy = strategy;
            return strategy;
        }
    }

    private static final class TestBookingRepository extends BookingRepository {
        private int nextId = 1;
        private int createCalls;

        void setNextId(int nextId) {
            this.nextId = nextId;
        }

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

