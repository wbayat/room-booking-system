package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
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

    public BookingRepository() {
        Database.getInstance();
    }

    public Booking create(Booking booking) {
        validateBookingTimes(booking, false);
        ensureNoOverlap(booking, null);

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

        boolean hasStarted = hasBookingStarted(existing);

        LocalDate updatedDate;
        LocalTime updatedStart;
        LocalTime updatedEnd = endTime != null ? endTime : existing.getEndTime();

        if (hasStarted) {
            if (date != null && !date.equals(existing.getBookingDate())) {
                throw new IllegalStateException("Cannot change the booking date after the event has started.");
            }
            if (startTime != null && !startTime.equals(existing.getStartTime())) {
                throw new IllegalStateException("Cannot change the start time after the event has started.");
            }
            if (endTime != null && !endTime.isAfter(existing.getEndTime())) {
                throw new IllegalStateException("Once started, you may only extend the booking end time.");
            }

            updatedDate = existing.getBookingDate();
            updatedStart = existing.getStartTime();
        } 
        
        else {
            updatedDate = date != null ? date : existing.getBookingDate();
            updatedStart = startTime != null ? startTime : existing.getStartTime();
        }

        Booking candidate = new Booking(existing.getUserId(), existing.getRoomId(), updatedDate, updatedStart, updatedEnd);
        candidate.setBookingId(existing.getBookingID());
        validateBookingTimes(candidate, hasStarted);
        ensureNoOverlap(candidate, bookingId);

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

    private void validateBookingTimes(Booking booking, boolean allowStarted) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();

        LocalDate date = booking.getBookingDate();
        LocalTime start = booking.getStartTime();
        LocalTime end = booking.getEndTime();

        if (!allowStarted) {
            if (date.isBefore(today)) {
                throw new IllegalStateException("Cannot book time in the past.");
            }
            if (date.isEqual(today) && start.isBefore(now)) {
                throw new IllegalStateException("Cannot book time in the past.");
            }
        }

        if (!start.isBefore(end)) {
            throw new IllegalStateException("Start time must be before end time.");
        }

        long minutes = Duration.between(start, end).toMinutes();
        if (minutes < 60) {
            throw new IllegalStateException("Minimum booking length is 1 hour.");
        }
        if (minutes > 180) {
            throw new IllegalStateException("Maximum booking length is 3 hours.");
        }
    }

    private void ensureNoOverlap(Booking booking, Integer bookingIdToIgnore) {
        List<Booking> sameDayBookings = findByRoomAndDate(booking.getRoomId(), booking.getBookingDate());

        for (Booking existing : sameDayBookings) {
            if (bookingIdToIgnore != null && bookingIdToIgnore.equals(existing.getBookingID())) {
                continue;
            }
            if (isOverlap(existing, booking)) {
                throw new IllegalStateException("The room is already booked for the selected time.");
            }
        }
    }

    private boolean isOverlap(Booking existing, Booking incoming) {
        if (!existing.getBookingDate().equals(incoming.getBookingDate())) {
            return false;
        }

        LocalTime existingStart = existing.getStartTime();
        LocalTime existingEnd = existing.getEndTime();
        LocalTime incomingStart = incoming.getStartTime();
        LocalTime incomingEnd = incoming.getEndTime();
        return existingStart.isBefore(incomingEnd) && incomingStart.isBefore(existingEnd);
    }

    private boolean hasBookingStarted(Booking booking) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        return booking.getBookingDate().isBefore(today) || (booking.getBookingDate().isEqual(today) && !booking.getStartTime().isAfter(now));
    }
}
