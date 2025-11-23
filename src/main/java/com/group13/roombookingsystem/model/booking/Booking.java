package com.group13.roombookingsystem.model.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;

public class Booking {
    private Integer id;
    private int bookerId;
    private int roomId;
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int depositAmount;
    private boolean hasCheckedIn;
    private User booker;
    private Room roomBooked;
    private PaymentStrategy paymentStrategy;

    public Booking(Integer id,
                   int bookerId,
                   int roomId,
                   LocalDate bookingDate,
                   LocalTime startTime,
                   LocalTime endTime) {
        this.id = id;
        this.bookerId = bookerId;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.depositAmount = 0;
        this.hasCheckedIn = false;
    }

    public Booking(int bookerId,
                   int roomId,
                   LocalDate bookingDate,
                   LocalTime startTime,
                   LocalTime endTime) {
        this(null, bookerId, roomId, bookingDate, startTime, endTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBookingID() {
        return id == null ? -1 : id;
    }

    public void setBookingId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return bookerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getDate() {
        return bookingDate;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public boolean hasCheckedIn() {
        return hasCheckedIn;
    }

    public void checkIn() {
        this.hasCheckedIn = true;
    }

    public void setBooker(User booker) {
        this.booker = booker;
        if (booker != null) {
            this.bookerId = booker.getId();
            this.depositAmount = booker.getHourlyRate();
        }
    }

    public User getBooker() {
        return booker;
    }

    public void setRoomBooked(Room roomBooked) {
        this.roomBooked = roomBooked;
        if (roomBooked != null) {
            this.roomId = roomBooked.getRoomID();
        }
    }

    public Room getRoomBooked() {
        return roomBooked;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public boolean pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return false;
        }
        return paymentStrategy.pay(amount);
    }

    public boolean overlaps(LocalDate otherDate, LocalTime otherStart, LocalTime otherEnd) {
        if (!bookingDate.equals(otherDate)) {
            return false;
        }
        return startTime.isBefore(otherEnd) && otherStart.isBefore(endTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Booking booking = (Booking) o;
        return bookerId == booking.bookerId
                && roomId == booking.roomId
                && Objects.equals(id, booking.id)
                && Objects.equals(bookingDate, booking.bookingDate)
                && Objects.equals(startTime, booking.startTime)
                && Objects.equals(endTime, booking.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookerId, roomId, bookingDate, startTime, endTime);
    }
}
