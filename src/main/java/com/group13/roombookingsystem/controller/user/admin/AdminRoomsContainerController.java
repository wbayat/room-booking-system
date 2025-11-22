package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.controller.user.RoomCardController;
import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.service.RoomService;
import com.group13.roombookingsystem.service.observer.RoomObserver;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminRoomsContainerController implements Initializable, RoomObserver {
    public FlowPane cardContainer;
    private Stage addRoomStage;

    private List<Room> rooms;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RoomService.getInstance().subscribe(this);
        refreshRooms();
    }
    private void refreshRooms() {
        rooms = RoomService.getInstance().getRooms();
        cardContainer.getChildren().clear();

        for (Room room : rooms) {
            addCard(room);
        }
    }

    private void addCard(Room room) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/admin/RoomCard.fxml"));
            VBox card = fxmlLoader.load();
            AdminRoomCardController adminRoomCardController = fxmlLoader.getController();
            adminRoomCardController.setData(room);
            cardContainer.getChildren().add(card);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleAddRoom(ActionEvent actionEvent) throws IOException {
        if (addRoomStage == null || !addRoomStage.isShowing()){
            addRoomStage = new Stage();
            addRoomStage.setResizable(false);
            addRoomStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/fxml/user/admin/AddRoom.fxml")).load()));
            addRoomStage.setTitle("Add a new room!");
            addRoomStage.show();
        }
    }

    @Override
    public void onUpdate() {
        refreshRooms();
    }
}
