package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.service.BookingService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class BookingCardController {
    public Booking booking;
    public Label checkinDate;
    public Label checkinTime;
    public Label checkoutTime;
    public Label RoomName;
    public Label RoomLocation;
    public Button modifyButton;
    public Button cancelButton;
    public Button checkinButton;
    public Label checkinMessage;

    private Stage modifyBookingStage;

    public void setData(Booking booking){
        this.booking = booking;
        RoomName.setText(booking.getRoomBooked().getRoomName());
        RoomLocation.setText(booking.getRoomBooked().getLocation());
        checkinDate.setText(String.valueOf(booking.getBookingDate()));
        checkinTime.setText(String.valueOf(booking.getStartTime()));
        checkoutTime.setText(String.valueOf(booking.getEndTime()));

        // determine whether to show the checkin button: show when local date/time >= booking start
        try {
            LocalDate today = LocalDate.now();
            LocalTime nowTime = LocalTime.now();
            LocalDate bookingDate = booking.getBookingDate();
            LocalTime bookingStart = booking.getStartTime();

            boolean show = false;
            if (today.isAfter(bookingDate)) {
                show = true;
            } else if (today.isEqual(bookingDate)) {
                if (!nowTime.isBefore(bookingStart)) { // now >= bookingStart
                    show = true;
                }
            }

            checkinButton.setVisible(show);
            checkinMessage.setVisible(false);
        } catch (Exception e) {
            // on any error, keep checkin button hidden
            if (checkinButton != null) checkinButton.setVisible(false);
        }
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

    @FXML
    public void handleCheckin(ActionEvent actionEvent) {
        if (booking == null || booking.getRoomBooked() == null) return;

        boolean ok = booking.getRoomBooked().getSensor()
                .scanBadge(booking.getRoomBooked(), booking.getRoomBooked().getRoomID(), booking.getUserId());

        if (ok) {
            if (checkinMessage != null) {
                checkinMessage.setText("Checkin successful");
                checkinMessage.setVisible(true);
            }
            if (checkinButton != null) checkinButton.setDisable(true);
            // Optionally mark booking as checked in via BookingService (not applied here)
        } else {
            if (checkinMessage != null) {
                checkinMessage.setText("Checkin failed: no valid booking or wrong sensor");
                checkinMessage.setVisible(true);
            }
        }
    }
}
