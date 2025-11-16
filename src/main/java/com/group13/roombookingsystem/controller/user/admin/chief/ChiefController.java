package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.controller.user.admin.AdminController;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChiefController extends AdminController implements Initializable {
    private AnchorPane adminsContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userType.setText("Chief Event Coordinator!");
        Button manageAdminsButton = new Button("Manage Admins");
        manageAdminsButton.getStyleClass().add("menu-button");
        manageAdminsButton.setOnAction(event -> {
            try {
                showManageAdminsView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button manageRoomsButton = new Button("Manage Rooms");
        manageRoomsButton.getStyleClass().add("menu-button");
        manageRoomsButton.setOnAction(event -> {
            try {
                showManageRoomsView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button manageUsersButton = new Button("Manage Admins");
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
        buttonContainer.getChildren().add(manageAdminsButton);
        try {
            showManageRoomsView(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showManageAdminsView(ActionEvent actionEvent) throws IOException {
        if (adminsContainer == null){
            adminsContainer = new FXMLLoader(MainGUI.class.getResource("/fxml/user/admin/chief/AdminsContainer.fxml")).load();
        }
        mainContainer.setCenter(adminsContainer);
    }
}
