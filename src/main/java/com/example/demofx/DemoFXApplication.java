package com.example.demofx;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class DemoFXApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LoginController loginController = new LoginController();
        loginController.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}