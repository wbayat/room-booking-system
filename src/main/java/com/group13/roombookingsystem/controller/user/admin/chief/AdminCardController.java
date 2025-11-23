package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.model.user.Admin;
import javafx.scene.control.Label;

public class AdminCardController {
    public Label adminName;
    public Label adminEmail;

    public void setData(Admin admin){
        adminName.setText(admin.getUsername());
        adminEmail.setText(String.valueOf(admin.getVerificationNumber()));
    }
}
