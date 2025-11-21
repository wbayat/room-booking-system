package com.group13.roombookingsystem.controller.user.admin.chief;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAdminController {
    public TextField adminEmail;
    public TextField adminIdentification;
    public TextField tempPassword;

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleAddAdmin(ActionEvent actionEvent) {
    }
}
