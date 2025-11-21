package com.group13.roombookingsystem.model.booking;

import java.time.LocalDate;
import java.time.LocalTime;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;

public class Booking {

    private int bookingID;
    private User booker;
    private Room roomBooked;
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private int depositAmount;
    private boolean hasCheckedIn;

    public Booking(int bookingID, User booker, Room roomBooked, LocalDate bookingDate, LocalTime startTime, LocalTime endTime) {
        this.bookingID = bookingID;
        this.booker = booker;
        this.roomBooked = roomBooked;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.depositAmount = 0;
        this.hasCheckedIn = false;
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
    public int getBookingID() {
        return bookingID;
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
}
