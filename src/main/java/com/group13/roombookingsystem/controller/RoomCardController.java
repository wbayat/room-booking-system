package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.model.room.Room;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class RoomCardController{
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public DatePicker checkInDate;
    public ComboBox checkInTime;
    public ComboBox checkoutTime;
    public Button bookButton;

    public void setData(){
        roomID.setText("Room D");
        roomLocation.setText("BRG");
    }
}
