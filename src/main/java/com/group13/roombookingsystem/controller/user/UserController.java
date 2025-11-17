package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.manager.SceneManager;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    public BorderPane mainContainer;
    public Label userType;
    public VBox buttonContainer;

    private AnchorPane clientBookings;
    private AnchorPane roomsLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userType.setText("Client Panel!");
        setUpUserMenu();
        try {
            showBookARoomView(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void setUpUserMenu(){
        Button bookARoomButton = new Button("Book A Room");
        bookARoomButton.getStyleClass().add("menu-button");
        bookARoomButton.setOnAction(event -> {
            try {
                showBookARoomView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Button myBookingsButton = new Button("My Bookings");
        myBookingsButton.getStyleClass().add("menu-button");
        myBookingsButton.setOnAction(event -> {
            try {
                showMyBookingsView(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        buttonContainer.getChildren().add(bookARoomButton);
        buttonContainer.getChildren().add(myBookingsButton);
    }

    public void showBookARoomView(ActionEvent actionEvent) throws IOException {
        if (roomsLayout == null){
            roomsLayout = new FXMLLoader(MainGUI.class.getResource("/fxml/user/RoomsContainer.fxml")).load();
        }
        mainContainer.setCenter(roomsLayout);
    }

    public void showMyBookingsView(ActionEvent actionEvent) throws IOException {
        if (clientBookings == null){
            clientBookings = new FXMLLoader(MainGUI.class.getResource("/fxml/user/BookingsContainer.fxml")).load();
        }
        mainContainer.setCenter(clientBookings);
    }


    public void handleLogout(ActionEvent actionEvent) throws IOException {
        SceneManager.getInstance().showLoginView();
        SceneManager.getInstance().reset();
    }
}
