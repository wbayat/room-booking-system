package com.group13.roombookingsystem.controller.client;

import com.group13.roombookingsystem.manager.SceneManager;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ClientController implements Initializable {
    public BorderPane clientBorderPane;

    private AnchorPane clientBookings;
    private AnchorPane roomsLayout;


    public void showBookARoomView(ActionEvent actionEvent) throws IOException {
        if (roomsLayout == null){
            roomsLayout = new FXMLLoader(MainGUI.class.getResource("/fxml/client/CardLayout.fxml")).load();
        }
        clientBorderPane.setCenter(roomsLayout);
    }

    public void showMyBookingsView(ActionEvent actionEvent) throws IOException {
        if (clientBookings == null){
            clientBookings = new FXMLLoader(MainGUI.class.getResource("/fxml/client/ClientBookings.fxml")).load();
        }
        clientBorderPane.setCenter(clientBookings);
    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneManager.getInstance().showLoginView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showBookARoomView(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
