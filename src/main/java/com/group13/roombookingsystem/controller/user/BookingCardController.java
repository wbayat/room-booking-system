package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.service.BookingService;
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
    public Booking booking;
    public Label checkinDate;
    public Label checkinTime;
    public Label checkoutTime;
    public Label RoomName;
    public Label RoomLocation;
    public Button modifyButton;
    public Button cancelButton;

    private Stage modifyBookingStage;

    public void setData(Booking booking){
        this.booking = booking;
        RoomName.setText(booking.getRoomBooked().getRoomName() + " - " + booking.getRoomBooked().getLocation());
        checkinDate.setText(String.valueOf(booking.getBookingDate()));
        checkinTime.setText(String.valueOf(booking.getStartTime()));
        checkoutTime.setText(String.valueOf(booking.getEndTime()));
    }

    public void handleCancelBooking(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel Booking");
        alert.setHeaderText("Canceling Your Booking!");
        alert.setContentText("Are you sure you want to cancel this booking?");
        if (alert.showAndWait().get() == ButtonType.OK){
            BookingService.getInstance().cancelBooking(booking);
        }
    }

    public void handleModifyBooking(ActionEvent actionEvent) throws IOException {
        if (modifyBookingStage == null || !modifyBookingStage.isShowing()){
            modifyBookingStage = new Stage();
            modifyBookingStage.setTitle("Modify Booking!");
            modifyBookingStage.setResizable(false);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/ModifyBookingCard.fxml"));
            modifyBookingStage.setScene(new Scene(loader.load()));
            ModifyBookingController controller = loader.getController();
            controller.booking = booking;
            modifyBookingStage.showAndWait();
        }
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
