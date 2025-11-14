package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SceneManager;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
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


        Stage stage = ((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
        stage.setScene(SceneManager.getInstance().getClientScene());
    }

    public void showSignUpView(MouseEvent mouseEvent) throws IOException {
        Stage stage = ((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
        stage.setScene(SceneManager.getInstance().getSignupScene());
    }
}