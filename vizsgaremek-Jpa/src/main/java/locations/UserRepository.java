package locations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserRepository {

    private EntityManagerFactory factory;

    public UserRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public User saveUser(User user) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return user;
    }
}
