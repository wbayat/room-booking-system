package com.group13.roombookingsystem.controller.user;

import com.group13.roombookingsystem.model.room.Room;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.BookingService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RoomCardController implements Initializable {
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public Label sensorID;
    public DatePicker checkInDate;
    public ComboBox<LocalTime> checkinTime;
    public ComboBox<LocalTime> checkoutTime;
    public Button bookButton;
    public HBox iconBox;
    public ImageView projectorIcon;
    public ImageView speakerIcon;

    private Stage addPaymentMethodStage;

    public List<LocalTime> list = new ArrayList<>();

    public Room room;
    public User user;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkInDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusDays(30)));
            }
        });
    }

    public void setData(Room room){
        this.room = room;
        LocalTime time = LocalTime.of(9, 0);
        for(int i = 0; i < 13; i++) {
            list.add(time);
            time = time.plusHours(1);
        }

        roomID.setText(room.getRoomName());
        roomLocation.setText(room.getLocation());
        roomCapacity.setText(String.valueOf(room.getCapacity()));
        sensorID.setText(String.valueOf(room.getSensorId()));
        checkinTime.getItems().addAll(list);
        checkoutTime.getItems().addAll(list);
        if (!room.getHasProjector()){
            projectorIcon.setVisible(false);
        }
        if (!room.getHasSpeakers()){
            speakerIcon.setVisible(false);
        }
    }

    public void handleBookRoom(ActionEvent actionEvent) throws IOException {
        LocalDate selectedDate = checkInDate.getValue();
        LocalTime selectedCheckin = checkinTime.getValue();
        LocalTime selectedCheckout = checkoutTime.getValue();

        String validationError = validateBookingInput(selectedDate, selectedCheckin, selectedCheckout);
        if (validationError != null) {
            showBookingFailure(validationError);
            return;
        }


        boolean canCreateBooking = true;
        
        try {
            BookingService.getInstance().createBooking(user, room, selectedDate, selectedCheckin, selectedCheckout, null);
        } 
        catch (Exception e) {
            canCreateBooking = false;
        }

        

        if (addPaymentMethodStage == null || !addPaymentMethodStage.isShowing()){
            addPaymentMethodStage = new Stage();
            addPaymentMethodStage.setResizable(false);
            addPaymentMethodStage.setTitle("Add A Payment Method!");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/PaymentInfo.fxml"));
            addPaymentMethodStage.setScene(new Scene(loader.load()));
            PaymentInfoController controller = loader.getController();
            controller.setParentController(this);
            controller.postInit();
            addPaymentMethodStage.show();
        }
    }

    private String validateBookingInput(LocalDate date, LocalTime start, LocalTime end) {
        if (room == null || user == null) {
            return "Booking failed: Missing room or user information.";
        }
        if (date == null || start == null || end == null) {
            return "Booking failed: Please select a date, start time, and end time.";
        }
        if (!start.isBefore(end)) {
            return "Booking failed: Start time must be before end time.";
        }
        if (date.isBefore(LocalDate.now())) {
            return "Booking failed: Cannot book a room in the past.";
        }
        return null;
    }

    private void showBookingFailure(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Booking Failed");
        alert.setHeaderText("Booking Failed");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
