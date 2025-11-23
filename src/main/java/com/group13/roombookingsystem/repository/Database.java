package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// singleton database class
public final class Database {
    private static final String DB_URL = "jdbc:sqlite:main.db";
    private static Database instance;

    private static final String CREATE_USERS =
            "CREATE TABLE IF NOT EXISTS users (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " username TEXT NOT NULL UNIQUE," +
            " password TEXT NOT NULL," +
            " identification INTEGER NOT NULL," +
            " role TEXT NOT NULL," +
            " is_verified INTEGER NOT NULL DEFAULT 0" +
            ");";

    private static final String CREATE_ROOMS =
            "CREATE TABLE IF NOT EXISTS rooms (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " name TEXT NOT NULL," +
            " capacity INTEGER NOT NULL," +
            " location TEXT NOT NULL," +
            " has_projector INTEGER NOT NULL DEFAULT 0," +
            " has_speakers INTEGER NOT NULL DEFAULT 0," +
            " is_enabled INTEGER NOT NULL DEFAULT 1" +
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

            // lowkey this table is kinda dumb and but im tired and if it works it works
    private static final String CREATE_PAYMENTS =
            "CREATE TABLE IF NOT EXISTS payments (" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " user_id INTEGER NOT NULL," +
            " booking_id INTEGER NOT NULL," +
            " amount REAL NOT NULL," +
            " date TEXT NOT NULL," +
            " type TEXT NOT NULL," +
            " cardNumber INT," + // cardNumber null on institutional
            " passCode INT," + // cvv for credit, pin for debit, null on institutional
            " cardHolder TEXT NOT NULL," + // name for credit/debit, department for institituional
            " expiryDate TEXT," + // only for credit
            " FOREIGN KEY(user_id) REFERENCES users(id)," +
            " FOREIGN KEY(booking_id) REFERENCES bookings(id)" +
            ");";
            
    // the getter for the link to the db (i still need this)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // singleton constructor for the database
    private Database() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON;");
            statement.execute(CREATE_USERS);
            statement.execute(CREATE_ROOMS);
            statement.execute(CREATE_BOOKINGS);
            statement.execute(CREATE_PAYMENTS);
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Cannot initialize SQLite schema", e);
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database(); 
        }
        return instance;
    }

    // can talk directly to the db now using this not thru connection
    public void query(String sqlCommand) {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCommand);
        } 
        
        catch (SQLException e) {
            throw new RuntimeException("Error executing query: " + sqlCommand, e);
        }
    }

    // uses select and returns a set from db :P
    public ResultSet select(String sqlCommand) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sqlCommand);
        } 
        
        catch (SQLException e) {
            throw new RuntimeException("Error executing select: " + sqlCommand, e);
        }
    }

}
