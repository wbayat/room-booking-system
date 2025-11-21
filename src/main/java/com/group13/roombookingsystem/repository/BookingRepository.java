package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.booking.Booking;

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

public class BookingRepository {
    private static final String INSERT_BOOKING = """
            INSERT INTO bookings(user_id, room_id, start_time, end_time, date)
            VALUES (?, ?, ?, ?, ?);
            """;

    private static final String DELETE_BOOKING = "DELETE FROM bookings WHERE id = ?;";
    private static final String FIND_BY_ID = """
            SELECT id, user_id, room_id, start_time, end_time, date
            FROM bookings
            WHERE id = ?;
            """;
    private static final String FIND_BY_ROOM_AND_DATE = """
            SELECT id, user_id, room_id, start_time, end_time, date
            FROM bookings
            WHERE room_id = ? AND date = ?
            ORDER BY start_time;
            """;
    private static final String FIND_BY_USER = """
            SELECT id, user_id, room_id, start_time, end_time, date
            FROM bookings
            WHERE user_id = ?
            ORDER BY date, start_time;
            """;
    private static final String UPDATE_TIMES = """
            UPDATE bookings
            SET start_time = ?, end_time = ?, date = ?
            WHERE id = ?;
            """;

    public Booking create(Booking booking) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_BOOKING, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, booking.getUserId());
            statement.setInt(2, booking.getRoomId());
            statement.setString(3, booking.getStartTime().toString());
            statement.setString(4, booking.getEndTime().toString());
            statement.setString(5, booking.getDate().toString());

            int affected = statement.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Creating booking failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    booking.setId(generatedKeys.getInt(1));
                }
            }

            return booking;
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to create booking", e);
        }
    }

    public void delete(int bookingId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING)) {
            statement.setInt(1, bookingId);
            int affected = statement.executeUpdate();
            if (affected == 0) {
                throw new SQLException("No booking removed for id=" + bookingId);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to delete booking", e);
        }
    }

    public Optional<Booking> findById(int bookingId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, bookingId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch booking by id", e);
        }
    }

    public List<Booking> findByRoomAndDate(int roomId, LocalDate date) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ROOM_AND_DATE)) {
            statement.setInt(1, roomId);
            statement.setString(2, date.toString());
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Booking> bookings = new ArrayList<>();
                while (resultSet.next()) {
                    bookings.add(mapRow(resultSet));
                }
                return bookings;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch bookings for room on date", e);
        }
    }

    public List<Booking> findByUser(int userId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_USER)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Booking> bookings = new ArrayList<>();
                while (resultSet.next()) {
                    bookings.add(mapRow(resultSet));
                }
                return bookings;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch bookings for user", e);
        }
    }

    public Booking updateTimes(int bookingId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TIMES)) {
            statement.setString(1, startTime.toString());
            statement.setString(2, endTime.toString());
            statement.setString(3, date.toString());
            statement.setInt(4, bookingId);

            int affected = statement.executeUpdate();
            if (affected == 0) {
                throw new SQLException("No booking updated for id=" + bookingId);
            }
            return findById(bookingId).orElseThrow(() -> new IllegalStateException("Booking updated but not found"));
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to update booking times", e);
        }
    }

    private Booking mapRow(ResultSet resultSet) throws SQLException {
        return new Booking(
                resultSet.getInt("id"),
                resultSet.getInt("user_id"),
                resultSet.getInt("room_id"),
                LocalDate.parse(resultSet.getString("date")),
                LocalTime.parse(resultSet.getString("start_time")),
                LocalTime.parse(resultSet.getString("end_time"))
        );
    }
}
