package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminsContainerController implements Initializable {
    public VBox adminsContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 10; i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/admin/chief/AdminCard.fxml"));
                AnchorPane card = fxmlLoader.load();
                AdminCardController adminCardController = fxmlLoader.getController();
                adminCardController.setData();
                adminsContainer.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void handleAddAdmin(ActionEvent actionEvent) throws IOException {

    }
}
