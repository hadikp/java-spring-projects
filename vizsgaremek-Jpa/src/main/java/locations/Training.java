package locations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "training", cascade = CascadeType.PERSIST)
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint (TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
        trackPoint.setTraining(this);
    }

    public Training() {
    }

    public Training(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }

    public void setTrackPoints(List<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
