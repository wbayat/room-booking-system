package com.group13.roombookingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.group13.roombookingsystem.model.payment.CreditCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.DebitCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.InstitutionalBillingPaymentStrategy;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;

public class PaymentMethodRepository {
    private static class PaymentDetails {
        String type;
        String cardNumber;
        String passCode;
        String cardHolder;
        String expiryDate;
    }

    private static final String INSERT_PAYMENT = """
            INSERT INTO payments(user_id, booking_id, amount, date, type, cardNumber, passCode, cardHolder, expiryDate)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
            """;


    public PaymentStrategy create(int userId, int bookingId, double amount, String date, PaymentStrategy strategy) {
        PaymentDetails details = extractDetails(strategy);

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_PAYMENT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, userId);
            statement.setInt(2, bookingId);
            statement.setDouble(3, amount);
            statement.setString(4, date);
            statement.setString(5, details.type);
            statement.setString(6, details.cardNumber);
            statement.setString(7, details.passCode);
            statement.setString(8, details.cardHolder);
            statement.setString(9, details.expiryDate);
            statement.executeUpdate();
            return strategy;
        } 
        
        catch (SQLException e) {
            throw new IllegalStateException("Unable to create payment record", e);
        }
    }

    private PaymentStrategy createStrategy(String paymentType, ResultSet resultSet) throws SQLException {
        String normalizedType = paymentType == null ? "" : paymentType.toLowerCase();

        switch (normalizedType) {
            case "creditcard":
                return new CreditCardPaymentStrategy(
                        resultSet.getString("cardNumber"),
                        resultSet.getString("cardHolder"),
                        resultSet.getString("passCode"),
                        resultSet.getString("expiryDate"));
            case "debitcard":
                return new DebitCardPaymentStrategy(
                        resultSet.getString("cardNumber"),
                        resultSet.getString("cardHolder"),
                        resultSet.getString("passCode"));
            case "institutionalbilling":
                return new InstitutionalBillingPaymentStrategy(resultSet.getString("cardHolder"));
            default:
                return new CreditCardPaymentStrategy("", "", "", "");
        }
    }

    private PaymentDetails extractDetails(PaymentStrategy strategy) {
        PaymentDetails details = new PaymentDetails();

        switch (strategy) {
            case CreditCardPaymentStrategy creditCard -> {
                details.type = "creditcard";
                details.cardNumber = creditCard.getCardNumber();
                details.passCode = creditCard.getCvv();
                details.cardHolder = creditCard.getCardHolderName();
                details.expiryDate = creditCard.getExpiryDate();
            }
            case DebitCardPaymentStrategy debitCard -> {
                details.type = "debitcard";
                details.cardNumber = debitCard.getCardNumber();
                details.passCode = debitCard.getPin();
                details.cardHolder = debitCard.getCardHolderName();
                details.expiryDate = null;
            }
            
            case InstitutionalBillingPaymentStrategy institutional -> {
                details.type = "institutionalbilling";
                details.cardNumber = null;
                details.passCode = null;
                details.cardHolder = institutional.getDepartmentName();
                details.expiryDate = null;
            }
            default -> {
                details.type = "creditcard";
                details.cardNumber = null;
                details.passCode = null;
                details.cardHolder = null;
                details.expiryDate = null;
            }
        }
        
        return details;
    }

    public PaymentStrategy mapRow(ResultSet resultSet) throws SQLException {
        String paymentType = resultSet.getString("type");
        PaymentStrategy strategy = createStrategy(paymentType, resultSet);
        setPaymentIdFromDatabase(strategy, resultSet);
        return strategy;
    }

    private void setPaymentIdFromDatabase(PaymentStrategy strategy, ResultSet resultSet) throws SQLException {
        strategy.setID(resultSet.getInt("id"));
    }


}
