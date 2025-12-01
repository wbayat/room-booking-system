package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.room.RoomBuilder;
import com.group13.roombookingsystem.model.sensor.Sensor;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomRepositoryTest {

    private final RoomRepository repository = new RoomRepository();

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

        String sql = "SELECT * FROM rooms WHERE name = ? AND location = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "JUnitRoom1");
            statement.setString(2, "TestLocation1");

            ResultSet rs = statement.executeQuery();
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

        String sql = "SELECT * FROM rooms WHERE name = ? AND location = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "JUnitRoom2");
            statement.setString(2, "TestLocation2");

            ResultSet rs = statement.executeQuery();
            assertTrue(rs.next());
            assertEquals(1, rs.getInt("has_projector"));
            assertEquals(1, rs.getInt("has_speakers"));
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void searchByIdTest() {
        String insert = "INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled) " +
                "VALUES (9001, 'FindByIdRoom', 30, 'LocA', 201, 1, 0, 1) " +
                "ON CONFLICT(id) DO NOTHING;";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(insert).execute();
        } catch (SQLException e) {
            fail(e);
        }

        Room room = repository.findById(9001).orElse(null);

        assertNotNull(room);
        assertEquals(9001, room.getRoomID());
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
        Room room1 = createRoom("JUnitRoomAll1", 40, "LocAll1", 301, false, true, true);
        Room room2 = createRoom("JUnitRoomAll2", 50, "LocAll2", 302, true, false, true);

        repository.create(room1);
        repository.create(room2);

        List<Room> rooms = repository.findAll();
        assertNotNull(rooms);

        Room found1 = null;
        Room found2 = null;

        for (Room r : rooms) {
            if ("JUnitRoomAll1".equals(r.getRoomName()) && "LocAll1".equals(r.getLocation())) {
                found1 = r;
            } else if ("JUnitRoomAll2".equals(r.getRoomName()) && "LocAll2".equals(r.getLocation())) {
                found2 = r;
            }
        }

        assertNotNull(found1);
        assertEquals(40, found1.getCapacity());
        assertEquals(301, found1.getSensorId());
        assertFalse(found1.getHasProjector());
        assertTrue(found1.getHasSpeakers());
        assertTrue(found1.isEnabled());

        assertNotNull(found2);
        assertEquals(50, found2.getCapacity());
        assertEquals(302, found2.getSensorId());
        assertTrue(found2.getHasProjector());
        assertFalse(found2.getHasSpeakers());
        assertTrue(found2.isEnabled());
    }


    @Test
    void updateRoomTest() {
        String sql = "INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled) " +
                "VALUES (9100, 'OldName', 10, 'OldLoc', 401, 0, 0, 1) " +
                "ON CONFLICT(id) DO NOTHING;";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();
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
        Room updated = builder.getProduct();

        Room result = repository.update(updated);
        assertNotNull(result);

        sql = "SELECT * FROM rooms WHERE id = 9100";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

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
        Room room = createRoom("NonExistingRoom", 5, "Nowhere", 999, false, false, true);

        RoomBuilder builder = new RoomBuilder();
        builder.reset();
        builder.setRoomID(54126781);
        builder.setRoomName(room.getRoomName());
        builder.setCapacity(room.getCapacity());
        builder.setLocation(room.getLocation());
        builder.setSensor(new Sensor(room.getSensorId()));
        builder.setHasProjector(room.getHasProjector());
        builder.setHasSpeakers(room.getHasSpeakers());
        builder.setEnabled(room.isEnabled());
        Room withId = builder.getProduct();

        try {
            repository.update(withId);
            fail();
        } catch(IllegalStateException ignored) {}
    }

    @Test
    void disabledRoomTest() {
        Room room = createRoom("DisabledRoom", 15, "DisabledLoc", 500, false, false, false);
        repository.create(room);

        String sql = "SELECT * FROM rooms WHERE name = ? AND location = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "DisabledRoom");
            statement.setString(2, "DisabledLoc");

            ResultSet rs = statement.executeQuery();
            assertTrue(rs.next());
            assertEquals(0, rs.getInt("is_enabled"));
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void emptyFindAllTest() {
        List<Room> rooms = repository.findAll();
        assertNotNull(rooms);
    }

    @Test
    void roomSensorByIdTest() {
        String insert = "INSERT INTO rooms(id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled) " +
                "VALUES (9300, 'SensorRoom', 25, 'SensorLoc', 777, 0, 0, 1) " +
                "ON CONFLICT(id) DO NOTHING;";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(insert).execute();
        } catch (SQLException e) {
            fail(e);
        }

        Room room = repository.findById(9300).orElse(null);
        assertNotNull(room);
        assertEquals(777, room.getSensorId());
    }
}
