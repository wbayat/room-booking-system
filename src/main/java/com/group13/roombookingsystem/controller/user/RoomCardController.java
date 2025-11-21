package com.group13.roombookingsystem.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RoomCardController implements Initializable {
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public DatePicker checkInDate;
    public ComboBox<String> checkinTime;
    public ComboBox<String> checkoutTime;
    public Button bookButton;

    private final String[] times = {"8 AM","10 AM","12 PM","2 PM","4 PM","6 PM","8 PM"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkInDate.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()));
            }
        });
    }

    public void setData(){
        roomID.setText("Room D");
        roomLocation.setText("BRG");
        checkinTime.getItems().addAll(times);
        checkoutTime.getItems().addAll(times);
    }

    public void handleBookRoom(ActionEvent actionEvent) {

    }
}
