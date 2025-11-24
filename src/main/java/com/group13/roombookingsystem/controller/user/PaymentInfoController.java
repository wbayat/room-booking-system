package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.payment.CreditCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.DebitCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.InstitutionalBillingPaymentStrategy;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.service.PaymentService;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PaymentInfoController{
    public ComboBox<String> paymentMethodType;
    public Label firstLabel;
    public TextField first;
    public Label secondLabel;
    public TextField second;
    public Label thirdLabel;
    public TextField third;
    public Label forthLabel;
    public TextField forth;
    public Label price;

    private RoomCardController parentController;
    private LocalDate bookingDate;
    private LocalTime checkin;
    private LocalTime checkout;
    private double totalPriceAmount;

    private final String[] types = {"Credit Card", "Debit Card", "Institutional Billing"};

    public void postInit(){
        if (bookingDate == null || checkin == null || checkout == null) {
            throw new IllegalStateException("Booking details must be provided before initializing payment info controller.");
        }

        long minutes = ChronoUnit.MINUTES.between(checkin, checkout);
        if (minutes <= 0) {
            minutes += 1440;
        }
        int hours = (int) ((minutes + 59) / 60);
        totalPriceAmount = parentController.user.getHourlyRate() * hours;
        price.setText(String.valueOf((int) totalPriceAmount));
        paymentMethodType.getItems().setAll(types);
        paymentMethodType.setValue("Credit Card");
        changeType();
    }

    public void handleCancel(ActionEvent actionEvent) {
        closeStage((Node) actionEvent.getSource());
    }

    public void changeType() {
        if (paymentMethodType.getValue() == null) {
            return;
        }
        if (paymentMethodType.getValue().equals("Credit Card")){
            thirdLabel.setVisible(true);
            forthLabel.setVisible(true);
            third.setVisible(true);
            forth.setVisible(true);
            firstLabel.setText("Card Holder Name");
            secondLabel.setText("Credit Card Number");
            thirdLabel.setText("Expiration Date");
            forthLabel.setText("CVV");
        }else if(paymentMethodType.getValue().equals("Debit Card")){
            thirdLabel.setVisible(true);
            forthLabel.setVisible(false);
            third.setVisible(true);
            forth.setVisible(false);
            firstLabel.setText("Card Holder Name");
            secondLabel.setText("Debit Card Number");
            thirdLabel.setText("Pin");
        }else {
            thirdLabel.setVisible(false);
            forthLabel.setVisible(false);
            third.setVisible(false);
            forth.setVisible(false);
            firstLabel.setText("Department Name");
            secondLabel.setText("Institution Account ID");
        }
    }
    public PaymentStrategy getPaymentStrategy() {
        String type = paymentMethodType.getValue();

        return switch (type) {
            case "Credit Card" ->
                    new CreditCardPaymentStrategy(first.getText(), second.getText(), third.getText(), forth.getText());
            case "Debit Card" -> new DebitCardPaymentStrategy(first.getText(), second.getText(), third.getText());
            default -> new InstitutionalBillingPaymentStrategy(first.getText(), second.getText());
        };
    }
    public void handleAddPaymentMethod(ActionEvent actionEvent) {
        if (!validatePaymentFields()) {
            showError("Please fill in all required payment details.");
            return;
        }

        PaymentStrategy paymentStrategy = getPaymentStrategy();

        try {
            Booking booking = PaymentService.getInstance().createBookingWithPayment(
                    parentController.user,
                    parentController.room,
                    bookingDate,
                    checkin,
                    checkout,
                    paymentStrategy,
                    totalPriceAmount
            );
            closeStage((Node) actionEvent.getSource());
            parentController.handleBookingSuccess(booking);
        } catch (IllegalArgumentException | IllegalStateException e) {
            showError(e.getMessage());
        } catch (SQLException e) {
            showError("Unable to complete booking due to a database error.\n\nDetails: " + e.getMessage());
        }
    }

    public void setParentController(RoomCardController parentController) {
        this.parentController = parentController;
    }

    public void setBookingDetails(LocalDate bookingDate, LocalTime checkin, LocalTime checkout) {
        this.bookingDate = bookingDate;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    private boolean validatePaymentFields() {
        String type = paymentMethodType.getValue();
        if (type == null) {
            return false;
        }
        return switch (type) {
            case "Credit Card" ->
                    isFilled(first) && isFilled(second) && isFilled(third) && isFilled(forth);
            case "Debit Card" ->
                    isFilled(first) && isFilled(second) && isFilled(third);
            default -> isFilled(first) && isFilled(second);
        };
    }

    private boolean isFilled(TextField field) {
        return field != null && field.getText() != null && !field.getText().isBlank();
    }

    private void closeStage(Node node) {
        if (node == null) {
            return;
        }
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    private void showError(String message) {
        parentController.showBookingFailure(message);
    }
}
