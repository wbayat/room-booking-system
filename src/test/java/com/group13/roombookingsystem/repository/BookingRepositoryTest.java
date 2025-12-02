package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.booking.Booking;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {

    private final BookingRepository repository = new BookingRepository();

    private void createUser(int userId) {
        String sql = "INSERT INTO users(id, username, password, identification, role, is_verified) " +
                "VALUES (?, 'bookingUser" + userId + "', 'pw', 1234, 'Student', 1) " +
                "ON CONFLICT(id) DO NOTHING;";
        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }
    }

    private void createRoom(int roomId) {
        String sql = "INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled) " +
                "VALUES (?, 'bookingRoom" + roomId + "', 10, 'BookingLoc', 1, 0, 0, 1) " +
                "ON CONFLICT(id) DO NOTHING;";
        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, roomId);
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }
    }

    private void cleanupBookingById(int id) {
        try (Connection c = Database.getConnection()) {
            PreparedStatement st = c.prepareStatement("DELETE FROM bookings WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }
    }

    private void cleanupBooking(int userId, int roomId) {
        try (Connection c = Database.getConnection()) {
            PreparedStatement st = c.prepareStatement(
                    "DELETE FROM bookings WHERE user_id = ? AND room_id = ?");
            st.setInt(1, userId);
            st.setInt(2, roomId);
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createBookingTest() {
        int userId = 100;
        int roomId = 200;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(1);
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(12, 0);

        Booking created = null;
        try {
            Booking booking = new Booking(userId, roomId, date, start, end);
            created = repository.create(booking);


        } catch (SQLException e) {
            fail(e);
        }  catch(IllegalStateException ignored) {}

        assertNotNull(created);
        assertTrue(created.getBookingID() > 0);

        Optional<Booking> fetched = repository.findById(created.getBookingID());
        assertTrue(fetched.isPresent());
        Booking b = fetched.get();
        assertEquals(userId, b.getUserId());
        assertEquals(roomId, b.getRoomId());
        assertEquals(date, b.getBookingDate());
        assertEquals(start, b.getStartTime());
        assertEquals(end, b.getEndTime());
    }

    @Test
    void createBookingInPastTest() {
        int userId = 101;
        int roomId = 201;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().minusDays(1);
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(11, 0);

        Booking booking = new Booking(userId, roomId, date, start, end);
        try {
            repository.create(booking);
            fail();
        } catch (SQLException e) {
            fail(e);
        } catch (IllegalStateException ignored) {}
    }

    @Test
    void createStartAfterEndingTest() {
        int userId = 102;
        int roomId = 202;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(1);
        LocalTime start = LocalTime.of(12, 0);
        LocalTime end = LocalTime.of(11, 0);

        Booking booking = new Booking(userId, roomId, date, start, end);
        try {
            repository.create(booking);
            fail();
        } catch (SQLException e) {
            fail(e);
        } catch (IllegalStateException ignored) {}
    }

    @Test
    void createStartAndEndingSameTest() {
        int userId = 103;
        int roomId = 203;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(1);
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(10, 0);

        Booking booking = new Booking(userId, roomId, date, start, end);
        try {
            repository.create(booking);
            fail();
        } catch (SQLException e) {
            fail(e);
        } catch (IllegalStateException ignored) {}
    }

    @Test
    void createTimeTooLongTest() {
        int userId = 104;
        int roomId = 204;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(1);
        LocalTime start = LocalTime.of(8, 0);
        LocalTime end = LocalTime.of(12, 30); // 4.5 hours

        Booking booking = new Booking(userId, roomId, date, start, end);
        try {
            repository.create(booking);
            fail();
        } catch (SQLException e) {
            fail(e);
        } catch (IllegalStateException ignored) {}
    }

    @Test
    void createOverlappingBookingsTest() {
        int userId = 105;
        int roomId = 205;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(1);

        Booking first = new Booking(userId, roomId, date, LocalTime.of(10, 0), LocalTime.of(12, 0));
        try {
            repository.create(first);
        } catch (SQLException e) {
            fail(e);
        }  catch(IllegalStateException ignored) {}

        Booking overlapping = new Booking(userId, roomId, date, LocalTime.of(11, 0), LocalTime.of(13, 0));
        try {
            repository.create(overlapping);
            fail();
        } catch (SQLException e) {
            fail(e);
        } catch (IllegalStateException ignored) {}
    }

    @Test
    void findBookingByRoomIdAndDateTest(){
        int userId = 106;
        int roomId = 206;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(2);
        Booking b1 = new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0));
        try {
            repository.create(b1);
        } catch (SQLException e) {
            fail(e);
        } catch(IllegalStateException ignored) {}

        List<Booking> roomBookings = repository.findByRoomAndDate(roomId, date);

        assertEquals(1, roomBookings.size());

        Booking result = roomBookings.getFirst();
        assertEquals(roomId, result.getRoomId());
        assertEquals(LocalTime.of(9, 0), result.getStartTime());
        assertEquals(LocalTime.of(11, 0), result.getEndTime());
        assertEquals(userId, result.getUserId());
        assertEquals(date, result.getBookingDate());
    }

    @Test
    void findBookingByUserTest(){
        int userId = 107;
        int roomId = 208;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(3);

        Booking userBooking = new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0));
        try {
            repository.create(userBooking);
        } catch (SQLException e) {
            fail(e);
        }  catch(IllegalStateException ignored) {}

        List<Booking> userBookings = repository.findByUser(userId);

        assertEquals(1, userBookings.size());

        Booking result = userBookings.getFirst();
        assertEquals(userId, result.getUserId());
        assertEquals(roomId, result.getRoomId());
        assertEquals(date, result.getBookingDate());
        assertEquals(LocalTime.of(9, 0), result.getStartTime());
        assertEquals(LocalTime.of(11, 0), result.getEndTime());
    }

    @Test
    void deleteBookingTest() {
        int userId = 109;
        int roomId = 209;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(4);
        Booking booking = new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0));
        try {
            Booking created = repository.create(booking);

            int id = created.getBookingID();
            assertTrue(repository.findById(id).isPresent());
            repository.delete(id);
            assertTrue(repository.findById(id).isEmpty());
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void updateBookingTimeTest() {
        int userId = 110;
        int roomId = 210;

        cleanupBooking(userId, roomId);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(5);
        Booking booking = new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0));
        Booking created = null;

        try {
            created = repository.create(booking);
        } catch (SQLException e) {
            fail(e);
        }  catch(IllegalStateException ignored) {}

        assertNotNull(created);
        int id = created.getBookingID();
        LocalDate newDate = date.plusDays(1);
        LocalTime newStart = LocalTime.of(10, 0);
        LocalTime newEnd = LocalTime.of(12, 0);

        Booking updated = repository.updateTimes(id, newDate, newStart, newEnd);

        assertEquals(newDate, updated.getBookingDate());
        assertEquals(newStart, updated.getStartTime());
        assertEquals(newEnd, updated.getEndTime());
    }

    @Test
    void updateToInvalidBookingTimeTest() {
        int userId = 111;
        int roomId = 211;

        cleanupBookingById(7000);

        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().minusDays(1);
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(11, 0);

        String sql = "INSERT INTO bookings(id, user_id, room_id, start_time, end_time, date) " +
                "VALUES (7000, ?, ?, ?, ?, ?) " +
                "ON CONFLICT(id) DO NOTHING;";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, roomId);
            st.setString(3, start.toString());
            st.setString(4, end.toString());
            st.setString(5, date.toString());
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }

        // should fail if you try and change the date since the booking already started
        try {
            repository.updateTimes(7000, date.plusDays(1), null, null);
            fail();
        } catch (IllegalStateException ignored) {}

        // or changing the start time
        try {
            repository.updateTimes(7000, null, LocalTime.of(8, 0), null);
            fail();
        } catch (IllegalStateException ignored) {}


        // or changing the end time
        try {
            repository.updateTimes(7000, null, null, LocalTime.of(10, 0));
            fail();
        } catch (IllegalStateException ignored) {}

        // but extending should be good
        try {
            repository.updateTimes(7000, null, null, LocalTime.of(12, 0));
        } catch (IllegalStateException e) {
            fail(e);
        }
    }
}
