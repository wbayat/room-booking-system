package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SessionManager;
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
            sessionManager.showUserView();
        } else if (emailTextField.getText().equals("admin")) {
            sessionManager.showAdminView();
        } else if (emailTextField.getText().equals("chief")) {
            sessionManager.showChiefView();
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