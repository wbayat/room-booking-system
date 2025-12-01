package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.repository.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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