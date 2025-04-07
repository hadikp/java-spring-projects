package run.run;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import run.training.Training;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String description;
    private Integer km;

    private LocalDate date;

    public Post(String type, String description, Integer km, LocalDate date) {
        this.type = type;
        this.description = description;
        this.km = km;
        this.date = date;
    }

    @ManyToOne
    private Training training;

    public void setTraining(Training training) {
        this.training = training;
    }
}
