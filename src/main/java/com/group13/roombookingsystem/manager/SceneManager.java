package com.group13.roombookingsystem.manager;

import com.group13.roombookingsystem.controller.user.UserController;
import com.group13.roombookingsystem.controller.user.admin.AdminController;
import com.group13.roombookingsystem.controller.user.admin.chief.ChiefController;
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

    private BorderPane userView;

    private BorderPane adminView;

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
                loginView = new FXMLLoader(MainGUI.class.getResource("/fxml/LoginView.fxml")).load();
            }
            scene = new Scene(loginView);
        }
    }

    public Scene getMainScene() {
        return scene;
    }

    public void reset(){
        loginView = null;
        signupView = null;
        userView = null;
        adminView = null;
    }


    public void showLoginView() throws IOException {
        if (loginView == null){
            loginView = new FXMLLoader(MainGUI.class.getResource("/fxml/LoginView.fxml")).load();
        }
        scene.setRoot(loginView);
    }

    public void showSignupView() throws IOException {
        if (signupView == null){
            signupView = new FXMLLoader(MainGUI.class.getResource("/fxml/SignupView.fxml")).load();
        }
        scene.setRoot(signupView);
    }

    public void showUserView() throws IOException {
        if (userView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/UserView.fxml"));
            UserController controller = new UserController();
            loader.setController(controller);
            userView = loader.load();
        }
        scene.setRoot(userView);
    }

    public void showAdminView() throws IOException {
        if (adminView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/UserView.fxml"));
            AdminController controller = new AdminController();
            loader.setController(controller);
            adminView = loader.load();
        }
        scene.setRoot(adminView);
    }
    public void showChiefView() throws IOException {
        if (adminView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/UserView.fxml"));
            AdminController controller = new ChiefController();
            loader.setController(controller);
            adminView = loader.load();
        }
        scene.setRoot(adminView);
    }
}
