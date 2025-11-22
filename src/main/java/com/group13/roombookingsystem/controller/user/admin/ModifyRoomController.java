package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.model.room.Room;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyRoomController {
    public TextField roomName;
    public TextField roomLocation;
    public TextField roomCapacity;
    public CheckBox hasProjectors;
    public CheckBox hasSpeakers;

    private Room room;


    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleConfirm(ActionEvent actionEvent) {

    }

    public void setData(Room room) {
        this.room = room;
        roomName.setText(room.getRoomName());
        roomLocation.setText(room.getLocation());
        roomCapacity.setText(String.valueOf(room.getCapacity()));
        hasProjectors.setSelected(room.getHasProjector());
        hasSpeakers.setSelected(room.getHasSpeakers());
    }
}
