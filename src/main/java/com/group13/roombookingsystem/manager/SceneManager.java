package com.group13.roombookingsystem.manager;

import com.group13.roombookingsystem.view.MainGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class SceneManager {
    private static SceneManager sceneManager;

    private Scene scene;

    private AnchorPane loginView;
    private AnchorPane signupView;

    private BorderPane clientView;


    private SceneManager(){}

    public static SceneManager getInstance(){
        if (sceneManager == null){
            sceneManager = new SceneManager();
        }
        return sceneManager;
    }

    public void initMainScene() throws IOException {
        if (scene == null) {
            if (loginView == null){
                loginView = new FXMLLoader(MainGUI.class.getResource("/fxml/Login.fxml")).load();
            }
            scene = new Scene(loginView);
        }
    }

    public Scene getMainScene() {
        return scene;
    }

    public void showLoginView() throws IOException {
        if (loginView == null){
            loginView = new FXMLLoader(MainGUI.class.getResource("/fxml/Login.fxml")).load();
        }
        scene.setRoot(loginView);
    }

    public void showSignupView() throws IOException {
        if (signupView == null){
            signupView = new FXMLLoader(MainGUI.class.getResource("/fxml/SignUp.fxml")).load();
        }
        scene.setRoot(signupView);
    }

    public void showClientView() throws IOException {
        if (clientView == null){
            clientView = new FXMLLoader(MainGUI.class.getResource("/fxml/client/ClientView.fxml")).load();
        }
        scene.setRoot(clientView);
    }
}
