package locations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TrackPointRepository {

    private EntityManagerFactory factory;

    public TrackPointRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public TrackPoint saveTrackPoint(TrackPoint trackPoint) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(trackPoint);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return trackPoint;
    }

    public TrackPoint findTrackPointByName(String name) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("Select t from Trackpoint t where t.name = :name", TrackPoint.class)
                    .setParameter("name", name).getSingleResult();
        } finally {
            em.close();
        }
    }
}
