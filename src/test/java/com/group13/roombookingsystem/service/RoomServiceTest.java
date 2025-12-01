package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.repository.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomServiceTest {

    RoomService roomService;

    @BeforeEach
    void setup() {
        Database.setTestPath();
        initTestDB();
        RoomService.resetSingleton();
        roomService = RoomService.getInstance();
    }

    @AfterAll
    static void cleanup() throws Exception {
        Path path = Path.of("test.db");
        if (Files.exists(path)) {
            Files.deleteIfExists(path);
        }
        System.clearProperty("test.db.url");
    }

    @Test
    void testSingleton() {
        RoomService r1 = RoomService.getInstance();
        RoomService r2 = RoomService.getInstance();
        assertSame(r1, r2);
    }

    @Test
    void testResetSingleton() {
        RoomService r1 = RoomService.getInstance();
        RoomService.resetSingleton();
        RoomService r2 = RoomService.getInstance();
        assertNotSame(r1, r2);
    }

    @Test
    void testAddRoom() {
        roomService.addRoom("Lecture Hall A", 100, "VH", true, false, new ArrayList<LocalDateTime>(), 12345);

        List<Room> roomsInMemory = roomService.getRooms();
        assertEquals(1, roomsInMemory.size());

        Room addedRoom = roomsInMemory.getFirst();
        assertEquals("Lecture Hall A", addedRoom.getRoomName());
        assertEquals(100, addedRoom.getCapacity());
        assertEquals("VH", addedRoom.getLocation());
        assertTrue(addedRoom.getHasProjector());
        assertFalse(addedRoom.getHasSpeakers());
        assertTrue(addedRoom.isEnabled());
        assertNotNull(addedRoom.getSensor());
        assertEquals(12345, addedRoom.getSensor().getSensorID());
    }

    @Test
    void testAddMultipleRooms() {
        roomService.addRoom("Room A", 5, "BRG", false, true, new ArrayList<>(), 99999);
        roomService.addRoom("Room D", 8, "BRG", true, true, new ArrayList<>(), 11111);

        assertEquals(2, roomService.getRooms().size());
    }

    @Test
    void testModifyRoom() {
        roomService.addRoom("Room A", 5, "BRG", false, true, new ArrayList<>(), 99999);

        Room roomToModify = roomService.getRooms().getFirst();
        assertEquals("Room A", roomToModify.getRoomName());

        roomService.modifyRoom(roomToModify, "Room B", 7, "Scott", true, true, 77777);

        assertEquals("Room B", roomToModify.getRoomName());
        assertEquals(7, roomToModify.getCapacity());
        assertEquals("Scott", roomToModify.getLocation());
        assertTrue(roomToModify.getHasProjector());
        assertTrue(roomToModify.getHasSpeakers());
        assertEquals(77777, roomToModify.getSensor().getSensorID());
    }

    @Test
    void testDisableRoom() {
        roomService.addRoom("Room A", 5, "BRG", false, true, new ArrayList<>(), 99999);
        Room room = roomService.getRooms().getFirst();

        assertTrue(room.isEnabled());

        roomService.disableRoom(room);
        assertFalse(room.isEnabled());
    }

    @Test
    void testEnableRoom() {
        roomService.addRoom("Room A", 5, "BRG", false, true, new ArrayList<>(), 99999);
        Room room = roomService.getRooms().getFirst();
        roomService.disableRoom(room);
        assertFalse(room.isEnabled());

        roomService.disableRoom(room);
        assertTrue(room.isEnabled());
    }

    private void initTestDB() {
        String DROP_USERS = "DROP TABLE IF EXISTS users;";
        String DROP_ROOMS = "DROP TABLE IF EXISTS rooms;";
        String DROP_BOOKINGS = "DROP TABLE IF EXISTS bookings;";
        String DROP_PAYMENTS = "DROP TABLE IF EXISTS payments;";

        String CREATE_ROOMS =
                "CREATE TABLE IF NOT EXISTS rooms (" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " name TEXT NOT NULL," +
                        " capacity INTEGER NOT NULL," +
                        " location TEXT NOT NULL," +
                        " sensorId INTEGER," +
                        " has_projector INTEGER NOT NULL DEFAULT 0," +
                        " has_speakers INTEGER NOT NULL DEFAULT 0," +
                        " is_enabled INTEGER NOT NULL DEFAULT 1" +
                        ");";

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute("PRAGMA foreign_keys = ON;");
            statement.execute(DROP_USERS);
            statement.execute(DROP_ROOMS);
            statement.execute(DROP_BOOKINGS);
            statement.execute(DROP_PAYMENTS);

            statement.execute(CREATE_ROOMS);

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot initialize SQLite schema", e);
        }
    }
}