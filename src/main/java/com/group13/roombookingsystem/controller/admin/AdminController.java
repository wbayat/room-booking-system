package com.group13.roombookingsystem.controller.admin;

import com.group13.roombookingsystem.manager.SceneManager;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane adminBorderPane;

    private AnchorPane roomsContainer;
    private AnchorPane usersContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showManageRoomsView(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showManageRoomsView(ActionEvent actionEvent) throws IOException {
        if (roomsContainer == null){
            roomsContainer = new FXMLLoader(MainGUI.class.getResource("/fxml/admin/AdminRoomsContainer.fxml")).load();
        }
        adminBorderPane.setCenter(roomsContainer);
    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneManager.getInstance().showLoginView();
    }

    public void showManageUsersView(ActionEvent actionEvent) throws IOException {
        if (usersContainer == null){
            usersContainer = new FXMLLoader(MainGUI.class.getResource("/fxml/admin/UsersContainer.fxml")).load();
        }
        adminBorderPane.setCenter(usersContainer);
    }
}
