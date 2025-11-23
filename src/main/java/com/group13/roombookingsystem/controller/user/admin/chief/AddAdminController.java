package com.group13.roombookingsystem.controller.user.admin.chief;

import com.group13.roombookingsystem.model.user.Admin;
import com.group13.roombookingsystem.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class AddAdminController implements Initializable {
    public TextField adminEmail;
    public TextField adminIdentification;
    public TextField tempPassword;
    private Consumer<Admin> onAdminAddedCallback;

    public void setOnAdminAddedCallback(Consumer<Admin> callback) {
        this.onAdminAddedCallback = callback;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tempPassword.setText("A1b2@3$45678");
    }

    public void handleCancel(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void handleAddAdmin(ActionEvent actionEvent) {
        try {
            Admin newAdmin = (Admin) UserService.getInstance()
                    .createAdmin(
                            adminEmail.getText().trim(),
                            tempPassword.getText(),
                            Integer.parseInt(adminIdentification.getText().trim())
                    );

            if (onAdminAddedCallback != null) {
                onAdminAddedCallback.accept(newAdmin);
            }
            handleCancel(actionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}