package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.controller.user.UserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController extends UserController {

    protected AnchorPane roomsContainer;
    protected AnchorPane usersContainer;

    protected void setUpAdminMenu(){
        Button manageRoomsButton = new Button("Manage Rooms");
        manageRoomsButton.getStyleClass().add("menu-button");
        manageRoomsButton.setOnAction(event -> {
            try {
                showManageRoomsView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button manageUsersButton = new Button("Manage Users");
        manageUsersButton.getStyleClass().add("menu-button");
        manageUsersButton.setOnAction(event -> {
            try {
                showManageUsersView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        buttonContainer.getChildren().add(manageRoomsButton);
        buttonContainer.getChildren().add(manageUsersButton);
    }

    public void showManageRoomsView(ActionEvent actionEvent) throws IOException {
        if (roomsContainer == null){
            roomsContainer = new FXMLLoader(getClass().getResource("/fxml/user/admin/RoomsContainer.fxml")).load();
        }
        mainContainer.setCenter(roomsContainer);
    }

    public void showManageUsersView(ActionEvent actionEvent) throws IOException {
        if (usersContainer == null){
            usersContainer = new FXMLLoader(getClass().getResource("/fxml/user/admin/UsersContainer.fxml")).load();
        }
        mainContainer.setCenter(usersContainer);
    }
}
