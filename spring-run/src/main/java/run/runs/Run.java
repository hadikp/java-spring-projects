package run.runs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String description;

    private Integer km;

    @Column(name = "run_date")
    private LocalDate date;

    public Run(String description, Integer km, LocalDate date) {
        this.description = description;
        this.km = km;
        this.date = date;
    }
}
