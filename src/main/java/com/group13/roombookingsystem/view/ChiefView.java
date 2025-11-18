package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.controller.user.admin.chief.ChiefController;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ChiefView extends AdminView{
    public ChiefView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/UserView.fxml"));
        this.controller = new ChiefController();
        loader.setController(controller);
        this.view = loader.load();
    }
}
