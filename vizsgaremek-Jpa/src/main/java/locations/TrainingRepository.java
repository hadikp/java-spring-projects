package locations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TrainingRepository {

    private EntityManagerFactory factory;

    public TrainingRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Training saveTraining(Training training) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(training);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return training;
    }
}
