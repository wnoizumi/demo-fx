package com.example.demofx.service;

import com.example.demofx.HibernateUtil;
import com.example.demofx.entities.Contato;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ContatosService {

    public List<Contato> getAllContatos() {
        var entityManager = HibernateUtil.criarEntityManager();
        return entityManager
                .createQuery("from Contato c", Contato.class)
                .getResultList();
    }

    public void inserir(Contato contato) {
        if (contato != null) {
            EntityManager entityManager = null;
            try {
                entityManager = HibernateUtil.criarEntityManager();
                entityManager.getTransaction().begin();
                entityManager.persist(contato);
                entityManager.getTransaction().commit();
            } finally {
                if (entityManager != null) {
                    entityManager.close();
                }
            }
        }
    }
}
