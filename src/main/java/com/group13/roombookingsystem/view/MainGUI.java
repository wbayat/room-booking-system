package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.manager.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    public MainGUI(){}

    public MainGUI(String[] args){
        super();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Room Booking System");
        stage.setScene(SceneManager.getInstance().getLoginScene());
        stage.show();
    }
}