package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class UserController {

    public BorderPane mainContainer;
    public Label userType;
    public VBox buttonContainer;


    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneManager.getInstance().showLoginView();
        SceneManager.getInstance().reset();
    }
}
