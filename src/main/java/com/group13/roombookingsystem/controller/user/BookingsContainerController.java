package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.user.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookingsContainerController{
    public VBox BookingsContainer;

    public User user;

    List<Booking> myBookings;

    public void postInit(){
        myBookings = user.getBookings();

        for (Booking booking : myBookings){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/user/BookingCard.fxml"));
                AnchorPane card = fxmlLoader.load();
                BookingCardController bookingCardController = fxmlLoader.getController();
                bookingCardController.setData(booking);
                BookingsContainer.getChildren().add(card);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
