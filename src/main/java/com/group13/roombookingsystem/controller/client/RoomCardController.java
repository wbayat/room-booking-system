package com.group13.roombookingsystem.controller.client;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class RoomCardController{
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public DatePicker checkInDate;
    public ComboBox<String> checkinTime;
    public ComboBox<String> checkoutTime;
    public Button bookButton;

    private final String[] times = {"8 AM","10 AM","12 PM","2 PM","4 PM","6 PM","8 PM"};

    public void setData(){
        roomID.setText("Room D");
        roomLocation.setText("BRG");
        checkinTime.getItems().addAll(times);
        checkoutTime.getItems().addAll(times);
    }
}
