package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.room.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomRepository {
    private static final String INSERT_ROOM = """
            INSERT INTO rooms(name, capacity, location)
            VALUES (?, ?, ?);
            """;
    private static final String FIND_BY_ID = """
            SELECT id, name, capacity, location
            FROM rooms
            WHERE id = ?;
            """;
    private static final String FIND_ALL = """
            SELECT id, name, capacity, location
            FROM rooms
            ORDER BY name;
            """;

    public Room create(Room room) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ROOM, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, room.getName());
            statement.setInt(2, room.getCapacity());
            statement.setString(3, room.getLocation());

            int affected = statement.executeUpdate();
            if (affected == 0) {
                throw new SQLException("Creating room failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    room.setId(generatedKeys.getInt(1));
                }
            }
            return room;
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to create room", e);
        }
    }

    public Optional<Room> findById(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch room by id", e);
        }
    }

    public List<Room> findAll() {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<Room> rooms = new ArrayList<>();
            while (resultSet.next()) {
                rooms.add(mapRow(resultSet));
            }
            return rooms;
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch rooms", e);
        }
    }

    private Room mapRow(ResultSet resultSet) throws SQLException {
        return Room.builder(resultSet.getString("name"), resultSet.getInt("capacity"))
                .id(resultSet.getInt("id"))
                .locatedAt(resultSet.getString("location"))
                .build();
    }
}
