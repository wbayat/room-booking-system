package com.group13.roombookingsystem.manager;

import com.group13.roombookingsystem.controller.LoginController;
import com.group13.roombookingsystem.controller.SignupController;
import com.group13.roombookingsystem.controller.user.UserController;
import com.group13.roombookingsystem.controller.user.admin.AdminController;
import com.group13.roombookingsystem.controller.user.admin.chief.ChiefController;
import com.group13.roombookingsystem.model.user.User;
import com.group13.roombookingsystem.view.MainGUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SessionManager {
    private final Stage stage;
    private Scene scene;
    private AnchorPane loginView;
    private AnchorPane signupView;
    private BorderPane userView;
    private User currentUser;

    public SessionManager(Stage stage) {
        this.stage = stage;
    }

    public void initMainScene() throws IOException {
        if (scene == null) {
            if (loginView == null){
                FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/LoginView.fxml"));
                loginView = loader.load();
                LoginController controller = loader.getController();
                controller.setSceneManager(this);
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
    }


    public void showLoginView() throws IOException {
        if (loginView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/LoginView.fxml"));
            loginView = loader.load();
            LoginController controller = loader.getController();
            controller.setSceneManager(this);
        }
        scene.setRoot(loginView);
    }

    public void showSignupView() throws IOException {
        if (signupView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/SignupView.fxml"));
            signupView = loader.load();
            SignupController controller = loader.getController();
            controller.setSceneManager(this);
        }
        scene.setRoot(signupView);
    }

    public void showUserView() throws IOException {
        if (userView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/UserView.fxml"));
            UserController controller = new UserController();
            loader.setController(controller);
            controller.setSceneManager(this);
            userView = loader.load();
        }
        scene.setRoot(userView);
    }

    public void showAdminView() throws IOException {
        if (userView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/UserView.fxml"));
            AdminController controller = new AdminController();
            loader.setController(controller);
            controller.setSceneManager(this);
            userView = loader.load();
        }
        scene.setRoot(userView);
    }
    public void showChiefView() throws IOException {
        if (userView == null){
            FXMLLoader loader = new FXMLLoader(MainGUI.class.getResource("/fxml/user/UserView.fxml"));
            AdminController controller = new ChiefController();
            loader.setController(controller);
            controller.setSceneManager(this);
            userView = loader.load();
        }
        scene.setRoot(userView);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void initStage() throws IOException {
        initMainScene();
        stage.setTitle("Room Booking System");
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setScene(getMainScene());
        stage.show();
    }
}
