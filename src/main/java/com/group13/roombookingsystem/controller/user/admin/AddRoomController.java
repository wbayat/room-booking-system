package com.group13.roombookingsystem.controller.user.admin;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddRoomController {
    public TextField roomName;
    public TextField roomLocation;
    public TextField roomCapacity;

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleAddRoom(ActionEvent actionEvent) {

    }
}
