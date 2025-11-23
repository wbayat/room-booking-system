package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.booking.Booking;
import com.group13.roombookingsystem.service.BookingService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ModifyBookingController implements Initializable {
    public Label roomLocation1;
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public DatePicker checkInDate;
    public ComboBox<LocalTime> checkinTime;
    public ComboBox<LocalTime> checkoutTime;
    public Booking booking;

    public List<LocalTime> list = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    public void handleConfirmModify(ActionEvent actionEvent) {
        BookingService.getInstance().modifyBooking(booking,checkInDate.getValue(), checkinTime.getValue(),checkoutTime.getValue());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkInDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusDays(30)));
            }
        });
        LocalTime time = LocalTime.of(9, 0);
        for(int i = 0; i < 13; i++) {
            list.add(time);
            time = time.plusHours(1);
        }

        checkinTime.getItems().addAll(list);
        checkoutTime.getItems().addAll(list);
    }
}
