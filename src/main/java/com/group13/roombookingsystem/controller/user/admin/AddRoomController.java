package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.repository.RoomRepository;
import com.group13.roombookingsystem.service.RoomService;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddRoomController {
    public TextField roomName;
    public TextField roomLocation;
    public TextField roomCapacity;
    public CheckBox hasProjectors;
    public CheckBox hasSpeakers;

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleAddRoom(ActionEvent actionEvent) {
        RoomService.getInstance().addRoom(roomName.getText(), Integer.parseInt(roomCapacity.getText()), roomLocation.getText(), hasProjectors.isSelected(), hasSpeakers.isSelected(), null, 123);
        handleCancel(actionEvent);
    }
}
