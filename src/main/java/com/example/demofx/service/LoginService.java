package com.example.demofx.service;

import com.example.demofx.entities.Usuario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoginService {

    private Map<String, Usuario> usuarios = new HashMap<>();
    private Usuario usuarioLogado = null;

    public LoginService() {
        usuarios.put("admin", new Usuario("admin", "admin"));
    }

    public boolean login(String nomeUsuario, String senha) {
        if (nomeUsuario == null || senha == null) {
            return false;
        }

         Usuario usuarioEncontrado = usuarios.get(nomeUsuario);
        if (usuarioEncontrado != null && usuarioEncontrado.getSenha().equals(senha)) {
            usuarioLogado = usuarioEncontrado;
            return true;
        }

        return false;
    }
}
