package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.BookingService;
import com.group13.roombookingsystem.service.RoomService;
import com.group13.roombookingsystem.service.observer.Observer;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class BookingsContainerController implements Observer {
    public VBox BookingsContainer;

    public User user;

    List<Booking> myBookings;

    public void postInit(){
        BookingService.getInstance().subscribe(this);
        refreshBookings();
    }

    public void refreshBookings() {
        myBookings = user.getBookings();
        BookingsContainer.getChildren().clear();

        for (Booking booking : myBookings){
            addCard(booking);
        }
    }

    private void addCard(Booking booking) {
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

    @Override
    public void onUpdate() {
        refreshBookings();
    }
}
