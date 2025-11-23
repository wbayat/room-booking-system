package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.room.RoomBuilder;

public class RoomRepository {
    private static final String INSERT_ROOM = """
            INSERT INTO rooms(name, capacity, location)
            VALUES (?, ?, ?);
            """;
    private static final String FIND_BY_NAME = """
            SELECT name, capacity, location
            FROM rooms
            WHERE name = ?;
            """;
    private static final String FIND_ALL = """
            SELECT name, capacity, location
            FROM rooms
            ORDER BY name;
            """;

    public void create(Room room) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_ROOM, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, room.getRoomName());
            statement.setInt(2, room.getCapacity());
            statement.setString(3, room.getLocation());
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to create room", e);
        }
    }

    public Optional<Room> findById(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
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
        RoomBuilder builder = new RoomBuilder();
        builder.reset();
        builder.setRoomID(resultSet.getInt("id"));
        builder.setRoomName(resultSet.getString("name"));
        builder.setCapacity(resultSet.getInt("capacity"));
        builder.setLocation(resultSet.getString("location"));
        builder.setHasProjector(resultSet.getBoolean("has_projector"));
        builder.setHasSpeakers(resultSet.getBoolean("has_speakers"));
        setUserIdFromDatabase(builder.getProduct(), resultSet);

        return builder.getProduct();
    }

    private void setUserIdFromDatabase(Room r, ResultSet resultSet) throws SQLException {
        r.setRoomId(resultSet.getInt("id"));
    }

    public Room update(Room room) {
        final String UPDATE_ROOM = """
                UPDATE rooms
                SET name = ?, capacity = ?, location = ?, has_projector = ?, has_speakers = ?
                WHERE id = ?;
                """;
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM)) {

            statement.setString(1, room.getRoomName());
            statement.setInt(2, room.getCapacity());
            statement.setString(3, room.getLocation());
            statement.setBoolean(4, room.getHasProjector());
            statement.setBoolean(5, room.getHasSpeakers());
            statement.setInt(6, room.getRoomID());

            int affected = statement.executeUpdate();
            if (affected == 0) {
                throw new IllegalStateException("No room found with id: " + room.getRoomID());
            }

            return room;
        } catch (SQLException e) {
            throw new IllegalStateException("Unable to update room", e);
        }
    }
}
