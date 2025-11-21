package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.group13.roombookingsystem.model.user.Admin;
import com.group13.roombookingsystem.model.user.ChiefEventCoordinator;
import com.group13.roombookingsystem.model.user.Faculty;
import com.group13.roombookingsystem.model.user.Partner;
import com.group13.roombookingsystem.model.user.Staff;
import com.group13.roombookingsystem.model.user.Student;
import com.group13.roombookingsystem.model.user.User;

public class UserRepository {
    private static final String INSERT_USER = "INSERT INTO users(username, password, role, is_verified) VALUES (?, ?, ?, ?);";
    private static final String FIND_BY_USERNAME = "SELECT id, username, password, role, is_verified FROM users WHERE username = ?;";
    private static final String FIND_BY_ID = "SELECT id, username, password, role, is_verified FROM users WHERE id = ?;";
    private static final String FIND_ALL = "SELECT id, username, password, role, is_verified FROM users WHERE LOWER(role) <> 'admin' ORDER BY username;";
    private static final String FIND_BY_VERIFICATION = "SELECT id, username, password, role, is_verified FROM users WHERE is_verified = ? AND LOWER(role) <> 'admin' ORDER BY username;";
    private static final String UPDATE_VERIFICATION = "UPDATE users SET is_verified = CASE WHEN LOWER(role) IN ('partner','admin','chiefeventcoordinator') THEN 1 ELSE ? END WHERE id = ?;";

    public User create(User user) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            boolean verified = user.isVerified() || isAutoVerifiedRole(user.getRole());
            user.setVerified(verified);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getRole());
            statement.setInt(4, user.getVerifiedValue());
            statement.executeUpdate();

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
            statement.executeUpdate();
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to update verification state", e);
        }
    }

    public Optional<User> findByUsername(String username) {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(FIND_BY_USERNAME)) {
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
        String role = resultSet.getString("role");
        boolean verified = resultSet.getInt("is_verified") == 1 || isAutoVerifiedRole(role);
        User user;

        switch (role) {
            case "Student":
                user = new Student(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
                break;

            case "Faculty":
                user = new Faculty(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
                break;

            case "Staff":
                user = new Staff(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
                break;

            case "Partner":
                user = new Partner(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
                break;

            case "Admin":
                user = new Admin(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
                break;

            case "ChiefEventCoordinator":
                user = new ChiefEventCoordinator(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
                break;

            default:
                user = new Student(resultSet.getString("email"), resultSet.getString("password"), resultSet.getInt("identification"),"Student", verified);
        }

        setUserIdFromDatabase(user, resultSet);
        return user;
    }
    
    private void setUserIdFromDatabase(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("id"));
    }

    private boolean isAutoVerifiedRole(String role) {
        if (role == null) {
            return false;
        }
        String normalized = role.trim().toLowerCase();
        return normalized.equals("partner") || normalized.equals("admin") || normalized.equals("chiefeventcoordinator");
    }
}
