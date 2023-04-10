package com.example.demofx;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory FACTORY = null;

    public static EntityManager criarEntityManager() {
        if (FACTORY == null) {
            FACTORY = Persistence.createEntityManagerFactory("demo-fx-pu");
        }
        return FACTORY.createEntityManager();
    }

    public static void destruirEntityManagerFactory() {
        if (FACTORY != null) {
            FACTORY.close();
            FACTORY = null;
        }
    }
}
