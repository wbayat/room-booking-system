package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// singleton database class
public final class Database {
    private static final String DB_URL = "jdbc:sqlite:main.db";

    private static final String CREATE_USERS =
            "CREATE TABLE IF NOT EXISTS users (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " username TEXT NOT NULL UNIQUE," +
            " password TEXT NOT NULL," +
            " role TEXT NOT NULL," +
            " is_verified INTEGER NOT NULL DEFAULT 0" +
            ");";

    private static final String CREATE_ROOMS =
            "CREATE TABLE IF NOT EXISTS rooms (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " name TEXT NOT NULL," +
            " capacity INTEGER NOT NULL," +
            " location TEXT" +
            ");";

    private static final String CREATE_BOOKINGS =
            "CREATE TABLE IF NOT EXISTS bookings (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " user_id INTEGER NOT NULL," +
            " room_id INTEGER NOT NULL," +
            " start_time TEXT NOT NULL," +
            " end_time TEXT NOT NULL," +
            " date TEXT NOT NULL," +
            " FOREIGN KEY(user_id) REFERENCES users(id)," +
            " FOREIGN KEY(room_id) REFERENCES rooms(id)" +
            ");";

    private static final String CREATE_PAYMENTS =
            "CREATE TABLE IF NOT EXISTS payments (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " user_id INTEGER NOT NULL," +
            " amount REAL NOT NULL," +
            " date TEXT NOT NULL," +
            " FOREIGN KEY(user_id) REFERENCES users(id)" +
            ");";

    private Database() {

    }

    // the getter for the singleton class
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // how to start it up
    public static void initialize() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON;");
            statement.execute(CREATE_USERS);
            statement.execute(CREATE_ROOMS);
            statement.execute(CREATE_BOOKINGS);
            statement.execute(CREATE_PAYMENTS);
            ensureColumn(connection, "users", "is_verified", "INTEGER NOT NULL DEFAULT 0");
        } 
       
        catch (SQLException e) {
            throw new IllegalStateException("Cannot initialize SQLite schema", e);
        }
    }

    private static void ensureColumn(Connection connection, String table, String column, String definition) throws SQLException {
        if (!columnExists(connection, table, column)) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("ALTER TABLE " + table + " ADD COLUMN " + column + " " + definition + ";");
            }
        }
    }

    private static boolean columnExists(Connection connection, String table, String column) throws SQLException {
        String pragma = "PRAGMA table_info('" + table + "');";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(pragma)) {
            while (resultSet.next()) {
                if (column.equalsIgnoreCase(resultSet.getString("name"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
