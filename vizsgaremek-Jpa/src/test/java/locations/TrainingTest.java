package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {

    List<TrackPoint> trackPoints;

    @BeforeEach
    void init() {
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

        trackPoints = new ArrayList<>(List.of(trackPointTovaros, trackPointLovolde, trackPointLovoldeVege, trackPointHales, trackPointNagyszombati));
    }

    @Test
    void testGetTrainingAllDistance() {
        Training training = new Training("futás", "Hosszú futás", LocalDate.of(2022, 05, 30));
        training.setTrackPoints(trackPoints);
        System.out.println(training.getTrainingAllDistance());
    }

}