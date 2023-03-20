package com.example.demofx;

import com.example.demofx.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usuarioTextField;
    @FXML
    private PasswordField senhaPasswordField;

    @FXML
    private Label erroLabel;
    private LoginService loginService;
    private Stage stage;

    public LoginController() {
        this.loginService = new LoginService();
    }


    public void login(ActionEvent actionEvent) {
        if (loginService.login(usuarioTextField.getText(), senhaPasswordField.getText())) {
            erroLabel.setText("");
            ListaContatosController listaContatosController = new ListaContatosController();
            try {
                listaContatosController.show();
                stage.close();
            } catch (IOException e) {
                erroLabel.setText("Falha ao realizar o login.");
            }
        } else {
            erroLabel.setText("Usuário e/ou senha estão incorretos.");
        }
    }

    public void show(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        fxmlLoader.setControllerFactory(this::controllerFactory);
        var scene = new Scene(fxmlLoader.load());
        stage.setTitle("Agenda - Login");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("login.png")));
        senhaPasswordField.setOnAction(this::login);
        stage.show();
    }

    private Object controllerFactory(Class<?> clazz) {
        if (clazz == getClass()) {
            return this;
        }
        throw new IllegalStateException("Wrong controller!");
    }
}
