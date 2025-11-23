package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.payment.CreditCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.DebitCardPaymentStrategy;
import com.group13.roombookingsystem.model.payment.InstitutionalBillingPaymentStrategy;
import com.group13.roombookingsystem.model.payment.PaymentStrategy;
import com.group13.roombookingsystem.service.BookingService;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

    private final String[] types = {"Credit Card", "Debit Card", "Institutional Billing"};

    public void postInit(){
        long minutes = ChronoUnit.MINUTES.between(parentController.checkinTime.getValue(), parentController.checkoutTime.getValue());
        if (minutes < 0) minutes += 1440;
        int hours = (int) ((minutes + 59) / 60);
        int totalPrice = parentController.user.getHourlyRate() * hours;
        price.setText(String.valueOf(totalPrice));
        paymentMethodType.getItems().addAll(types);
        paymentMethodType.setValue("Credit Card");
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void changeType() {
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
            default -> new InstitutionalBillingPaymentStrategy(first.getText());
        };
    }
    public void handleAddPaymentMethod(ActionEvent actionEvent) {
        PaymentStrategy paymentStrategy = getPaymentStrategy();
        BookingService.getInstance().createBooking(parentController.user, parentController.room, parentController.checkInDate.getValue(), parentController.checkinTime.getValue(), parentController.checkoutTime.getValue(), paymentStrategy);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setParentController(RoomCardController parentController) {
        this.parentController = parentController;
    }
}
