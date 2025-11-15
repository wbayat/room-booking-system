package com.group13.roombookingsystem.controller.admin;

import com.group13.roombookingsystem.controller.client.RoomCardController;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminRoomsContainerController implements Initializable {
    public FlowPane cardContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 10; i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("/fxml/admin/AdminRoomCard.fxml"));
                VBox card = fxmlLoader.load();
                AdminRoomCardController adminRoomCardController = fxmlLoader.getController();
                adminRoomCardController.setData();
                cardContainer.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
