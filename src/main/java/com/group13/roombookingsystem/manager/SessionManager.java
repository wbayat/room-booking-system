package com.group13.roombookingsystem.manager;

import com.group13.roombookingsystem.controller.LoginController;
import com.group13.roombookingsystem.controller.SignupController;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.view.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SessionManager {
    private final Stage stage;
    private Scene scene;
    private AnchorPane loginView;
    private AnchorPane signupView;
    private UserView userView;
    private User currentUser;

    public SessionManager(Stage stage) {
        this.stage = stage;
    }

    public void initStage() throws IOException {
        initMainScene();
        stage.setTitle("Room Booking System");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    public void initMainScene() throws IOException {
        if (scene == null) {
            if (loginView == null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginView.fxml"));
                loginView = loader.load();
                LoginController controller = loader.getController();
                controller.setSceneManager(this);
            }
            scene = new Scene(loginView);
        }
    }

    public void reset(){
        loginView = null;
        signupView = null;
        userView = null;
    }

    public void showLoginView() throws IOException {
        if (loginView == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginView.fxml"));
            loginView = loader.load();
            LoginController controller = loader.getController();
            controller.setSceneManager(this);
        }
        scene.setRoot(loginView);
    }

    public void showSignupView() throws IOException {
        if (signupView == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SignupView.fxml"));
            signupView = loader.load();
            SignupController controller = loader.getController();
            controller.setSceneManager(this);
        }
        scene.setRoot(signupView);
    }

    public void showUserView() throws IOException {
        if (userView == null){
            userView = ViewFactory.createUserView(currentUser);
            userView.getController().setSceneManager(this);
            userView.getController().postInit();
        }
        scene.setRoot(userView.getView());
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
