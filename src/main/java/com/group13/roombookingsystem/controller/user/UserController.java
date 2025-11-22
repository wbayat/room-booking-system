package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.manager.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController{

    public BorderPane mainContainer;
    public Label userType;
    public VBox buttonContainer;
    protected SessionManager sessionManager;
    private AnchorPane clientBookings;
    private AnchorPane roomsLayout;

    public void postInit() {
        userType.setText("Welcome " + sessionManager.getCurrentUser().getUsername().split("@")[0]);
        try {
            showBookARoomView(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showBookARoomView(ActionEvent actionEvent) throws IOException {
        if (roomsLayout == null){
            roomsLayout = new FXMLLoader(getClass().getResource("/fxml/user/RoomsContainer.fxml")).load();
        }
        mainContainer.setCenter(roomsLayout);
    }

    public void showMyBookingsView(ActionEvent actionEvent) throws IOException {
        if (clientBookings == null){
            clientBookings = new FXMLLoader(getClass().getResource("/fxml/user/BookingsContainer.fxml")).load();
        }
        mainContainer.setCenter(clientBookings);
    }


    public void handleLogout(ActionEvent actionEvent) throws IOException {
        sessionManager.showLoginView();
        sessionManager.reset();
    }

    public void setSceneManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
