package com.group13.roombookingsystem.controller.user.client.admin;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminRoomCardController {
    public Label roomID;
    public Label roomLocation;
    public Label roomCapacity;
    public Button toggleEnabled;

    public void setData(){
        roomID.setText("Room D");
        roomLocation.setText("BRG");
    }
}
