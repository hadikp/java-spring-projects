package locations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackPointTest {

    TrackPoint trackPoint = new TrackPoint(new Coordinate(12.5, 34.89), 123);
    TrackPoint trackPoint2 = new TrackPoint(new Coordinate(12.6, 34.123), 200);

    @Test
    public void testCreateTrackPoint() {

        assertEquals(34.89, trackPoint.getCoordinate().getLongitude());
        assertEquals(12.5, trackPoint.getCoordinate().getLatitude());
        assertEquals(123.0, trackPoint.getElevation());

    }

    @Test
    public void testGetDistance() {
        assertTrue(trackPoint.getDistanceFrom(trackPoint2) > 83988.01 && trackPoint.getDistanceFrom(trackPoint2) < 83988.11);
    }

    @Test
    void testSmallDistance() {
        Coordinate korhazC = new Coordinate(47.189115, 18.432758);
        TrackPoint korhaz = new TrackPoint(korhazC, 1);
        Coordinate molArena = new Coordinate(47.1874016,18.4303949);
        TrackPoint arena = new TrackPoint(molArena, 12);
        Coordinate auchanC = new Coordinate(47.1616715,18.4061907);
        TrackPoint auchan = new TrackPoint(auchanC, 1);
        Coordinate praktikerC = new Coordinate(47.1623709,18.3953054);
        TrackPoint praktiker = new TrackPoint(praktikerC, 1);
        Coordinate videotonC = new Coordinate(47.1982478,18.426655);
        TrackPoint videoton = new TrackPoint(videotonC, 3);

        Coordinate emokeC = new Coordinate(47.1832769,18.4153648);
        TrackPoint emoke = new TrackPoint(emokeC, 1);
        Coordinate lovoldev = new Coordinate(47.1864454,18.424767);
        TrackPoint lovoldevege = new TrackPoint(lovoldev, 2);
        Coordinate lovolde1C = new Coordinate(47.190135, 18.421741);
        TrackPoint lovolde1 = new TrackPoint(lovolde1C, 2);
        Coordinate haleszC = new Coordinate(47.194164, 18.431535);
        TrackPoint halesz = new TrackPoint(haleszC, 1);
        Coordinate budaiNaygszombatiC = new Coordinate(47.197875, 18.481305);
        TrackPoint budaiNagyszombati = new TrackPoint(budaiNaygszombatiC, 10);

        /*System.out.println(korhaz.getDistanceFrom(auchan)); //jó
        System.out.println(korhaz.getDistanceFrom(arena)); //nem jó
        System.out.println(korhaz.getDistanceFrom(praktiker)); // jó
        System.out.println(auchan.getDistanceFrom(arena)); // jó
        System.out.println();
        System.out.println(auchan.getDistanceFrom(korhaz)); // jó
        System.out.println(auchan.getDistanceFrom(praktiker)); // jó
        System.out.println(arena.getDistanceFrom(praktiker)); // nem jó
        System.out.println(arena.getDistanceFrom(auchan)); // jó
        System.out.println();
        System.out.println(videoton.getDistanceFrom(korhaz));
        System.out.println(videoton.getDistanceFrom(arena)); //nem jo
        System.out.println(videoton.getDistanceFrom(auchan));
        System.out.println(videoton.getDistanceFrom(praktiker));
        System.out.println();*/
        System.out.println(emoke.getDistanceFrom(lovolde1));
        System.out.println(lovolde1.getDistanceFrom(lovoldevege));
        System.out.println(lovoldevege.getDistanceFrom(halesz));
        System.out.println(halesz.getDistanceFrom(budaiNagyszombati));

    }
}