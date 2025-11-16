package com.group13.roombookingsystem.controller.user.client;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.io.IOException;

public class BookingCardController {
    public Label RoomID;
    public Label checkinDate;
    public Label checkinTime;
    public Label checkoutTime;

    public void setData(){
        RoomID.setText("Room A - BRG");
        checkinDate.setText("November 20, 2025");
        checkinTime.setText("3:00 PM");
        checkoutTime.setText("8:00 PM");
    }

    public void handleExtend(ActionEvent mouseEvent) throws IOException {
    }

    public void handleCancel(ActionEvent mouseEvent) throws IOException {
    }

}
