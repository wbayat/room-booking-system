package com.group13.roombookingsystem.model.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Booking {
    private Integer id;
    private final int userId;
    private final int roomId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Booking(Integer id,
                   int userId,
                   int roomId,
                   LocalDate date,
                   LocalTime startTime,
                   LocalTime endTime) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Booking(int userId,
                   int roomId,
                   LocalDate date,
                   LocalTime startTime,
                   LocalTime endTime) {
        this(null, userId, roomId, date, startTime, endTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public boolean overlaps(LocalDate otherDate, LocalTime otherStart, LocalTime otherEnd) {
        if (!date.equals(otherDate)) {
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
        return userId == booking.userId
                && roomId == booking.roomId
                && Objects.equals(id, booking.id)
                && Objects.equals(date, booking.date)
                && Objects.equals(startTime, booking.startTime)
                && Objects.equals(endTime, booking.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roomId, date, startTime, endTime);
    }
}
