package com.group13.roombookingsystem.controller.user.admin.chief;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAdminController implements Initializable {
    public TextField adminEmail;
    public TextField adminIdentification;
    public TextField tempPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tempPassword.setText("PasswordFromPasswordGeneratorHere");
        tempPassword.setEditable(false);
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleAddAdmin(ActionEvent actionEvent) {
    }
}
