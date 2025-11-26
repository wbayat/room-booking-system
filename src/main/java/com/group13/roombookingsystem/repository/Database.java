package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton database class
public final class Database {
    private static final String DB_URL = "jdbc:sqlite:main.db";
    private static Database instance;
    private static Connection connection;
            
    // the getter for the link to the db (i still need this)
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(DB_URL);
        }
        return connection;
    }

    // singleton constructor for the database
    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database(); 
        }
        return instance;
    }
}
