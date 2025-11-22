package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.model.room.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminRoomCardController {

    public Label roomLocation;
    public Label roomCapacity;
    public Label roomName;

    private Room room;

    private Stage modifyRoomStage;

    public void setData(){
        roomName.setText("Room D");
        roomLocation.setText("BRG");
    }

    public void handleModifyRoom(ActionEvent actionEvent) throws IOException {
        if (modifyRoomStage == null || !modifyRoomStage.isShowing()){
            modifyRoomStage = new Stage();
            modifyRoomStage.setResizable(false);
            modifyRoomStage.setTitle("Modify a room!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/admin/ModifyRoom.fxml"));
            modifyRoomStage.setScene(new Scene(loader.load()));
            ModifyRoomController controller = loader.getController();
            controller.setRoom(room);
            modifyRoomStage.show();
        }
    }

    public void handleDisableRoom(ActionEvent actionEvent) {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
