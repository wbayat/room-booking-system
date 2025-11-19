package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SessionManager;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.model.user.university.admin.Admin;
import com.group13.roombookingsystem.model.user.university.admin.chief.ChiefEventCoordinator;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController {

    public Button loginButton;
    public Label errorLabel;
    public TextField emailTextField;
    public PasswordField passwordTextField;
    private SessionManager sessionManager;

    public void hangleLogin(ActionEvent mouseEvent) throws IOException {
        System.out.println("email: " + emailTextField.getText() + ", password: " + passwordTextField.getText());


        if(emailTextField.getText().equals("client")){
            User user = new User();
            sessionManager.setCurrentUser(user);
            sessionManager.showUserView();
        } else if (emailTextField.getText().equals("admin")) {
            User user = new Admin();
            sessionManager.setCurrentUser(user);
            sessionManager.showUserView();
        } else if (emailTextField.getText().equals("chief")) {
            User user = new ChiefEventCoordinator();
            sessionManager.setCurrentUser(user);
            sessionManager.showUserView();
        }else {
            errorLabel.setText("Enter client, admin, or chief");
        }

        emailTextField.setText("");
        passwordTextField.setText("");

    }

    public void showSignUpView(MouseEvent mouseEvent) throws IOException {
        sessionManager.showSignupView();
    }

    public void setSceneManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}