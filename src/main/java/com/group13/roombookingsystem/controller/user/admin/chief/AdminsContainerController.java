package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.controller.user.admin.UserCardController;
import com.group13.roombookingsystem.controller.user.admin.UsersContainerController;
import com.group13.roombookingsystem.model.user.Admin;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminsContainerController implements Initializable {
    public VBox adminsContainer;
    private Stage addAdminStage;

    private List<User> admins;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshAdminsList();
    }

    private void refreshAdminsList() {
        adminsContainer.getChildren().clear();
        admins = UserService.getInstance().getAllUsers();
        for (User admin : admins) {
            System.out.println(admin.getRole());
            if (admin.getRole().equals("Admin")) {
                addCard(admin);
            }
        }
    }

    private void addCard(User admin) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/admin/chief/AdminCard.fxml"));
            AnchorPane card = fxmlLoader.load();
            AdminCardController adminCardController = fxmlLoader.getController();
            adminCardController.setData(admin);
            adminsContainer.getChildren().add(card);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleAddAdmin(ActionEvent actionEvent) throws IOException {
        if (addAdminStage == null || !addAdminStage.isShowing()) {
            addAdminStage = new Stage();
            addAdminStage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/admin/chief/AddAdmin.fxml"));
            Scene scene = new Scene(loader.load());
            addAdminStage.setScene(scene);
            AddAdminController controller = loader.getController();
            controller.setOnAdminAddedCallback(this::addCard);
            addAdminStage.setOnCloseRequest(e -> addAdminStage = null);
            addAdminStage.setTitle("Add A New Admin!");
            addAdminStage.show();
        }
    }
}
