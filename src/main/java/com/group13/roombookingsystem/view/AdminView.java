package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.controller.user.admin.AdminController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class AdminView extends UserView{
    public AdminView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/UserView.fxml"));
        this.controller = new AdminController();
        loader.setController(controller);
        this.view = loader.load();
    }
}
