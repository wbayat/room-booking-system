package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UsersContainerController implements Initializable {
    @FXML public VBox usersContainer;
    @FXML public Button verifiedTab;
    @FXML public Button unverifiedTab;

    private final UserService userService = new UserService();
    private Mode currentMode = Mode.UNVERIFIED;

    private enum Mode {
        VERIFIED,
        UNVERIFIED
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verifiedTab.setOnAction(event -> setMode(Mode.VERIFIED));
        unverifiedTab.setOnAction(event -> setMode(Mode.UNVERIFIED));
        setMode(currentMode);
    }

    private void setMode(Mode mode) {
        currentMode = mode;
        verifiedTab.setDisable(mode == Mode.VERIFIED);
        unverifiedTab.setDisable(mode == Mode.UNVERIFIED);
        refreshUsers();
    }

    private void refreshUsers() {
        usersContainer.getChildren().clear();
        List<User> registeredUsers = userService.getUsersByVerification(currentMode == Mode.VERIFIED);
        registeredUsers.forEach(this::addCard);
    }

    private void addCard(User user) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/admin/UserCard.fxml"));
            AnchorPane card = fxmlLoader.load();
            UserCardController userCardController = fxmlLoader.getController();
            userCardController.setData(user, this::handleVerifyRequest);
            usersContainer.getChildren().add(card);
        } 
        
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleVerifyRequest(User user) {
        userService.setUserVerified(user.getId(), true);
        refreshUsers();
    }
}
