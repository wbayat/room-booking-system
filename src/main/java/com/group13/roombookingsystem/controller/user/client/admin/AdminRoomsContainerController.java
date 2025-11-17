package com.group13.roombookingsystem.controller.user.client.admin;

import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminRoomsContainerController implements Initializable {
    public FlowPane cardContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 10; i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/admin/RoomCard.fxml"));
                VBox card = fxmlLoader.load();
                AdminRoomCardController adminRoomCardController = fxmlLoader.getController();
                adminRoomCardController.setData();
                cardContainer.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void handleAddRoom(ActionEvent actionEvent) throws IOException {
        Stage addRoomStage = new Stage();
        addRoomStage.setResizable(false);
        addRoomStage.setScene(new Scene(new FXMLLoader(MainGUI.class.getResource("/fxml/user/admin/AddRoom.fxml")).load()));
        addRoomStage.setTitle("Add a new room!");
        addRoomStage.show();
    }
}
