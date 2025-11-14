package com.group13.roombookingsystem.controller;

import com.group13.roombookingsystem.manager.SceneManager;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable{
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
        Stage stage = ((Stage) ((Node) mouseEvent.getSource()).getScene().getWindow());
        stage.setScene(SceneManager.getInstance().getLoginScene());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountTypeComboBox.getItems().addAll(accountTypes);
    }
}
