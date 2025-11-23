package com.group13.roombookingsystem.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group13.roombookingsystem.model.booking.Booking;

public class BookingRepository {

    public Booking create(Booking booking) {
        String sql = String.format("INSERT INTO bookings(user_id, room_id, start_time, end_time, date) VALUES (%d, %d, '%s', '%s', '%s');",
            booking.getUserId(),
            booking.getRoomId(),
            booking.getStartTime().toString(),
            booking.getEndTime().toString(),
            booking.getBookingDate().toString());
            Database.getInstance().query(sql);
            return booking;
    }

    public void delete(int bookingId) {
        String sql = "DELETE FROM bookings WHERE id = " + bookingId + ";";
        Database.getInstance().query(sql);
    }

    public Optional<Booking> findById(int bookingId) {
        String sql = "SELECT id, user_id, room_id, start_time, end_time, date FROM bookings WHERE id = " + bookingId + ";";
        ResultSet resultSet = null;

        try {
            resultSet = Database.getInstance().select(sql);

            if (resultSet != null && resultSet.next()) {
                return Optional.of(mapRow(resultSet));
            }
            return Optional.empty();
        }
        
        catch (Exception e) {
            throw new IllegalStateException("Unable to fetch booking by id", e);
        }
    }

    public List<Booking> findByRoomAndDate(int roomId, LocalDate date) {
        String sql = "SELECT id, user_id, room_id, start_time, end_time, date FROM bookings WHERE room_id = " + roomId + " AND date = '" + date.toString() + "' ORDER BY start_time;";
        ResultSet resultSet = null;
        try {
            resultSet = Database.getInstance().select(sql);

            List<Booking> bookings = new ArrayList<>();

            while (resultSet != null && resultSet.next()) {
                bookings.add(mapRow(resultSet));
            }
            return bookings;
        }
        
        catch (Exception e) {
            throw new IllegalStateException("Unable to fetch bookings for room on date", e);
        }
    }

    public List<Booking> findByUser(int userId) {
        String sql = "SELECT id, user_id, room_id, start_time, end_time, date FROM bookings WHERE user_id = " + userId + " ORDER BY date, start_time;";
        ResultSet resultSet = null;
        try {
            resultSet = Database.getInstance().select(sql);
            List<Booking> bookings = new ArrayList<>();
            
            while (resultSet != null && resultSet.next()) {
                bookings.add(mapRow(resultSet));
            }
            return bookings;
        }
        catch (Exception e) {
            throw new IllegalStateException("Unable to fetch bookings for user", e);
        }
    }

    public Booking updateTimes(int bookingId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        String sql = String.format(
            "UPDATE bookings SET start_time = '%s', end_time = '%s', date = '%s' WHERE id = %d;",
            startTime.toString(), endTime.toString(), date.toString(), bookingId
        );

        try {
            Database.getInstance().query(sql);
            return findById(bookingId).orElseThrow(() -> new IllegalStateException("Booking updated but not found"));
        } catch (RuntimeException e) {
            throw new IllegalStateException("Unable to update booking times", e);
        }
    }

    private Booking mapRow(ResultSet resultSet) throws SQLException {
        Booking b = new Booking(
            resultSet.getInt("user_id"),
            resultSet.getInt("room_id"),
            LocalDate.parse(resultSet.getString("date")),
            LocalTime.parse(resultSet.getString("start_time")),
            LocalTime.parse(resultSet.getString("end_time"))
        );

        setUserIdFromDatabase(b, resultSet);
        return b;
    }

    private void setUserIdFromDatabase(Booking b, ResultSet resultSet) throws SQLException {
        b.setBookingId(resultSet.getInt("id"));
    }
}
