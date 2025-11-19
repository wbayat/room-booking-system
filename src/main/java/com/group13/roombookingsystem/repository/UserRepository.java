package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final String INSERT_USER = "INSERT INTO users(username, password, role, is_verified) VALUES (?, ?, ?, ?);";
    private static final String FIND_BY_USERNAME = "SELECT id, username, password, role, is_verified FROM users WHERE username = ?;";
    private static final String FIND_BY_ID = "SELECT id, username, password, role, is_verified FROM users WHERE id = ?;";
    private static final String FIND_ALL = "SELECT id, username, password, role, is_verified FROM users ORDER BY username;";
    private static final String FIND_BY_VERIFICATION = "SELECT id, username, password, role, is_verified FROM users WHERE is_verified = ? ORDER BY username;";
    private static final String UPDATE_VERIFICATION = "UPDATE users SET is_verified = ? WHERE id = ?;";

    public User create(User user) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setInt(4, user.isVerified() ? 1 : 0);
            int affectedRows = statement.executeUpdate();
            
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }

            return user;
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to create user", e);
        }
    }

    public void updateVerification(int userId, boolean verified) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_VERIFICATION)) {
            statement.setInt(1, verified ? 1 : 0);
            statement.setInt(2, userId);
            int affected = statement.executeUpdate();
            if (affected == 0) {
                throw new SQLException("No user updated for verification.");
            }
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to update verification state", e);
        }
    }

    public Optional<User> findByUsername(String username) {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_USERNAME)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
            }
            return Optional.empty();
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to query user", e);
        }
    }

    public Optional<User> findById(int id) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapRow(resultSet));
                }
            }

            return Optional.empty();
        }
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to query user by id", e);
        }
    }

    public List<User> findAll() {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(mapRow(resultSet));
            }
            return users;
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to query all users", e);
        }
    }

    public List<User> findByVerification(boolean verified) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_VERIFICATION)) {
            statement.setInt(1, verified ? 1 : 0);
           
            try (ResultSet resultSet = statement.executeQuery()) {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    users.add(mapRow(resultSet));
                }
                return users;
            }
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to query users by verification", e);
        }
    }

    private User mapRow(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("role"),
                resultSet.getInt("is_verified") == 1
        );
    }
}
