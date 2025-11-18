package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.manager.SessionManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SessionManager sessionManager = new SessionManager(stage);
        sessionManager.initStage();
    }
}
