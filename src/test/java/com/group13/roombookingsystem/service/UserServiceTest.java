package com.group13.roombookingsystem.service;

import com.group13.roombookingsystem.exception.UserNotFoundException;
import com.group13.roombookingsystem.exception.UserNotVerifiedExeption;
import com.group13.roombookingsystem.model.user.Admin;
import com.group13.roombookingsystem.repository.Database;
import com.group13.roombookingsystem.model.user.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    BookingService bookingService;
    UserService userService;

    @BeforeEach
    void setup(){
        Database.setTestPath();
        initTestDB();
        UserService.resetSingleton();
        userService = UserService.getInstance();
        bookingService = BookingService.getInstance();
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
    void testRegisterUser_success() {
        User user = userService.registerUser(
                "student@yorku.ca", "A@32ssdfbsSd%3", 11111, "Student", false
        );
        assertNotNull(user);
        assertEquals("student@yorku.ca", user.getUsername());
        assertEquals(1, userService.getUsers().size());
    }

    @Test
    void testRegisterUser_invalidEmail() {
        assertThrows(IllegalArgumentException.class, () ->
                userService.registerUser("not-an-email", "A@32ssdfbsSd%3", 1, "Student", false)
        );
    }

    @Test
    void testRegisterUser_invalidPassword() {
        assertThrows(IllegalArgumentException.class, () ->
                userService.registerUser("valid@yorku.ca", "weak", 1, "Student", false)
        );
    }

    @Test
    void testLogin_success() throws Exception {
        userService.registerUser("admin@yorku.ca", "A@32ssdfbsSd%3", 1234, "Admin", true);

        User logged = userService.login("admin@yorku.ca", "A@32ssdfbsSd%3");

        assertNotNull(logged);
        assertEquals("admin@yorku.ca", logged.getUsername());
    }

    @Test
    void testLogin_userNotFound() {
        assertThrows(UserNotFoundException.class, () -> userService.login("email@yorku.ca", "password"));
    }

    @Test
    void testLogin_wrongPassword() {
        userService.registerUser("test@yorku.ca", "Correct123$!", 1111, "Admin", true);

        assertThrows(UserNotFoundException.class, () ->
                userService.login("test@yorku.ca", "WrongPwd")
        );
    }

    @Test
    void testLogin_notVerified() {
        userService.registerUser("test2@yorku.ca", "StrongPwd123$", 2222, "Student", false);

        assertThrows(UserNotVerifiedExeption.class, () ->
                userService.login("test2@yorku.ca", "StrongPwd123$")
        );
    }

    @Test
    void testCreateAdmin_success() throws Exception {
        User admin = userService.createAdmin("chief@yorku.ca", "AdminPwd123$", 999);

        assertInstanceOf(Admin.class, admin);
        assertTrue(admin.isVerified());
        assertEquals(1, userService.getAdmins().size());
    }

    @Test
    void testGetUnverifiedUsers() {
        userService.registerUser("u1@yorku.ca", "Pwd123$AAA", 1, "Student", false);
        userService.registerUser("u2@yorku.ca", "Pwd123$AAA", 2, "Student", false);

        List<User> list = userService.getUnverifiedUsers();

        assertEquals(2, list.size());
    }

    @Test
    void testFindByUsername() {
        userService.registerUser("abc@yorku.ca", "Pass123$AA", 33, "Student", true);

        Optional<User> found = userService.findByUsername("abc@yorku.ca");

        assertTrue(found.isPresent());
    }

    @Test
    void testSetUsers_replacesList() {
        userService.registerUser("a@yorku.ca", "PasswordA123$", 1, "Student", true);
        userService.registerUser("b@yorku.ca", "PasswordA123$", 2, "Student", true);

        ArrayList<User> newList = new ArrayList<>();
        newList.add(new User("test@yorku.ca", "PasswordA123$", 3, "Student", true));

        userService.setUsers(newList);

        assertEquals(1, userService.getUsers().size());
    }

    @Test
    void testGetAllUsers() {
        userService.registerUser("u@yorku.ca", "PasswordA123$", 1, "Student", true);
        userService.registerUser("u2@yorku.ca", "PasswordA123$", 2, "Student", true);

        List<User> all = userService.getAllUsers();

        assertEquals(2, all.size());
    }

    @Test
    void testRegisterUser_duplicateUsername() {
        userService.registerUser("dupe@yorku.ca", "StrongPwd123$", 99, "Student", true);

        assertThrows(IllegalStateException.class, () ->
                userService.registerUser("dupe@yorku.ca", "StrongPwd123$", 99, "Student", true)
        );
    }

    @Test
    void testRegisterUser_missingRole() {
        assertThrows(IllegalArgumentException.class, () ->
                userService.registerUser("role@yorku.ca", "StrongPwd123$", 11, "", false)
        );
    }

    @Test
    void testRegisterUser_adminRoleAutoVerified() {
        User admin = userService.registerUser("newAdmin@yorku.ca", "StrongPwd123$", 55, "Admin", false);

        assertTrue(admin.isVerified());
    }

    @Test
    void testRegisterUser_caseInsensitiveAdmin() {
        User admin = userService.registerUser("boss@yorku.ca", "StrongPwd123$", 55, "aDmIn", false);

        assertTrue(admin.isVerified());
    }

    @Test
    void testLogin_trimmedEmail() throws Exception {
        userService.registerUser("trim@yorku.ca", "StrongPwd123$", 33, "Admin", true);
        User logged = userService.login("   trim@yorku.ca  ", "StrongPwd123$");
        assertNotNull(logged);
        assertEquals("trim@yorku.ca", logged.getUsername());
    }

    @Test
    void testGetUserByEmail_success() throws Exception {
        userService.registerUser("fetch@yorku.ca", "StrongPwd123$", 100, "Student", true);

        User user = userService.getUserByEmail("fetch@yorku.ca");

        assertEquals("fetch@yorku.ca", user.getUsername());
    }

    @Test
    void testGetUserByEmail_notFound() {
        assertThrows(UserNotFoundException.class, () ->
                userService.getUserByEmail("email@yorku.ca")
        );
    }

    @Test
    void testGetUsersByVerification() {
        userService.registerUser("v1@yorku.ca", "Password123$AA", 1, "Admin", true);
        userService.registerUser("v2@yorku.ca", "Password123$AA", 2, "Admin", true);
        userService.registerUser("u1@yorku.ca", "Password123$AA", 3, "Student", false);

        List<User> verified = userService.getUsersByVerification(true);
        List<User> unverified = userService.getUsersByVerification(false);

        assertEquals(1, unverified.size());
    }

    @Test
    void testSetUserVerified() throws Exception {
        User user = userService.registerUser("pending@yorku.ca", "Password123$AA", 10, "Student", false);

        assertFalse(user.isVerified());

        userService.setUserVerified(user.getId(), true);

        User updated = userService.getUserByEmail("pending@yorku.ca");

        assertTrue(!updated.isVerified());
    }

    private void initTestDB(){
        String CREATE_USERS =
                "CREATE TABLE IF NOT EXISTS users (" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " username TEXT NOT NULL UNIQUE," +
                        " password TEXT NOT NULL," +
                        " identification INTEGER NOT NULL," +
                        " role TEXT NOT NULL," +
                        " is_verified INTEGER NOT NULL DEFAULT 0" +
                        ");";

        String CREATE_ROOMS =
                "CREATE TABLE IF NOT EXISTS rooms (" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " name TEXT NOT NULL," +
                        " capacity INTEGER NOT NULL," +
                        " location TEXT NOT NULL," +
                        " sensorId INT NOT NULL," +
                        " has_projector INTEGER NOT NULL DEFAULT 0," +
                        " has_speakers INTEGER NOT NULL DEFAULT 0," +
                        " is_enabled INTEGER NOT NULL DEFAULT 1" +
                        ");";

        String CREATE_BOOKINGS =
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

        String CREATE_PAYMENTS =
                "CREATE TABLE IF NOT EXISTS payments (" +
                        " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " user_id INTEGER NOT NULL," +
                        " booking_id INTEGER NOT NULL," +
                        " amount REAL NOT NULL," +
                        " date TEXT NOT NULL," +
                        " type TEXT NOT NULL," +
                        " cardNumber INT," +
                        " passCode INT," +
                        " cardHolder TEXT NOT NULL," +
                        " expiryDate TEXT," +
                        " FOREIGN KEY(user_id) REFERENCES users(id)," +
                        " FOREIGN KEY(booking_id) REFERENCES bookings(id)" +
                        ");";

        String DROP_USERS = "DROP TABLE IF EXISTS users;";
        String DROP_ROOMS = "DROP TABLE IF EXISTS rooms;";
        String DROP_BOOKINGS = "DROP TABLE IF EXISTS bookings;";
        String DROP_PAYMENTS = "DROP TABLE IF EXISTS payments;";

        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON;");
            statement.execute(DROP_USERS);
            statement.execute(DROP_ROOMS);
            statement.execute(DROP_BOOKINGS);
            statement.execute(DROP_PAYMENTS);
            statement.execute(CREATE_USERS);
            statement.execute(CREATE_ROOMS);
            statement.execute(CREATE_BOOKINGS);
            statement.execute(CREATE_PAYMENTS);
        }

        catch (SQLException e) {
            throw new IllegalStateException("Cannot initialize SQLite schema", e);
        }
    }
}