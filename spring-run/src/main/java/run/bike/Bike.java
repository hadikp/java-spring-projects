package run.bike;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.training.Training;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String description;

    private Integer km;

    @Column(name = "bike_date")
    private LocalDate date;

    public Bike(String type, String description, Integer km, LocalDate date) {
        this.type = type;
        this.description = description;
        this.km = km;
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Training training;
}
