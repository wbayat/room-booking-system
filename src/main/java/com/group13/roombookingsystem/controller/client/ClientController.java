package com.group13.roombookingsystem.controller.client;

import com.group13.roombookingsystem.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ClientController implements Initializable {
    public BorderPane clientBorderPane;

    public void showBookARoomView(ActionEvent actionEvent) throws IOException {
        clientBorderPane.setCenter(SceneManager.getInstance().getRoomsLayoutRoot());
    }

    public void showMyBookingsView(ActionEvent actionEvent) throws IOException {
        clientBorderPane.setCenter(SceneManager.getInstance().getClientBookingsRoot());
    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneManager.getInstance().showLoginView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            clientBorderPane.setCenter(SceneManager.getInstance().getRoomsLayoutRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
