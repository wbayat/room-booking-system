package com.group13.roombookingsystem;

import com.group13.roombookingsystem.repository.Database;
import com.group13.roombookingsystem.manager.SessionManager;
import javafx.stage.Stage;

public class App {
    public static void main(String[] args) throws Exception {
        Database.initialize();
        new SessionManager(new Stage()).initStage();
    }
}
