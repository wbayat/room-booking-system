package com.group13.roombookingsystem.model.sensor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.repository.BookingRepository;
import com.group13.roombookingsystem.model.room.Room;

public class Sensor {
    private int sensorID;

    public Sensor(int sensorId) {
        this.sensorID = sensorId;
    }

    /**
     * Check whether the given userId has a valid booking for the given roomId
     * at the current time. Returns true if a booking exists for that user and
     * the current time is >= booking start (and <= booking end when end is present).
     *
     * Note: callers (Room) must pass the roomId and the userId.
     */
    public boolean scanBadge(Room room, int roomId, int userId) {
        BookingRepository bookingRepository = new BookingRepository();
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalTime nowTime = now.toLocalTime();

        //Check if the room is calling its associated sensor
        if (this.sensorID != room.getSensorId()) {
            return false;
        }

        // Retrieve bookings for the room and check if any match the user and time.
        // Assumes Booking has getUserId(), getStartTime(), getEndTime() methods.
        List<Booking> bookings = bookingRepository.findByRoomAndDate(roomId, today);

        for (Booking b : bookings) {
            if (b == null) continue;
            Integer bookingUserId = b.getUserId();
            LocalTime start = b.getStartTime();
            LocalTime end = b.getEndTime(); // may be null

            if (bookingUserId == null || start == null) continue;
            if (bookingUserId != userId) continue;

            // now >= start
            if (nowTime.isBefore(start)) continue;

            // if end is present require now <= end, otherwise accept (single-point booking)
            if (end != null && nowTime.isAfter(end)) continue;

            return true;
        }

        return false;
    }

    public int detectOccupancy() {
        // Implementation for detecting occupancy, generates a random
        // integer between 0 and 15 for simulation purposes.
        return (int) (Math.random() * 16);
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }

    public int getSensorID(){
        return sensorID;
    }
}
