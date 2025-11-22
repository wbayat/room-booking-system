package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.model.user.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminCardController {
    public Label adminName;
    public Label adminEmail;

    public void setData(User admin){
        adminName.setText(admin.getUsername());
        adminEmail.setText(String.valueOf(admin.getVerificationNumber()));
    }
}
