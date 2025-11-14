package com.group13.roombookingsystem.manager;

import com.group13.roombookingsystem.view.MainGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SceneManager {
    private static SceneManager sceneManager;

    private Scene loginScene;
    private Scene signupScene;
    private Scene clientScene;
    private AnchorPane clientBookings;
    private AnchorPane roomsLayout;

    private SceneManager(){}

    public static SceneManager getInstance(){
        if (sceneManager == null){
            sceneManager = new SceneManager();
        }
        return sceneManager;
    }

    public Scene getLoginScene() throws IOException {
        if (loginScene == null){
            loginScene = new Scene(new FXMLLoader(MainGUI.class.getResource("/fxml/Login.fxml")).load());
        }
        return loginScene;
    }

    public Scene getSignupScene() throws IOException {
        if (signupScene == null){
            signupScene = new Scene(new FXMLLoader(MainGUI.class.getResource("/fxml/SignUp.fxml")).load());
        }
        return signupScene;
    }

    public Scene getClientScene() throws IOException {
        if (clientScene == null){
            clientScene = new Scene(new FXMLLoader(MainGUI.class.getResource("/fxml/ClientView.fxml")).load());
        }
        return clientScene;
    }
    public AnchorPane getClientBookingsRoot() throws IOException {
        if (clientBookings == null){
            clientBookings = new FXMLLoader(MainGUI.class.getResource("/fxml/ClientBookings.fxml")).load();
        }
        return clientBookings;
    }
    public AnchorPane getRoomsLayoutRoot() throws IOException {
        if (roomsLayout == null){
            roomsLayout = new FXMLLoader(MainGUI.class.getResource("/fxml/CardLayout.fxml")).load();
        }
        return roomsLayout;
    }
}
