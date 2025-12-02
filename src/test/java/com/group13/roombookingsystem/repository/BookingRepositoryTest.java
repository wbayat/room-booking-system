package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.booking.Booking;
import org.junit.jupiter.api.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookingRepositoryTest {

    private final BookingRepository repository = new BookingRepository();

    @BeforeEach
    void setupDB() {
        Database.setTestPath();
        initTestDB();
    }

    @AfterAll
    static void cleanup() throws Exception {
        Files.deleteIfExists(Path.of("test.db"));
        System.clearProperty("test.db.url");
    }

    private void initTestDB() {
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement()) {

            st.execute("DROP TABLE IF EXISTS bookings;");
            st.execute("DROP TABLE IF EXISTS users;");
            st.execute("DROP TABLE IF EXISTS rooms;");

            st.execute("""
                CREATE TABLE users(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    identification INTEGER NOT NULL,
                    role TEXT NOT NULL,
                    is_verified INTEGER NOT NULL DEFAULT 0
                );
            """);

            st.execute("""
                CREATE TABLE rooms(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    capacity INTEGER NOT NULL,
                    location TEXT NOT NULL,
                    sensorId INTEGER,
                    has_projector INTEGER NOT NULL DEFAULT 0,
                    has_speakers INTEGER NOT NULL DEFAULT 0,
                    is_enabled INTEGER NOT NULL DEFAULT 1
                );
            """);

            st.execute("""
                CREATE TABLE bookings(
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    user_id INTEGER NOT NULL,
                    room_id INTEGER NOT NULL,
                    date TEXT NOT NULL,
                    start_time TEXT NOT NULL,
                    end_time TEXT NOT NULL,
                    FOREIGN KEY(user_id) REFERENCES users(id),
                    FOREIGN KEY(room_id) REFERENCES rooms(id)
                );
            """);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize test DB", e);
        }
    }

    private void createUser(int userId) {
        String sql =
                "INSERT INTO users(id, username, password, identification, role, is_verified) " +
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
        String sql =
                "INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled) " +
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
            PreparedStatement st = c.prepareStatement("DELETE FROM bookings WHERE user_id = ? AND room_id = ?");
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
        } catch (IllegalStateException ignored) {}

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

        Booking booking = new Booking(
                userId,
                roomId,
                LocalDate.now().minusDays(1),
                LocalTime.of(10, 0),
                LocalTime.of(11, 0)
        );

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

        Booking booking = new Booking(
                userId,
                roomId,
                LocalDate.now().plusDays(1),
                LocalTime.of(12, 0),
                LocalTime.of(11, 0)
        );

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

        Booking booking = new Booking(
                userId,
                roomId,
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0),
                LocalTime.of(10, 0)
        );

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

        Booking booking = new Booking(
                userId,
                roomId,
                LocalDate.now().plusDays(1),
                LocalTime.of(8, 0),
                LocalTime.of(12, 30)
        );

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

        try {
            repository.create(new Booking(userId, roomId, date, LocalTime.of(10, 0), LocalTime.of(12, 0)));
        } catch (Exception ignored) {}

        try {
            repository.create(new Booking(userId, roomId, date, LocalTime.of(11, 0), LocalTime.of(13, 0)));
            fail();
        } catch (IllegalStateException ignored) {}
        catch (SQLException e) { fail(e); }
    }

    @Test
    void findBookingByRoomIdAndDateTest() {
        int userId = 106;
        int roomId = 206;

        cleanupBooking(userId, roomId);
        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(2);

        Booking b1 = new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0));
        try {
            repository.create(b1);
        } catch (Exception ignored) {}

        List<Booking> roomBookings = repository.findByRoomAndDate(roomId, date);

        assertEquals(1, roomBookings.size());

        Booking result = roomBookings.getFirst();
        assertEquals(roomId, result.getRoomId());
        assertEquals(userId, result.getUserId());
        assertEquals(date, result.getBookingDate());
        assertEquals(LocalTime.of(9, 0), result.getStartTime());
        assertEquals(LocalTime.of(11, 0), result.getEndTime());
    }

    @Test
    void findBookingByUserTest() {
        int userId = 107;
        int roomId = 208;

        cleanupBooking(userId, roomId);
        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(3);

        try {
            repository.create(new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0)));
        } catch (Exception ignored) {}

        List<Booking> bookings = repository.findByUser(userId);

        assertEquals(1, bookings.size());

        Booking b = bookings.getFirst();
        assertEquals(userId, b.getUserId());
        assertEquals(roomId, b.getRoomId());
        assertEquals(date, b.getBookingDate());
        assertEquals(LocalTime.of(9, 0), b.getStartTime());
        assertEquals(LocalTime.of(11, 0), b.getEndTime());
    }

    @Test
    void deleteBookingTest() {
        int userId = 109;
        int roomId = 209;

        cleanupBooking(userId, roomId);
        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().plusDays(4);

        try {
            Booking created = repository.create(
                    new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0))
            );

            assertTrue(repository.findById(created.getBookingID()).isPresent());

            repository.delete(created.getBookingID());

            assertTrue(repository.findById(created.getBookingID()).isEmpty());

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

        Booking created = null;
        try {
            created = repository.create(
                    new Booking(userId, roomId, date, LocalTime.of(9, 0), LocalTime.of(11, 0))
            );
        } catch (Exception ignored) {}

        assertNotNull(created);

        Booking updated = repository.updateTimes(
                created.getBookingID(),
                date.plusDays(1),
                LocalTime.of(10, 0),
                LocalTime.of(12, 0)
        );

        assertEquals(date.plusDays(1), updated.getBookingDate());
        assertEquals(LocalTime.of(10, 0), updated.getStartTime());
        assertEquals(LocalTime.of(12, 0), updated.getEndTime());
    }

    @Test
    void updateToInvalidBookingTimeTest() {
        int userId = 111;
        int roomId = 211;

        cleanupBookingById(7000);
        createUser(userId);
        createRoom(roomId);

        LocalDate date = LocalDate.now().minusDays(1);

        String sql = """
            INSERT INTO bookings(id, user_id, room_id, start_time, end_time, date)
            VALUES (7000, ?, ?, ?, ?, ?)
            ON CONFLICT(id) DO NOTHING;
        """;

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, roomId);
            st.setString(3, "09:00");
            st.setString(4, "11:00");
            st.setString(5, date.toString());
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }

        // cannot change date
        assertThrows(IllegalStateException.class,
                () -> repository.updateTimes(7000, date.plusDays(1), null, null));

        // cannot change start time
        assertThrows(IllegalStateException.class,
                () -> repository.updateTimes(7000, null, LocalTime.of(8, 0), null));

        // cannot change end time backwards
        assertThrows(IllegalStateException.class,
                () -> repository.updateTimes(7000, null, null, LocalTime.of(10, 0)));

        // extending end time is allowed
        assertDoesNotThrow(
                () -> repository.updateTimes(7000, null, null, LocalTime.of(12, 0))
        );
    }
}
