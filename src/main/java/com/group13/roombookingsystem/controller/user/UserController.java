package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.manager.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/RoomsContainer.fxml"));
            roomsLayout = loader.load();
            RoomsContainerController controller = loader.getController();
            controller.user = sessionManager.getCurrentUser();
            controller.refreshRooms();
        }
        clientBookings = null;
        mainContainer.setCenter(roomsLayout);
    }

    public void showMyBookingsView(ActionEvent actionEvent) throws IOException {
        if (clientBookings == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/BookingsContainer.fxml"));
            clientBookings = loader.load();
            BookingsContainerController controller = loader.getController();
            controller.user = sessionManager.getCurrentUser();
            controller.postInit();
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
