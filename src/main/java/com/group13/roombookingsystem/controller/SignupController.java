package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SessionManager;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable{
    private final UserService userService = new UserService();
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
        errorLabel.setStyle("-fx-text-fill: red;");
        String accountType = accountTypeComboBox.getValue();
        String name = nameTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();

        if (name.isEmpty()) {
            errorLabel.setText("Please enter your name.");
            return;
        }
        if (email.isEmpty()) {
            errorLabel.setText("Please enter a valid email.");
            return;
        }
        if (password.isEmpty()) {
            errorLabel.setText("Password cannot be empty.");
            return;
        }
        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Passwords do not match.");
            return;
        }
        if (accountType == null || accountType.isBlank()) {
            errorLabel.setText("Choose an account type.");
            return;
        }

        try {
            userService.registerUser(new User(email, password, accountType, false));
            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("Account created successfully. Redirecting to login...");
            nameTextField.clear();
            emailTextField.clear();
            passwordTextField.clear();
            confirmPasswordTextField.clear();
            accountTypeComboBox.setValue(null);
            sessionManager.showLoginView();
        } 
        
        catch (IllegalArgumentException | IllegalStateException e) {
            errorLabel.setText(e.getMessage());
        } 
        
        catch (IOException e) {
            errorLabel.setText("Unable to show login view right now.");
        }
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
