package com.group13.roombookingsystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentInfoController implements Initializable {
    public ComboBox<String> paymentMethodType;
    public TextField cardHolderName;
    public TextField cardNumber;
    public TextField expirationDate;
    public TextField ccv;

    private final String[] types = {"Credit Card", "Debit Card", "Institutional Billing"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paymentMethodType.getItems().addAll(types);
        paymentMethodType.setValue("Credit Card");
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleAddPaymentMethod(ActionEvent actionEvent) {


        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
