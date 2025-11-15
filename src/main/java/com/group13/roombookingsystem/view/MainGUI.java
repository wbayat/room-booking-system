package com.group13.roombookingsystem.view;

import com.group13.roombookingsystem.manager.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.getInstance().initMainScene();
        stage.setTitle("Room Booking System");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(SceneManager.getInstance().getMainScene());
        stage.show();
    }
}