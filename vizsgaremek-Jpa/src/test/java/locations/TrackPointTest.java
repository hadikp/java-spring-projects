package locations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointTest {



    @Test
    void testDistancePeter() {
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

        System.out.println(trackPointTovaros.getDistanceFrom(trackPointLovolde)); //1221m nagyon pontos
        System.out.println(trackPointLovolde.getDistanceFrom(trackPointLovoldeVege)); //469m pontos
        System.out.println(trackPointLovoldeVege.getDistanceFrom(trackPointHales)); //999m pontos
        System.out.println(trackPointHales.getDistanceFrom(trackPointNagyszombati)); //3782 nagyon pontos
    }

}