package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.room.RoomBuilder;
import com.group13.roombookingsystem.model.sensor.Sensor;
import org.junit.jupiter.api.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomRepositoryTest {

    private final RoomRepository repository = new RoomRepository();

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

            st.execute("DROP TABLE IF EXISTS rooms;");

            st.execute("""
                CREATE TABLE rooms (
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

        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize test DB", e);
        }
    }
    private Room createRoom(String name, int capacity, String location, int sensorId,
                            boolean hasProjector, boolean hasSpeakers, boolean enabled) {
        RoomBuilder builder = new RoomBuilder();
        builder.reset();
        builder.setRoomName(name);
        builder.setCapacity(capacity);
        builder.setLocation(location);
        builder.setSensor(new Sensor(sensorId));
        builder.setHasProjector(hasProjector);
        builder.setHasSpeakers(hasSpeakers);
        builder.setEnabled(enabled);
        return builder.getProduct();
    }

    @Test
    void createRoomTest() {
        Room room = createRoom("JUnitRoom1", 10, "TestLocation1", 101, false, false, true);
        repository.create(room);

        String sql = "SELECT * FROM rooms WHERE name = 'JUnitRoom1'";

        try (Connection connection = Database.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            assertTrue(rs.next());
            assertEquals(10, rs.getInt("capacity"));
            assertEquals(101, rs.getInt("sensorId"));
            assertEquals(0, rs.getInt("has_projector"));
            assertEquals(0, rs.getInt("has_speakers"));
            assertEquals(1, rs.getInt("is_enabled"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void projectorAndSpeakerTest() {
        Room room = createRoom("JUnitRoom2", 20, "TestLocation2", 102, true, true, true);
        repository.create(room);

        try (Connection connection = Database.getConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT * FROM rooms WHERE name='JUnitRoom2'")) {

            assertTrue(rs.next());
            assertEquals(1, rs.getInt("has_projector"));
            assertEquals(1, rs.getInt("has_speakers"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void searchByIdTest() {
        try (Connection connection = Database.getConnection()) {
            connection.createStatement().execute("""
                INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled)
                VALUES (9001, 'FindByIdRoom', 30, 'LocA', 201, 1, 0, 1)
            """);
        } catch (SQLException e) {
            fail(e);
        }

        Room room = repository.findById(9001).orElse(null);

        assertNotNull(room);
        assertEquals("FindByIdRoom", room.getRoomName());
        assertEquals(30, room.getCapacity());
        assertEquals("LocA", room.getLocation());
        assertEquals(201, room.getSensorId());
        assertTrue(room.getHasProjector());
        assertFalse(room.getHasSpeakers());
        assertTrue(room.isEnabled());
    }

    @Test
    void searchByIdNotFoundTest() {
        assertTrue(repository.findById(4526785).isEmpty());
    }

    @Test
    void findAllTest() {
        repository.create(createRoom("R1", 40, "L1", 301, false, true, true));
        repository.create(createRoom("R2", 50, "L2", 302, true, false, true));

        List<Room> rooms = repository.findAll();
        assertEquals(2, rooms.size());
    }

    @Test
    void updateRoomTest() {
        try (Connection connection = Database.getConnection()) {
            connection.createStatement().execute("""
                INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled)
                VALUES (9100, 'OldName', 10, 'OldLoc', 401, 0, 0, 1)
            """);
        } catch (SQLException e) {
            fail(e);
        }

        RoomBuilder builder = new RoomBuilder();
        builder.reset();
        builder.setRoomID(9100);
        builder.setRoomName("NewName");
        builder.setCapacity(50);
        builder.setLocation("NewLoc");
        builder.setSensor(new Sensor(402));
        builder.setHasProjector(true);
        builder.setHasSpeakers(true);
        builder.setEnabled(false);

        repository.update(builder.getProduct());

        try (Connection connection = Database.getConnection();
             ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM rooms WHERE id = 9100")) {

            assertTrue(rs.next());
            assertEquals("NewName", rs.getString("name"));
            assertEquals(50, rs.getInt("capacity"));
            assertEquals("NewLoc", rs.getString("location"));
            assertEquals(402, rs.getInt("sensorId"));
            assertEquals(1, rs.getInt("has_projector"));
            assertEquals(1, rs.getInt("has_speakers"));
            assertEquals(0, rs.getInt("is_enabled"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void updateNonExistingRoomTest() {
        Room fake = createRoom("Nope", 5, "X", 999, false, false, true);
        RoomBuilder b = new RoomBuilder();
        b.reset();
        b.setRoomID(999999);
        b.setRoomName(fake.getRoomName());
        b.setCapacity(fake.getCapacity());
        b.setLocation(fake.getLocation());
        b.setSensor(new Sensor(fake.getSensorId()));
        b.setHasProjector(fake.getHasProjector());
        b.setHasSpeakers(fake.getHasSpeakers());
        b.setEnabled(fake.isEnabled());

        assertThrows(IllegalStateException.class, () -> repository.update(b.getProduct()));
    }

    @Test
    void disabledRoomTest() {
        repository.create(createRoom("DisabledRoom", 15, "DL", 500, false, false, false));

        try (Connection connection = Database.getConnection();
             ResultSet rs = connection.createStatement()
                     .executeQuery("SELECT is_enabled FROM rooms WHERE name='DisabledRoom'")) {

            assertTrue(rs.next());
            assertEquals(0, rs.getInt("is_enabled"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void emptyFindAllTest() {
        assertNotNull(repository.findAll());
    }

    @Test
    void roomSensorByIdTest() {
        try (Connection connection = Database.getConnection()) {
            connection.createStatement().execute("""
                INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled)
                VALUES (9300, 'SensorRoom', 25, 'SensorLoc', 777, 0, 0, 1)
            """);
        } catch (SQLException e) {
            fail(e);
        }

        Room room = repository.findById(9300).orElse(null);
        assertNotNull(room);
        assertEquals(777, room.getSensorId());
    }
}
