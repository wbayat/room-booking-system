package com.group13.roombookingsystem.repository;

import com.group13.roombookingsystem.model.payment.CreditCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.DebitCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.InstitutionalBillingPaymentStrategy;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodRepositoryTest {

    private final PaymentMethodRepository repository = new PaymentMethodRepository();

    @Test
    void createCreditCardTest() {
        PaymentStrategy strategy = new CreditCardPaymentStrategy(
                "1111111111111111",
                "JUnit Credit",
                "123",
                "12/30"
        );

        int userId = 1;
        int bookingId = 1;
        double amount = 50.0;
        String date = "2025-01-01";

        PaymentStrategy created = repository.create(userId, bookingId, amount, date, strategy);
        assertNotNull(created);

        String sql = "SELECT * FROM payments WHERE user_id = ? AND booking_id = ? AND amount = ? AND date = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, bookingId);
            statement.setDouble(3, amount);
            statement.setString(4, date);

            ResultSet rs = statement.executeQuery();
            assertTrue(rs.next());
            assertEquals("creditcard", rs.getString("type"));
            assertEquals("1111111111111111", rs.getString("cardNumber"));
            assertEquals("123", rs.getString("passCode"));
            assertEquals("JUnit Credit", rs.getString("cardHolder"));
            assertEquals("12/30", rs.getString("expiryDate"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createDebitCardTest() {
        PaymentStrategy strategy = new DebitCardPaymentStrategy(
                "1111111111111111",
                "JUnit Debit",
                "9999"
        );

        int userId = 2;
        int bookingId = 2;
        double amount = 75.25;
        String date = "2025-02-02";

        repository.create(userId, bookingId, amount, date, strategy);

        String sql = "SELECT * FROM payments WHERE user_id = ? AND booking_id = ? AND amount = ? AND date = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);
            statement.setInt(2, bookingId);
            statement.setDouble(3, amount);
            statement.setString(4, date);

            ResultSet rs = statement.executeQuery();
            assertTrue(rs.next());
            assertEquals("debitcard", rs.getString("type"));
            assertEquals("1111111111111111", rs.getString("cardNumber"));
            assertEquals("9999", rs.getString("passCode"));
            assertEquals("JUnit Debit", rs.getString("cardHolder"));
            assertNull(rs.getString("expiryDate"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createInstitutionalBillingTest() {
        PaymentStrategy strategy = new InstitutionalBillingPaymentStrategy(
                "JUnit Department",
                "12345"
        );

        int userId = 3;
        int bookingId = 3;
        double amount = 200.0;
        String date = "2025-03-03";

        repository.create(userId, bookingId, amount, date, strategy);

        String sql = "SELECT * FROM payments WHERE user_id = ? AND booking_id = ? AND amount = ? AND date = ? ORDER BY id DESC LIMIT 1";

        try (Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);
            statement.setInt(2, bookingId);
            statement.setDouble(3, amount);
            statement.setString(4, date);

            ResultSet rs = statement.executeQuery();
            assertTrue(rs.next());
            assertEquals("institutionalbilling", rs.getString("type"));
            assertEquals("12345", rs.getString("cardNumber"));
            assertNull(rs.getString("passCode"));
            assertEquals("JUnit Department", rs.getString("cardHolder"));
            assertNull(rs.getString("expiryDate"));

        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createMultiplePayments() {
        PaymentStrategy s1 = new CreditCardPaymentStrategy("1111111111111111", "User1", "111", "01/30");
        PaymentStrategy s2 = new DebitCardPaymentStrategy("1111111111111111", "User2", "2222");
        PaymentStrategy s3 = new InstitutionalBillingPaymentStrategy("Dept", "999");

        try {
            repository.create(10, 10, 10.0, "2025-04-01", s1);
            repository.create(11, 11, 20.0, "2025-04-02", s2);
            repository.create(12, 12, 30.0, "2025-04-03", s3);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void parseCreditStrategyTest() {
        String sql = "INSERT INTO payments(user_id, booking_id, amount, date, type, cardNumber, passCode, cardHolder, expiryDate) " +
                "VALUES (101, 201, 10.0, '2025-05-01', 'creditcard', '4111222233334444', '321', 'Card User', '11/29');";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();

            sql = "SELECT * FROM payments WHERE user_id = 101 AND booking_id = 201 ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            assertTrue(rs.next());
            PaymentStrategy strategy = repository.mapRow(rs);
            assertTrue(strategy instanceof CreditCardPaymentStrategy);

            CreditCardPaymentStrategy cc = (CreditCardPaymentStrategy) strategy;
            assertEquals("4111222233334444", cc.getCardNumber());
            assertEquals("321", cc.getCvv());
            assertEquals("Card User", cc.getCardHolderName());
            assertEquals("11/29", cc.getExpiryDate());
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void parseDebitStrategyTest() {
        String sql = "INSERT INTO payments(user_id, booking_id, amount, date, type, cardNumber, passCode, cardHolder, expiryDate) " +
                "VALUES (102, 202, 15.0, '2025-05-02', 'debitcard', '9999888877776666', '5555', 'Debit User', NULL);";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();

            sql = "SELECT * FROM payments WHERE user_id = 102 AND booking_id = 202 ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            assertTrue(rs.next());
            PaymentStrategy strategy = repository.mapRow(rs);
            assertTrue(strategy instanceof DebitCardPaymentStrategy);

            DebitCardPaymentStrategy dc = (DebitCardPaymentStrategy) strategy;
            assertEquals("9999888877776666", dc.getCardNumber());
            assertEquals("5555", dc.getPin());
            assertEquals("Debit User", dc.getCardHolderName());
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void parseInstitutionalBillingStrategyTest() {
        String sql = "INSERT INTO payments(user_id, booking_id, amount, date, type, cardNumber, passCode, cardHolder, expiryDate) " +
                "VALUES (103, 203, 25.0, '2025-05-03', 'institutionalbilling', 'ACC-777', NULL, 'JUnit Dept', NULL);";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();

            sql = "SELECT * FROM payments WHERE user_id = 103 AND booking_id = 203 ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            assertTrue(rs.next());
            PaymentStrategy strategy = repository.mapRow(rs);
            assertTrue(strategy instanceof InstitutionalBillingPaymentStrategy);

            InstitutionalBillingPaymentStrategy ib = (InstitutionalBillingPaymentStrategy) strategy;
            assertEquals("JUnit Dept", ib.getDepartmentName());
            assertEquals("ACC-777", ib.getAccountId());
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void parseUndefinedStrategyTest() {
        String sql = "INSERT INTO payments(user_id, booking_id, amount, date, type, cardNumber, passCode, cardHolder, expiryDate) " +
                "VALUES (104, 204, 30.0, '2025-05-04', 'weirdtype', NULL, NULL, 'Unknown User', NULL);";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();

            sql = "SELECT * FROM payments WHERE user_id = 104 AND booking_id = 204 ORDER BY id DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            assertTrue(rs.next());
            PaymentStrategy strategy = repository.mapRow(rs);
            assertTrue(strategy instanceof CreditCardPaymentStrategy);
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void idAssignmentOnParseTest() {
        String sql = "INSERT INTO payments(id, user_id, booking_id, amount, date, type, cardNumber, passCode, cardHolder, expiryDate) " +
                "VALUES (9999, 105, 205, 40.0, '2025-05-05', 'creditcard', '1234', '111', 'IdUser', '10/30') " +
                "ON CONFLICT(id) DO NOTHING;";

        try (Connection connection = Database.getConnection()) {
            connection.prepareStatement(sql).execute();

            sql = "SELECT * FROM payments WHERE id = 9999";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            assertTrue(rs.next());
            PaymentStrategy strategy = repository.mapRow(rs);

            assertEquals(9999, strategy.getID());
        } catch (SQLException e) {
            fail(e);
        }
    }

    @Test
    void createStrategyReturnTest() {
        PaymentStrategy strategy = new CreditCardPaymentStrategy(
                "5555666677778888",
                "Returned User",
                "456",
                "09/28"
        );

        int userId = 501;
        int bookingId = 601;
        double amount = 123.45;
        String date = "2025-11-11";

        PaymentStrategy created = repository.create(userId, bookingId, amount, date, strategy);

        assertNotNull(created);
        assertTrue(created instanceof CreditCardPaymentStrategy);

        CreditCardPaymentStrategy cc = (CreditCardPaymentStrategy) created;

        assertEquals("5555666677778888", cc.getCardNumber());
        assertEquals("Returned User", cc.getCardHolderName());
        assertEquals("456", cc.getCvv());
        assertEquals("09/28", cc.getExpiryDate());
        assertTrue(cc.getID() > 0);
    }

}
