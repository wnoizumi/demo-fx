package com.example.demofx.service;

import com.example.demofx.entities.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatosService {

    private List<Contato> contatos = new ArrayList<>();

    public List<Contato> getAllContatos() {
        return new ArrayList<>(contatos);
    }

    public void inserir(Contato contato) {
        if (contato != null) {
            contatos.add(contato);
        }
    }

    public void excluir(String telefone) {
        contatos.removeIf(c -> c.getTelefone().equals(telefone));
    }
}
