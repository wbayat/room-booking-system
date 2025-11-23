package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.service.RoomService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminRoomCardController {

    public Label roomLocation;
    public Label roomCapacity;
    public Label roomName;
    public Label sensorID;
    public Button toggleEnabled;
    public ImageView projectorIcon;
    public ImageView speakerIcon;

    private Room room;

    private Stage modifyRoomStage;

    public void setData(Room room){
        this.room = room;
        roomName.setText(room.getRoomName());
        roomCapacity.setText(String.valueOf(room.getCapacity()));
        roomLocation.setText(room.getLocation());
        sensorID.setText(String.valueOf(room.getSensorId()));
        String toggleButtonText = (room.isEnabled()) ? "Disable" : "Enable";
        toggleEnabled.setText(toggleButtonText);
        if (!room.getHasProjector()){
            projectorIcon.setVisible(false);
        }
        if (!room.getHasSpeakers()){
            speakerIcon.setVisible(false);
        }
    }

    public void handleModifyRoom(ActionEvent actionEvent) throws IOException {
        if (modifyRoomStage == null || !modifyRoomStage.isShowing()){
            modifyRoomStage = new Stage();
            modifyRoomStage.setResizable(false);
            modifyRoomStage.setTitle("Modify a room!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/admin/ModifyRoom.fxml"));
            modifyRoomStage.setScene(new Scene(loader.load()));
            ModifyRoomController controller = loader.getController();
            controller.setData(room);
            modifyRoomStage.show();
        }
    }

    public void handleDisableRoom(ActionEvent actionEvent) {
        RoomService.getInstance().disableRoom(room);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
