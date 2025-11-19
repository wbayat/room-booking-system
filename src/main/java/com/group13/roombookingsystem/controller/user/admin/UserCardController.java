package com.group13.roombookingsystem.controller.user.admin;

import com.group13.roombookingsystem.model.user.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.function.Consumer;

public class UserCardController {
    public Label userName;
    public Label userRole;
    public Label userEmail;
    public Button verifyButton;

    private User currentUser;
    private Consumer<User> verificationHandler;

    public void setData(User user, Consumer<User> verificationHandler) {
        this.currentUser = user;
        this.verificationHandler = verificationHandler;
        userName.setText(user.getUsername());
        userEmail.setText(user.getUsername());
        userRole.setText(user.getRole());

        if (user.isVerified()) {
            verifyButton.setText("Verified");
            verifyButton.setDisable(true);
        } 
        
        else {
            verifyButton.setText("Verify");
            verifyButton.setDisable(false);
        }
    }

    public void handleVerifyUser(ActionEvent actionEvent) {
        verificationHandler.accept(currentUser);
    }
}
