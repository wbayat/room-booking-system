package com.group13.roombookingsystem.controller.user.admin.chief;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminsContainerController implements Initializable {
    public VBox adminsContainer;

    private Stage addAdminStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < 10; i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/admin/chief/AdminCard.fxml"));
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
        if (addAdminStage == null || !addAdminStage.isShowing()){
            addAdminStage = new Stage();
            addAdminStage.setResizable(false);
            addAdminStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/fxml/user/admin/chief/AddAdmin.fxml")).load()));
            addAdminStage.setTitle("Add A New Admin!");
            addAdminStage.show();
        }
    }
}
