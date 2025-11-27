package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.payment.PaymentContext;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.repository.PaymentMethodRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Facade for executing payments using the strategy pattern. All mutations are
 * synchronized to avoid side effects when the same context is shared across
 * multiple booking workflows.
 */
public class PaymentService {

    private static PaymentService instance;

    private final PaymentContext paymentContext;
    private final PaymentMethodRepository paymentMethodRepository;
    private final BookingService bookingService;

    private PaymentService() {
        this(new PaymentContext(), new PaymentMethodRepository(), BookingService.getInstance());
    }

    PaymentService(PaymentContext paymentContext,
                   PaymentMethodRepository paymentMethodRepository,
                   BookingService bookingService) {
        if (paymentContext == null) {
            throw new IllegalArgumentException("Payment context cannot be null.");
        }
        if (paymentMethodRepository == null) {
            throw new IllegalArgumentException("Payment repository cannot be null.");
        }
        if (bookingService == null) {
            throw new IllegalArgumentException("Booking service cannot be null.");
        }
        this.paymentContext = paymentContext;
        this.paymentMethodRepository = paymentMethodRepository;
        this.bookingService = bookingService;
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance;
    }

    public synchronized Booking createBookingWithPayment(User user,
                                                         Room room,
                                                         LocalDate date,
                                                         LocalTime checkinTime,
                                                         LocalTime checkoutTime,
                                                         PaymentStrategy paymentStrategy,
                                                         double amount) throws SQLException {


        validateBookingRequest(user, room, date, checkinTime, checkoutTime, paymentStrategy, amount);

        if (!processPayment(paymentStrategy, amount)) {
            throw new IllegalStateException("Payment could not be processed.");
        }

        Booking booking = bookingService.createBooking(user, room, date, checkinTime, checkoutTime, paymentStrategy);

        try {
            paymentMethodRepository.create(user.getId(), booking.getBookingID(), amount, date.toString(), paymentStrategy);
        } catch (RuntimeException repositoryError) {
            bookingService.cancelBooking(booking);
            throw repositoryError;
        }

        return booking;
    }

    public synchronized boolean processPayment(PaymentStrategy paymentStrategy, double amount) {
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("Payment strategy must be provided.");
        }
        ensureNonNegative(amount);
        paymentContext.setPaymentStrategy(paymentStrategy);
        return paymentContext.pay(amount);
    }

    public PaymentContext getPaymentContext() {
        return paymentContext;
    }

    private void validateBookingRequest(User user,
                                        Room room,
                                        LocalDate date,
                                        LocalTime checkinTime,
                                        LocalTime checkoutTime,
                                        PaymentStrategy paymentStrategy,
                                        double amount) {
        if (user == null) {
            throw new IllegalArgumentException("User must be provided.");
        }
        if (room == null) {
            throw new IllegalArgumentException("Room must be provided.");
        }
        if (date == null || checkinTime == null || checkoutTime == null) {
            throw new IllegalArgumentException("Booking date and time must be provided.");
        }
        if (paymentStrategy == null) {
            throw new IllegalArgumentException("Payment strategy must be provided.");
        }
        ensureNonNegative(amount);
    }

    private void ensureNonNegative(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative.");
        }
    }
}

