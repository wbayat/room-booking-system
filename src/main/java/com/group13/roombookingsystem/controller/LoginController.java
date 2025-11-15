package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SceneManager;
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

    public void hangleLogin(ActionEvent mouseEvent) throws IOException {
        System.out.println("email: " + emailTextField.getText() + ", password: " + passwordTextField.getText());


        if(emailTextField.getText().equals("client")){
            SceneManager.getInstance().showClientView();
        } else if (emailTextField.getText().equals("admin")) {
            SceneManager.getInstance().showAdminView();
        } else if (emailTextField.getText().equals("chief")) {
            SceneManager.getInstance().showChiefView();
        }else {
            errorLabel.setText("Enter client, admin, or chief");
        }

        emailTextField.setText("");
        passwordTextField.setText("");

    }

    public void showSignUpView(MouseEvent mouseEvent) throws IOException {
        SceneManager.getInstance().showSignupView();
    }
}