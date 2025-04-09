package run.runs;
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
@Table(name = "races")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String description;

    private double km;

    @Column(name = "run_date")
    private LocalDate date;

    public Run(String type, String description, double km, LocalDate date) {
        this.type = type;
        this.description = description;
        this.km = km;
        this.date = date;
    }

    @ManyToOne
    private Training training;


}
