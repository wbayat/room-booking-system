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
import com.group13.roombookingsystem.model.sensor.Sensor;

public class RoomRepository {

    public void create(Room room) {
        final String sql = "INSERT INTO rooms(name, capacity, location, sensorId, has_projector, has_speakers, is_enabled) VALUES (?, ?, ?, ?, ?, ?, ?); ";
            
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, room.getRoomName());
            statement.setInt(2, room.getCapacity());
            statement.setString(3, room.getLocation());
            statement.setInt(4, room.getSensorId());
            statement.setBoolean(5, room.getHasProjector());
            statement.setBoolean(6, room.getHasSpeakers());
            statement.setBoolean(7, room.isEnabled());
            statement.executeUpdate();
        }
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to create room", e);
        }
    }

    public Optional<Room> findById(int id) {
        final String sql = "SELECT id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled FROM rooms WHERE id = ?;";

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
                return Optional.empty();
            }
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to fetch room by id", e);
        }
    }

    public List<Room> findAll() {
        final String sql = "SELECT id, name, capacity, location, sensorId, has_projector, has_speakers, is_enabled FROM rooms ORDER BY name;";
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            
            List<Room> rooms = new ArrayList<>();

            while (resultSet.next()) {
                rooms.add(mapRow(resultSet));
            }

            return rooms;
        } 
        
        catch (SQLException e) {
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
        int sensorId = resultSet.getInt("sensorId");
        builder.setSensor(new Sensor(sensorId));
        builder.setHasProjector(resultSet.getBoolean("has_projector"));
        builder.setHasSpeakers(resultSet.getBoolean("has_speakers"));
        builder.setEnabled(resultSet.getBoolean("is_enabled"));

        return builder.getProduct();
    }

    public Room update(Room room) {
        final String UPDATE_ROOM = "UPDATE rooms SET name = ?, capacity = ?, location = ?, sensorId = ?, has_projector = ?, has_speakers = ?, is_enabled = ? WHERE id = ?;";
        
            try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ROOM)) {
                statement.setString(1, room.getRoomName());
                statement.setInt(2, room.getCapacity());
                statement.setString(3, room.getLocation());
                statement.setInt(4, room.getSensorId());
                statement.setBoolean(5, room.getHasProjector());
                statement.setBoolean(6, room.getHasSpeakers());
                statement.setBoolean(7, room.isEnabled());
                statement.setInt(8, room.getRoomID());

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
