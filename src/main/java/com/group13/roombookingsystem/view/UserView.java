package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.controller.user.UserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class UserView {
    protected BorderPane view;
    protected UserController controller;

    public UserView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/UserView.fxml"));
        this.controller = new UserController();
        loader.setController(controller);
        this.view = loader.load();
    }

    public UserController getController(){
        return this.controller;
    }

    public BorderPane getView(){
        return this.view;
    }
}
