package locations;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate date;

    @ManyToOne
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<TrackPoint> trackPoints = new ArrayList<>();

    public Training() {
    }

    public Training(String name, String description, LocalDate date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public void addTrackPoint (TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
        trackPoint.getTrainings().add(this);
    }

    public double getTrainingAllDistance() {
        double sum = 0;
        for (int i = 0; i < trackPoints.size(); i++) {
            double distance = trackPoints.get(i).getDistanceFrom(trackPoints.get(1+1));
            sum += distance;
            System.out.println(sum);
        }
        return sum;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
