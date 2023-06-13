package Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MigrationApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        // No necesitas hacer nada en particular para migrar la base de datos,
        // simplemente asegúrate de que las tablas se creen automáticamente cuando sea necesario
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
