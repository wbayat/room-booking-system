package com.group13.roombookingsystem.controller.client;

import com.group13.roombookingsystem.manager.SceneManager;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientNavBarController {
    public Button booARoomButton;
    public Button myBookingsButton;
    public Button logoutButton;

    public void handleLogout(ActionEvent actionEvent) throws IOException {

        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
        stage.setScene(SceneManager.getInstance().getLoginScene());
    }

    public void showBookARoomView(ActionEvent actionEvent) throws IOException {
    }

    public void showMyBookingsView(ActionEvent actionEvent) {
    }
}
