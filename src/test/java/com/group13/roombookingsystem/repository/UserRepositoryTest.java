package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.user.*;
import org.junit.jupiter.api.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private final UserRepository repository = new UserRepository();

    @BeforeEach
    void setupDB() {
        Database.setTestPath();
        initTestDB();
    }

    @AfterAll
    static void cleanup() throws Exception {
        Files.deleteIfExists(Path.of("test.db"));
        System.clearProperty("test.db.url");
    }

    private void initTestDB() {
        try (Connection conn = Database.getConnection();
             Statement st = conn.createStatement()) {

            st.execute("DROP TABLE IF EXISTS users;");
            st.execute("""
                CREATE TABLE users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL UNIQUE,
                    password TEXT NOT NULL,
                    identification INTEGER NOT NULL,
                    role TEXT NOT NULL,
                    is_verified INTEGER NOT NULL DEFAULT 0
                );
            """);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize test DB", e);
        }
    }

    private void cleanupUserById(int id) {
        try (Connection c = Database.getConnection()) {
            PreparedStatement st = c.prepareStatement("DELETE FROM users WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }
    }

    private void cleanupUserByUsername(String username) {
        try (Connection c = Database.getConnection()) {
            PreparedStatement st = c.prepareStatement("DELETE FROM users WHERE username = ?");
            st.setString(1, username);
            st.execute();
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void studentNeedsVerificationTest() {
        cleanupUserByUsername("studentJUnit");

        User student = new Student("studentJUnit", "pass", 12345, "Student", false);
        User created = repository.create(student);

        assertFalse(created.isVerified());

        String sql = "SELECT * FROM users WHERE username = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "studentJUnit");

            ResultSet rs = st.executeQuery();
            assertTrue(rs.next());
            assertEquals("Student", rs.getString("role"));
            assertEquals(0, rs.getInt("is_verified"));
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createAdminAutoVerifiedTest() {
        cleanupUserByUsername("adminJUnit");

        User admin = new Admin("adminJUnit", "pass", 11111, "Admin", false);
        User created = repository.create(admin);

        assertTrue(created.isVerified());

        try (Connection c = Database.getConnection()) {
            PreparedStatement st = c.prepareStatement("SELECT is_verified FROM users WHERE username = 'adminJUnit'");
            ResultSet rs = st.executeQuery();
            assertTrue(rs.next());
            assertEquals(1, rs.getInt("is_verified"));
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void updateVerificationTest() {
        cleanupUserByUsername("verifyStudent");

        User student = new Student("verifyStudent", "pass", 11111, "Student", false);
        repository.create(student);

        int userId = -9999;

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(
                    "SELECT id FROM users WHERE username = ? ORDER BY id DESC LIMIT 1");
            st.setString(1, "verifyStudent");

            ResultSet rs = st.executeQuery();
            assertTrue(rs.next());
            userId = rs.getInt("id");
        } catch (SQLException e) {
            fail(e);
        }

        repository.updateVerification(userId, true);

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(
                    "SELECT is_verified FROM users WHERE id = ?");
            st.setInt(1, userId);

            ResultSet rs = st.executeQuery();
            assertTrue(rs.next());
            assertEquals(1, rs.getInt("is_verified"));
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void cannotUnverifyAdminTest() {
        cleanupUserById(8000);
        cleanupUserByUsername("adminJUnit");

        String sql = """
            INSERT INTO users(id, username, password, identification, role, is_verified)
            VALUES (8000, 'adminJUnit', 'pass', 22222, 'Admin', 1)
            ON CONFLICT(id) DO NOTHING;
        """;

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            fail(e);
        }

        repository.updateVerification(8000, false);

        try (Connection connection = Database.getConnection()) {
            PreparedStatement st = connection.prepareStatement(
                    "SELECT is_verified FROM users WHERE id = 8000");
            ResultSet rs = st.executeQuery();

            assertTrue(rs.next());
            assertEquals(1, rs.getInt("is_verified"));
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void findUserByUsernameTest() {
        cleanupUserById(8100);
        cleanupUserByUsername("findUser");

        String sql = """
            INSERT INTO users(id, username, password, identification, role, is_verified)
            VALUES (8100, 'findUser', 'pw', 33333, 'Student', 0)
            ON CONFLICT(id) DO NOTHING;
        """;

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            fail(e);
        }

        User result = repository.findByUsername("findUser").orElse(null);
        assertNotNull(result);
        assertEquals("findUser", result.getUsername());
        assertEquals("Student", result.getRole());
    }

    @Test
    void findUserByUsernameEmptyTest() {
        assertTrue(repository.findByUsername("randomUserXYZ").isEmpty());
    }

    @Test
    void findUserByIdTest() {
        cleanupUserById(8200);
        cleanupUserByUsername("findByIdUser");

        String sql = """
            INSERT INTO users(id, username, password, identification, role, is_verified)
            VALUES (8200, 'findByIdUser', 'pw', 44444, 'Student', 0)
            ON CONFLICT(id) DO NOTHING;
        """;

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            fail(e);
        }

        User result = repository.findById(8200).orElse(null);
        assertNotNull(result);
        assertEquals(8200, result.getId());
        assertEquals("findByIdUser", result.getUsername());
    }

    @Test
    void findUserByIdEmptyTest() {
        assertTrue(repository.findById(999999).isEmpty());
    }

    @Test
    void findAllUsersTest() {
        cleanupUserById(8300);
        cleanupUserByUsername("allUser");

        String sql = """
            INSERT INTO users(id, username, password, identification, role, is_verified)
            VALUES (8300, 'allUser', 'pw', 55555, 'Student', 0)
            ON CONFLICT(id) DO NOTHING;
        """;

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();
        } catch (SQLException e) {
            fail(e);
        }

        List<User> users = repository.findAll();
        assertNotNull(users);

        User found = null;
        for (User u : users) {
            if ("allUser".equals(u.getUsername())) {
                found = u;
                break;
            }
        }

        assertNotNull(found);
        assertEquals("allUser", found.getUsername());
        assertEquals("pw", found.getPassword());
        assertEquals(55555, found.getVerificationNumber());
        assertEquals("Student", found.getRole());
        assertFalse(found.isVerified());
    }

    @Test
    void findByVerificationTest() {
        cleanupUserById(8400);
        cleanupUserById(8401);
        cleanupUserByUsername("verifiedUser");
        cleanupUserByUsername("unverifiedUser");

        String sql1 = """
            INSERT INTO users(id, username, password, identification, role, is_verified)
            VALUES (8400, 'verifiedUser', 'pw', 66666, 'Student', 1)
            ON CONFLICT(id) DO NOTHING;
        """;

        String sql2 = """
            INSERT INTO users(id, username, password, identification, role, is_verified)
            VALUES (8401, 'unverifiedUser', 'pw', 77777, 'Student', 0)
            ON CONFLICT(id) DO NOTHING;
        """;

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql1).execute();
            connection.prepareStatement(sql2).execute();
        } catch (SQLException e) {
            fail(e);
        }

        List<User> verifiedUsers = repository.findByVerification(true);
        List<User> unverifiedUsers = repository.findByVerification(false);

        User verified = verifiedUsers.stream()
                .filter(u -> u.getUsername().equals("verifiedUser"))
                .findFirst()
                .orElse(null);

        User unverified = unverifiedUsers.stream()
                .filter(u -> u.getUsername().equals("unverifiedUser"))
                .findFirst()
                .orElse(null);

        assertNotNull(verified);
        assertEquals("verifiedUser", verified.getUsername());
        assertTrue(verified.isVerified());

        assertNotNull(unverified);
        assertEquals("unverifiedUser", unverified.getUsername());
        assertFalse(unverified.isVerified());
    }
}
