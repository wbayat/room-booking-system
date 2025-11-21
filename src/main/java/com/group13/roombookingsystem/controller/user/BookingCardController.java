package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingCardController {
    private Booking booking;
    public Label checkinDate;
    public Label checkinTime;
    public Label checkoutTime;
    public Label RoomName;
    public Label RoomLocation;
    public Button modifyButton;
    public Button cancelButton;

    private Stage modifyBookingStage;

    public void setData(){
        RoomName.setText("Room A - BRG");
        checkinDate.setText("November 20, 2025");
        checkinTime.setText("3:00 PM");
        checkoutTime.setText("8:00 PM");
    }
    

    public void handleCancelBooking(ActionEvent actionEvent) {
    }

    public void handleModifyBooking(ActionEvent actionEvent) throws IOException {
        modifyBookingStage = new Stage();
        modifyBookingStage.setResizable(false);
        modifyBookingStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/fxml/user/ModifyBookingCard.fxml")).load()));
        modifyBookingStage.setTitle("Modify Booking!");
        modifyBookingStage.show();
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
