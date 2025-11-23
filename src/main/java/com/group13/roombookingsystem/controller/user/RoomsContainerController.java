package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.RoomService;
import com.group13.roombookingsystem.service.observer.Observer;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomsContainerController implements Initializable, Observer {
    public FlowPane cardContainer;
    private List<Room> rooms;

    public User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RoomService.getInstance().subscribe(this);
    }

    public void refreshRooms() {
        rooms = RoomService.getInstance().getRooms();
        cardContainer.getChildren().clear();

        for (Room room : rooms) {
            if (room.isEnabled()){
                addCard(room);
            }
        }
    }

    private void addCard(Room room) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/RoomCard.fxml"));
            VBox card = fxmlLoader.load();
            RoomCardController roomCardController = fxmlLoader.getController();
            roomCardController.setData(room);
            roomCardController.user = user;
            cardContainer.getChildren().add(card);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load RoomCard.fxml", e);
        }
    }

    @Override
    public void onUpdate() {
        refreshRooms();
    }
}