package locations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointRepositoryTest {

    TrackPointRepository trackPointRepository;
    TrainingRepository trainingRepository;
    EntityManagerFactory factory;

    @BeforeEach
    void init() {
        factory = Persistence.createEntityManagerFactory("pu");
        trackPointRepository = new TrackPointRepository(factory);
        trainingRepository = new TrainingRepository(factory);
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
        TrackPoint trackPointKorhaz = new TrackPoint("Kórház", korhazC, 5.5);
        TrackPoint trackPointAuchen = new TrackPoint("Auchan", auchanC, 2.5);
        TrackPoint trackPointVidi = new TrackPoint("Videoton", videotonC, 3.1);
        /*trackPointRepository.saveTrackPoint(trackPointKorhaz);
        trackPointRepository.saveTrackPoint(trackPointAuchen);
        trackPointRepository.saveTrackPoint(trackPointVidi);*/

        Training futas = new Training("Hosszú Futás");
        futas.addTrackPoint(trackPointKorhaz);
        futas.addTrackPoint(trackPointAuchen);
        futas.addTrackPoint(trackPointVidi);
        trainingRepository.saveTraining(futas);

        Coordinate praktikerC = new Coordinate(47.1623709,18.3953054);
        TrackPoint trackPointParktiker = new TrackPoint("Praktiker", praktikerC, 2.3);
        Training bicigli = new Training("Biciglizés");
        bicigli.addTrackPoint(trackPointParktiker);
        trainingRepository.saveTraining(bicigli);
    }

}