package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.exception.UserNotFoundException;
import com.group13.roombookingsystem.manager.SessionManager;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.UserService;
import com.group13.roombookingsystem.utilities.ValidationUtils;
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

        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        if (!ValidationUtils.isValidEmail(email)) {
            errorLabel.setText("Please enter a valid email address.");
            return;
        }

        if (password == null || password.isEmpty()) {
            errorLabel.setText("Password cannot be empty.");
            return;
        }

        try{
            User user = UserService.getInstance().login(email.trim(), password);
            sessionManager.setCurrentUser(user);
            sessionManager.showUserView();
        } catch (UserNotFoundException e){
            errorLabel.setText(e.getMessage());
        } finally {
            emailTextField.setText("");
            passwordTextField.setText("");
        }
    }

    public void showSignUpView(MouseEvent mouseEvent) throws IOException {
        sessionManager.showSignupView();
    }

    public void setSceneManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}