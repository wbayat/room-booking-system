package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.controller.user.admin.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChiefController extends AdminController{
    private AnchorPane adminsContainer;

    private void setUpChiefMenu(){
        setUpAdminMenu();
        Button manageAdminsButton = new Button("Manage Admins");
        manageAdminsButton.getStyleClass().add("menu-button");
        manageAdminsButton.setOnAction(event -> {
            try {
                showManageAdminsView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        buttonContainer.getChildren().add(manageAdminsButton);
    }


    public void showManageAdminsView(ActionEvent actionEvent) throws IOException {
        if (adminsContainer == null){
            adminsContainer = new FXMLLoader(getClass().getResource("/fxml/user/admin/chief/AdminsContainer.fxml")).load();
        }
        mainContainer.setCenter(adminsContainer);
    }
}
