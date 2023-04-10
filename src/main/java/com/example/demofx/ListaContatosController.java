package com.example.demofx;

import com.example.demofx.entities.Contato;
import com.example.demofx.service.ContatosService;
import com.example.demofx.view.ContatoViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ListaContatosController {

    private ContatosService contatosService = new ContatosService();
    private ObservableList<ContatoViewModel> contatosItems;
    @FXML
    private TableView<ContatoViewModel> contatosTableView;
    @FXML
    private TableColumn<ContatoViewModel, String> nomeTableColumn;
    @FXML
    private TableColumn<ContatoViewModel, String> telefoneTableColumn;
    @FXML
    private TextField nomeTextField;
    @FXML
    private TextField telefoneTextField;
    @FXML
    private TextField emailTextField;
    private Stage stage;

    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lista-contatos.fxml"));
        fxmlLoader.setControllerFactory(this::controllerFactory);
        var scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage = new Stage();
        stage.setTitle("Lista de Contatos");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("appicon.png")));
        stage.setMaximized(true);
        stage.show();
    }

    private Object controllerFactory(Class<?> clazz) {
        if (clazz == getClass()) {
            return this;
        }
        throw new IllegalStateException("Wrong controller!");
    }

    @FXML
    public void initialize() {
        nomeTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        telefoneTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("telefone"));

        contatosItems = FXCollections.observableList(getContatosDTOs());
        contatosTableView.setItems(contatosItems);

        contatosTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showContato(newValue));
    }

    private void showContato(ContatoViewModel newValue) {
        nomeTextField.setText(newValue.getNome());
        telefoneTextField.setText(newValue.getTelefone());
        emailTextField.setText(newValue.getEmail());
    }

    public void incluir(ActionEvent event) {
        try {
            Contato novoContato = new Contato();
            EditarContatoController contatoController = new EditarContatoController(novoContato);
            contatoController.show(stage);
            if (contatoController.foiSalvo()) {
                contatosService.inserir(novoContato);
                contatosItems.add(ContatoViewModel.fromContato(novoContato));
            }
        } catch (IOException e) {
        }
    }

    private List<ContatoViewModel> getContatosDTOs() {
        return contatosService.getAllContatos()
                .stream()
                .map(ContatoViewModel::fromContato)
                .collect(Collectors.toList());
    }
}
