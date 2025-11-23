package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.manager.SessionManager;
import com.group13.roombookingsystem.model.booking.Booking;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookingsContainerController implements Initializable {
    public VBox BookingsContainer;

    List<Booking> myBookings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        myBookings = SessionManager.currentUser.getBookings();
//
//        for (Booking booking : myBookings){
//            try {
//                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/BookingCard.fxml"));
//                AnchorPane card = fxmlLoader.load();
//                BookingCardController bookingCardController = fxmlLoader.getController();
//                bookingCardController.setData();
//                BookingsContainer.getChildren().add(card);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
}
