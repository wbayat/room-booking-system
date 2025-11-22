package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.repository.BookingRepository;
import com.group13.roombookingsystem.repository.RoomRepository;
import com.group13.roombookingsystem.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class BookingService {
//    private final BookingRepository bookingRepository;
//    private final RoomRepository roomRepository;
//    private final UserRepository userRepository;
//    private final PaymentService paymentService;
//
//    public BookingService() {
//        this(new PaymentService());
//    }
//
//    public BookingService(PaymentService paymentService) {
//        this(paymentService, new BookingRepository(), new RoomRepository(), new UserRepository());
//    }
//
//    BookingService(PaymentService paymentService,
//                   BookingRepository bookingRepository,
//                   RoomRepository roomRepository,
//                   UserRepository userRepository) {
//        this.paymentService = Objects.requireNonNull(paymentService, "paymentService");
//        this.bookingRepository = Objects.requireNonNull(bookingRepository, "bookingRepository");
//        this.roomRepository = Objects.requireNonNull(roomRepository, "roomRepository");
//        this.userRepository = Objects.requireNonNull(userRepository, "userRepository");
//    }
//
//    public Booking createBooking(int userId,
//                                 int roomId,
//                                 LocalDate date,
//                                 LocalTime startTime,
//                                 LocalTime endTime,
//                                 double amount,
//                                 PaymentStrategy paymentStrategy) {
//        ensureUserExists(userId);
//        ensureRoomExists(roomId);
//        validateTimeRange(date, startTime, endTime);
//        ensureAvailability(roomId, date, startTime, endTime, null);
//        ensureNonNegative(amount);
//
//        if (!paymentService.processPayment(paymentStrategy, amount)) {
//            throw new IllegalStateException("Payment could not be processed.");
//        }
//
//        Booking booking = new Booking(userId, roomId, date, startTime, endTime);
//        return bookingRepository.create(booking);
//    }
//
//    public Booking extendBooking(int bookingId,
//                                 LocalDate newDate,
//                                 LocalTime newStartTime,
//                                 LocalTime newEndTime,
//                                 double additionalCharge,
//                                 PaymentStrategy paymentStrategy) {
//        Booking currentBooking = bookingRepository.findById(bookingId)
//                .orElseThrow(() -> new IllegalArgumentException("Booking not found."));
//
//        validateTimeRange(newDate, newStartTime, newEndTime);
//        ensureAvailability(currentBooking.getRoomId(), newDate, newStartTime, newEndTime, bookingId);
//        ensureNonNegative(additionalCharge);
//
//        if (additionalCharge > 0 && !paymentService.processPayment(paymentStrategy, additionalCharge)) {
//            throw new IllegalStateException("Payment could not be processed for booking extension.");
//        }
//
//        return bookingRepository.updateTimes(bookingId, newDate, newStartTime, newEndTime);
//    }
//
//    public void cancelBooking(int bookingId, int requestingUserId) {
//        Booking booking = bookingRepository.findById(bookingId)
//                .orElseThrow(() -> new IllegalArgumentException("Booking not found."));
//        if (booking.getUserId() != requestingUserId) {
//            throw new IllegalStateException("Only the booking owner can cancel the booking.");
//        }
//        bookingRepository.delete(bookingId);
//    }
//
//    public List<Booking> getBookingsForUser(int userId) {
//        ensureUserExists(userId);
//        return bookingRepository.findByUser(userId);
//    }
//
//    public List<Booking> getBookingsForRoomOnDate(int roomId, LocalDate date) {
//        ensureRoomExists(roomId);
//        return bookingRepository.findByRoomAndDate(roomId, date);
//    }
//
//    private void ensureUserExists(int userId) {
//        userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found."));
//    }
//
//    private void ensureRoomExists(int roomId) {
//        roomRepository.findById(roomId)
//                .orElseThrow(() -> new IllegalArgumentException("Room not found."));
//    }
//
//    private void validateTimeRange(LocalDate date, LocalTime startTime, LocalTime endTime) {
//        Objects.requireNonNull(date, "date");
//        Objects.requireNonNull(startTime, "startTime");
//        Objects.requireNonNull(endTime, "endTime");
//
//        if (!startTime.isBefore(endTime)) {
//            throw new IllegalArgumentException("Start time must be before end time.");
//        }
//
//        if (date.isBefore(LocalDate.now())) {
//            throw new IllegalArgumentException("Cannot create bookings in the past.");
//        }
//    }
//
//    private void ensureAvailability(int roomId,
//                                    LocalDate date,
//                                    LocalTime startTime,
//                                    LocalTime endTime,
//                                    Integer bookingIdToIgnore) {
//        bookingRepository.findByRoomAndDate(roomId, date).stream()
//                .filter(existing -> bookingIdToIgnore == null || !bookingIdToIgnore.equals(existing.getId()))
//                .filter(existing -> existing.overlaps(date, startTime, endTime))
//                .findFirst()
//                .ifPresent(existing -> {
//                    throw new IllegalStateException("The room is already booked for the selected time.");
//                });
//    }
//
//    private void ensureNonNegative(double amount) {
//        if (amount < 0) {
//            throw new IllegalArgumentException("Amount cannot be negative.");
//        }
//    }
}