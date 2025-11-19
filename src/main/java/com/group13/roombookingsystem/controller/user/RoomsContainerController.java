package com.group13.roombookingsystem.controller.user;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomsContainerController implements Initializable {

    public FlowPane cardContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 10; i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/RoomCard.fxml"));
                VBox card = fxmlLoader.load();
                RoomCardController roomCardController = fxmlLoader.getController();
                roomCardController.setData();
                cardContainer.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
