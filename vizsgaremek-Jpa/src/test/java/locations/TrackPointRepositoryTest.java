package locations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointRepositoryTest {

    TrackPointRepository trackPointRepository;
    TrainingRepository trainingRepository;
    UserRepository userRepository;
    EntityManagerFactory factory;

    @BeforeEach
    void init() {
        factory = Persistence.createEntityManagerFactory("pu");
        trackPointRepository = new TrackPointRepository(factory);
        trainingRepository = new TrainingRepository(factory);
        userRepository = new UserRepository(factory);
    }

    @AfterEach
    void closed() {
        factory.close();
    }

    @Test
    void testSavePeter() {
        Coordinate tovarosC = new Coordinate(47.182193, 18.410582);
        Coordinate lovoldeC = new Coordinate(47.190135, 18.421741);
        Coordinate lovoldeVegeC = new Coordinate(47.1864454,18.424767);
        Coordinate halesC = new Coordinate(47.19416411, 18.43153511);
        Coordinate nagyszombati = new Coordinate(47.197875, 18.481305);

        TrackPoint trackPointTovaros = new TrackPoint("Tóvárosi Lakónegyed", tovarosC, 2.1);
        TrackPoint trackPointLovolde = new TrackPoint("Lövöpde út", lovoldeC, 2.3);
        TrackPoint trackPointLovoldeVege = new TrackPoint("Lövölde vége", lovoldeVegeC, 2.3);
        TrackPoint trackPointHales = new TrackPoint("Halesz", halesC, 3.3);
        TrackPoint trackPointNagyszombati = new TrackPoint("Nagyszombati út", nagyszombati, 3.3);

        Training futas = new Training("futás", "Péter hosszú futása", LocalDate.of(2022, 05, 29));
        //futas.addTrackPoint(trackPointParktiker);
        futas.addTrackPoint(trackPointHales);
        futas.addTrackPoint(trackPointNagyszombati);
        //trainingRepository.saveTraining(futas);

        Coordinate korhazC = new Coordinate(47.1891151, 18.4327581);
        Coordinate auchanC = new Coordinate(47.1616715,18.4061907);
        Coordinate videotonC = new Coordinate(47.1982478,18.426655);

        TrackPoint trackPointKorhaz = new TrackPoint("Kórház", korhazC, 5.5);
        TrackPoint trackPointAuchen = new TrackPoint("Auchan", auchanC, 2.5);
        TrackPoint trackPointVidi = new TrackPoint("Videoton", videotonC, 3.1);

        Training bicigli = new Training("biciglizés", "Péter rövid bicajozása", LocalDate.of(2022, 05, 30));
        bicigli.addTrackPoint(trackPointKorhaz);
        bicigli.addTrackPoint(trackPointAuchen);
        bicigli.addTrackPoint(trackPointVidi);
        //trainingRepository.saveTraining(bicigli);

        User peter = new User("Péter", "hadikp@gmail.com", "pass");
        peter.addTraining(futas);
        peter.addTraining(bicigli);
        userRepository.saveUser(peter);
    }

    /*@Test
    void testSaveGergely() {


        Training futas = new Training("futás", "Gergő hosszú futása", LocalDate.of(2022, 05, 29));
        //futas.addTrackPoint(trackPointParktiker);
        futas.addTrackPoint(trackPointHales);
        futas.addTrackPoint(trackPointNagyszombati);
        //trainingRepository.saveTraining(futas);

        Coordinate korhazC = new Coordinate(47.1891151, 18.4327581);
        Coordinate praktikerC = new Coordinate(47.1623709,18.3953054);
        Coordinate auchanC = new Coordinate(47.1616715,18.4061907);
        Coordinate videotonC = new Coordinate(47.1982478,18.426655);

        TrackPoint trackPointKorhaz = new TrackPoint("Kórház", korhazC, 5.5);
        TrackPoint trackPointParktiker = new TrackPoint("Praktiker", praktikerC, 2.3);
        TrackPoint trackPointAuchen = new TrackPoint("Auchan", auchanC, 2.5);
        TrackPoint trackPointVidi = new TrackPoint("Videoton", videotonC, 3.1);

        Training bicigli = new Training("biciglizés", "Gergő rövid bicajozása", LocalDate.of(2022, 04, 30));
        bicigli.addTrackPoint(trackPointKorhaz);
        bicigli.addTrackPoint(trackPointAuchen);
        bicigli.addTrackPoint(trackPointVidi);
        //trainingRepository.saveTraining(bicigli);

        User gergely = new User("Gergő", "kovacs@gmail.com", "passpass");
        gergely.addTraining(futas);
        gergely.addTraining(bicigli);
        userRepository.saveUser(gergely);
    }
*/
}