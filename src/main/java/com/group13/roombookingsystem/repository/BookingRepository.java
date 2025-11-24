package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group13.roombookingsystem.model.booking.Booking;

public class BookingRepository {

    private static final String INSERT_BOOKING = "INSERT INTO bookings(user_id, room_id, start_time, end_time, date) VALUES (?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "SELECT id, user_id, room_id, start_time, end_time, date FROM bookings WHERE id = ?;";
    private static final String FIND_BY_ROOM_AND_DATE = "SELECT id, user_id, room_id, start_time, end_time, date FROM bookings WHERE room_id = ? AND date = ? ORDER BY start_time;";
    private static final String FIND_BY_USER = "SELECT id, user_id, room_id, start_time, end_time, date FROM bookings WHERE user_id = ? ORDER BY date, start_time;";
    private static final String UPDATE_TIMES = "UPDATE bookings SET start_time = ?, end_time = ?, date = ? WHERE id = ?;";
    private static final String DELETE_BY_ID = "DELETE FROM bookings WHERE id = ?;";

    public Booking create(Booking booking) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, booking.getUserId());
            statement.setInt(2, booking.getRoomId());
            statement.setString(3, booking.getStartTime().toString());
            statement.setString(4, booking.getEndTime().toString());
            statement.setString(5, booking.getBookingDate().toString());
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    booking.setBookingId(keys.getInt(1));
                }
            }
            
            return booking;
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to create booking", e);
        }
    }

    public void delete(int bookingId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setInt(1, bookingId);
            statement.executeUpdate();
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to delete booking", e);
        }
    }

    public Optional<Booking> findById(int bookingId) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, bookingId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
                
                return Optional.empty();
            }
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch booking by id", e);
        }
    }

    public List<Booking> findByRoomAndDate(int roomId, LocalDate date) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_ROOM_AND_DATE)) {
            statement.setInt(1, roomId);
            statement.setString(2, date.toString());

            try (ResultSet resultSet = statement.executeQuery()) {
                List<Booking> bookings = new ArrayList<>();
                while (resultSet.next()) {
                    bookings.add(mapRow(resultSet));
                }
                return bookings;
            }
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch bookings for room on date", e);
        }
    }

    public List<Booking> findByUser(int userId) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_USER)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                List<Booking> bookings = new ArrayList<>();

                while (resultSet.next()) {
                    bookings.add(mapRow(resultSet));
                }
                return bookings;
            }
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch bookings for user", e);
        }
    }

    public Booking updateTimes(int bookingId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        Booking existing = findById(bookingId).orElseThrow(() -> new IllegalStateException("Booking not found"));

        LocalDate updatedDate = existing.getBookingDate();
        LocalTime updatedStart = existing.getStartTime();
        LocalTime updatedEnd = existing.getEndTime();

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TIMES)) {
            statement.setString(1, updatedStart.toString());
            statement.setString(2, updatedEnd.toString());
            statement.setString(3, updatedDate.toString());
            statement.setInt(4, bookingId);
            statement.executeUpdate();

            existing.setBookingDate(updatedDate);
            existing.setStartTime(updatedStart);
            existing.setEndTime(updatedEnd);
            return existing;
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to update booking times", e);
        }
    }

    private Booking mapRow(ResultSet resultSet) throws SQLException {
        Booking booking = new Booking(
                resultSet.getInt("user_id"),
                resultSet.getInt("room_id"),
                LocalDate.parse(resultSet.getString("date")),
                LocalTime.parse(resultSet.getString("start_time")),
                LocalTime.parse(resultSet.getString("end_time"))
        );
        booking.setBookingId(resultSet.getInt("id"));
        return booking;
    }
}
