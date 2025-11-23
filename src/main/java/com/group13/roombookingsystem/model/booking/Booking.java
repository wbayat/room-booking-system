package com.group13.roombookingsystem.model.booking;

import java.time.LocalDate;
import java.time.LocalTime;

import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;

public class Booking {
    private User booker;
    private Room roomBooked;
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int depositAmount;
    private boolean hasCheckedIn;
    private int bookerID;
    private int roomID;
    private PaymentStrategy paymentStrategy;

    public Booking(int bookerID, int roomID, LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        this.bookerID = booker.getId();
        this.roomID = roomBooked.getRoomID();
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.depositAmount = booker.getHourlyRate();
        this.hasCheckedIn = false;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected.");
            return false;
        }
        return paymentStrategy.pay(amount);
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public int getUserId() {
        return booker.getId();
    }

    public int getRoomId() {
        return roomBooked.getRoomID();
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public void setBooker(User booker) {
        this.booker = booker;
    }

    public void setRoomBooked(Room roomBooked) {
        this.roomBooked = roomBooked;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void checkIn() {
        this.hasCheckedIn = true;
    }

    public User getBooker() {
        return booker;
    }

    public Room getRoomBooked() {
        return roomBooked;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public boolean hasCheckedIn() {
        return hasCheckedIn;
    }


    // link database ID to booking
    private int DatabaseId;

    public int getBookingID() {
        return DatabaseId;
    }
    public void setBookingId(int id) {
        this.DatabaseId = id;
    }
}
