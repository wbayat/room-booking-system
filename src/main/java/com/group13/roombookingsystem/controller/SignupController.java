package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable{
    private SessionManager sessionManager;
    public TextField nameTextField;
    public Button SignUpButton;
    public Label signUpLabel;
    public Label errorLabel;
    public PasswordField confirmPasswordTextField;
    public TextField emailTextField;
    public PasswordField passwordTextField;
    public ComboBox<String> accountTypeComboBox;
    private final String[] accountTypes = {"Student", "Faculty", "Staff", "Partner"};

    public void hangleSignUp(ActionEvent actionEvent) {
        errorLabel.setText(accountTypeComboBox.getValue());
    }

    public void showLoginView(MouseEvent mouseEvent) throws IOException {
        sessionManager.showLoginView();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountTypeComboBox.getItems().addAll(accountTypes);
    }

    public void setSceneManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
