package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Booking");
        alert.setHeaderText("Canceling Your Booking!");
        alert.setContentText("Are you sure you want to cancel this booking?");
        alert.show();
//        if (alert.showAndWait().get() == ButtonType.OK){
//            System.out.println("Clicked");
//        }
    }

    public void handleModifyBooking(ActionEvent actionEvent) throws IOException {
        if (modifyBookingStage == null || !modifyBookingStage.isShowing()){
            modifyBookingStage = new Stage();
            modifyBookingStage.setResizable(false);
            modifyBookingStage.setScene(new Scene(new FXMLLoader(getClass().getResource("/fxml/user/ModifyBookingCard.fxml")).load()));
            modifyBookingStage.setTitle("Modify Booking!");
            modifyBookingStage.show();
        }
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
