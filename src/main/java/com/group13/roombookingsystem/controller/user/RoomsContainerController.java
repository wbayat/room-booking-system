package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.service.RoomService;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomsContainerController implements Initializable {

    public FlowPane cardContainer;

    List<Room> rooms = RoomService.getInstance().getRooms();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Room room : rooms){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/RoomCard.fxml"));
                VBox card = fxmlLoader.load();
                RoomCardController roomCardController = fxmlLoader.getController();
                roomCardController.setData(room);
                cardContainer.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
