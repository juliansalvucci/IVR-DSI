package com.mycompany.ivr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MigrationApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        // No necesitas hacer nada en particular para migrar la base de datos,
        // simplemente asegúrate de que las tablas se creen automáticamente cuando sea necesario
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
