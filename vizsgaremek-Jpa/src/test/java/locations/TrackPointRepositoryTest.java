package locations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointRepositoryTest {

    TrackPointRepository repository;
    EntityManagerFactory factory;

    @BeforeEach
    void init() {
        factory = Persistence.createEntityManagerFactory("pu");
        repository = new TrackPointRepository(factory);
    }

    @AfterEach
    void closed() {
        factory.close();
    }

    @Test
    void testSave() {
        Coordinate korhazC = new Coordinate(47.189115, 18.432758);
        Coordinate auchanC = new Coordinate(47.1616715,18.4061907);
        Coordinate videotonC = new Coordinate(47.1982478,18.426655);
        TrackPoint trackPointKorhaz = new TrackPoint(korhazC, 5.5);
        TrackPoint trackPointAuchen = new TrackPoint(auchanC, 2.5);
        TrackPoint trackPointVidi = new TrackPoint(videotonC, 3.1);
        repository.saveTrackPoint(trackPointKorhaz);
        repository.saveTrackPoint(trackPointAuchen);
        repository.saveTrackPoint(trackPointVidi);
    }

}