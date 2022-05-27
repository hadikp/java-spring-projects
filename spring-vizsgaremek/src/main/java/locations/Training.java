package locations;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "training")
    private List<TrackPoint> trackpoints = new ArrayList<>();

    public void addTrackpoint(TrackPoint trackPoint) {
        trackpoints.add(trackPoint);
        trackPoint.setTraining(this);
    }


}
