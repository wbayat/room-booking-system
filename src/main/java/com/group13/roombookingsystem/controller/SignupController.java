package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SessionManager;
import com.group13.roombookingsystem.service.UserService;
import com.group13.roombookingsystem.utilities.ValidationUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable{
    private SessionManager sessionManager;
    public Button SignUpButton;
    public Label signUpLabel;
    public Label errorLabel;
    public PasswordField confirmPasswordTextField;
    public TextField emailTextField;
    public PasswordField passwordTextField;
    public TextField identificationField;
    public ComboBox<String> accountTypeComboBox;
    private final String[] accountTypes = {"Student", "Faculty", "Staff", "Partner"};

    public void hangleSignUp(ActionEvent actionEvent) {
        errorLabel.setStyle("-fx-text-fill: red;");
        String accountType = accountTypeComboBox.getValue();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        String confirmPassword = confirmPasswordTextField.getText();
        String identificationText = identificationField.getText().trim();
        int identification;

        if (!ValidationUtils.isValidEmail(email)) {
            errorLabel.setText("Please enter a valid email address.");
            return;
        }
        if (!ValidationUtils.isValidPassword(password)) {
            errorLabel.setText("Password must be at least 8 characters long and include uppercase, lowercase, digit, and special character.");
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

        if (identificationText.isEmpty()) {
            errorLabel.setText("Please enter a valid identification.");
            return;
        }

        try {
            identification = Integer.parseInt(identificationText);
        } catch (NumberFormatException exception) {
            errorLabel.setText("Identification must be a number.");
            return;
        }

        try {
            UserService.getInstance().registerUser(email.trim(), password, identification, accountType, accountType.equals("Partner"));
            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("Account created successfully. Redirecting to login...");
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
