package com.example.demofx;

import com.example.demofx.service.LoginService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LoginController loginController = new LoginController();
        loginController.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}