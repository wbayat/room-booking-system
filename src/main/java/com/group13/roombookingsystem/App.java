package com.group13.roombookingsystem;

import com.group13.roombookingsystem.repository.Database;
import com.group13.roombookingsystem.manager.SessionManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Database.initialize();
        new SessionManager(new Stage()).initStage();
    }
}
