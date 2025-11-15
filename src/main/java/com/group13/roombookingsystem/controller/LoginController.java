package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public Button loginButton;
    public Label errorLabel;
    public TextField emailTextField;
    public PasswordField passwordTextField;

    public void hangleLogin(ActionEvent mouseEvent) throws IOException {
        System.out.println("email: " + emailTextField.getText() + ", password: " + passwordTextField.getText());
        emailTextField.setText("");
        passwordTextField.setText("");


        SceneManager.getInstance().showClientView();
    }

    public void showSignUpView(MouseEvent mouseEvent) throws IOException {
        SceneManager.getInstance().showSignupView();
    }
}