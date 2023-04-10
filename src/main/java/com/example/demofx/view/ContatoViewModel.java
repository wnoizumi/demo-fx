package com.example.demofx.view;

import com.example.demofx.entities.Contato;
import javafx.beans.property.SimpleStringProperty;

public class ContatoViewModel {
    private SimpleStringProperty nome;
    private SimpleStringProperty telefone;
    private SimpleStringProperty email;

    public ContatoViewModel(String nome, String telefone, String email) {
        this.nome = new SimpleStringProperty(nome);
        this.telefone = new SimpleStringProperty(telefone);
        this.email = new SimpleStringProperty(email);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public static ContatoViewModel fromContato(Contato contato) {
        return new ContatoViewModel(contato.getNome(), contato.getTelefone(), contato.getEmail());
    }

    public String getEmail() {
        return email.get();
    }
}
