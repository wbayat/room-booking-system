package com.group13.roombookingsystem.repository;

import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @Test
    void getInstance() {
        Database database = Database.getInstance();
        assertNotNull(database);
    }

    @Test
    void getMultipleInstances() {
        Database database1 = Database.getInstance();
        Database database2 = Database.getInstance();

        assertSame(database1, database2);
    }

    @Test
    void getConnection() {
        try (Connection connection = Database.getConnection()) {
            assertFalse(connection.isClosed());
        }
        catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void getMultipleConnections() {
        try (Connection connection = Database.getConnection()) {
            assertFalse(connection.isClosed());
        }
        catch (SQLException e) {
            fail(e);
        }

        try (Connection connection = Database.getConnection()) {
            assertFalse(connection.isClosed());
        }
        catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createTable() {
        String targetStatement = "CREATE TABLE IF NOT EXISTS `junittest` (" +
                "`id` INT(20) NOT NULL," +
                " `firstname` VARCHAR(20) NOT NULL," +
                " `lastname` VARCHAR(20) NOT NULL," +
                " `age` INT(20) NOT NULL," +
                " PRIMARY KEY (`id`)" +
                ");";

        try (Connection connection = Database.getConnection()) {
            assertNotNull(connection);

            PreparedStatement statement = connection.prepareStatement(targetStatement, Statement.RETURN_GENERATED_KEYS);
            statement.execute();


            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "junittest", null);
            assertTrue(resultSet.next());
        }
        catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void deleteTable() {
        createTable();

        String targetStatement = "DROP TABLE IF EXISTS `junittest`;";

        try (Connection connection = Database.getConnection()) {
            assertNotNull(connection);

            PreparedStatement statement = connection.prepareStatement(targetStatement, Statement.RETURN_GENERATED_KEYS);
            statement.execute();

            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, "junittest", null);
            assertFalse(resultSet.next());
        }
        catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createRow() {
        createTable();

        String targetStatement = "INSERT INTO `junittest` (id, firstname, lastname, age)" +
                " VALUES (1, 'John', 'Doe', 32) ON CONFLICT (id) DO NOTHING;";

        try (Connection connection = Database.getConnection()) {
            assertNotNull(connection);

            PreparedStatement statement = connection.prepareStatement(targetStatement, Statement.RETURN_GENERATED_KEYS);
            statement.execute();
        }
        catch (SQLException e) {
            fail(e);
        }

    }

    @Test
    void selectRow() {
        createTable();
        createRow();

        String targetStatement = "SELECT * FROM `junittest`" +
                " WHERE id = 1;";

        try (Connection connection = Database.getConnection()) {
            assertNotNull(connection);

            PreparedStatement statement = connection.prepareStatement(targetStatement, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            assertTrue(resultSet.next());
            assertEquals(1, resultSet.getInt("id"));
            assertEquals("John", resultSet.getString("firstname"));
            assertEquals("Doe", resultSet.getString("lastname"));
            assertEquals(32, resultSet.getInt("age"));
        }
        catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void selectEmpty() {
        createTable();

        String targetStatement = "SELECT * FROM `junittest`" +
                " WHERE id = 2;";

        try (Connection connection = Database.getConnection()) {
            assertNotNull(connection);

            PreparedStatement statement = connection.prepareStatement(targetStatement, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            assertFalse(resultSet.next());
        }
        catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void deleteRow() {
        createTable();
        createRow();
        selectRow();

        String targetStatement1 = "DELETE FROM `junittest`" +
                " WHERE id = 1;";

        String targetStatement2 = "SELECT * FROM `junittest`" +
                " WHERE id = 1;";

        try (Connection connection = Database.getConnection()) {
            assertNotNull(connection);

            PreparedStatement statement = connection.prepareStatement(targetStatement1, Statement.RETURN_GENERATED_KEYS);
            statement.execute();

            statement = connection.prepareStatement(targetStatement2, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();

            assertFalse(resultSet.next());
        }
        catch (SQLException e) {
            fail(e);
        }
    }
}