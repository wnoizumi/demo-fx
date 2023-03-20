package com.example.demofx;

import com.example.demofx.entities.Contato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

public class EditarContatoController {

    private final Contato contato;
    private boolean salvo = false;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField telefoneTextField;
    @FXML
    private TextField emailTextField;
    private Stage stage;

    public EditarContatoController(Contato contato) {
        this.contato = contato;
    }

    public void salvar(ActionEvent event) {
        if (camposValidos()) {
            contato.setNome(nomeTextField.getText());
            contato.setTelefone(telefoneTextField.getText());
            contato.setEmail(emailTextField.getText());
            salvo = true;
            stage.close();
        } else {
            salvo = false;
        }
    }

    private boolean camposValidos() {
        return true;
    }

    public void cancelar(ActionEvent event) {
        salvo = false;
        stage.close();
    }

    public void show(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("editar-contato.fxml"));
        fxmlLoader.setControllerFactory(this::controllerFactory);
        var scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage = new Stage();
        stage.setTitle("Contato");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(primaryStage);

        stage.setScene(scene);
        stage.setMaximized(false);
        stage.showAndWait();
    }

    private Object controllerFactory(Class<?> clazz) {
        if (clazz == getClass()) {
            return this;
        }
        throw new IllegalStateException("Wrong controller!");
    }

    public boolean foiSalvo() {
        return salvo;
    }
}
