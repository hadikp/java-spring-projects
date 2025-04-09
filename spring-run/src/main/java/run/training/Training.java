package run.training;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.runs.Run;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name = "sun_month_km")
    private double monthlyKm;

    @Column(name = "sum_year_km")
    private double yearlyKm;

    @Column(name = "training_date")
    private LocalDate date;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Run> runs = new ArrayList<>();

    public Training(String type, LocalDate date) {
        this.type = type;
        this.date = date;
    }

    public void updateKmValues() {
        this.monthlyKm = getTrainingOneMonthDistance();
        this.yearlyKm = getTrainingAllDistance();
    }
    public void addRuns(Run run){
        runs.add(run);
        run.setTraining(this);
        updateKmValues();
    }


    public double getTrainingAllDistance(){
        double sum = 0;
        for (int i = 0; i < runs.size(); i++){
            double distance = runs.get(i).getKm();
            sum += distance;
        }
        return sum;
    }

    public double getTrainingOneMonthDistance(){
        List<Run> actual_month_run = runs.stream().filter(post -> post.getDate() != null)
                .filter(post -> post.getDate().getMonth() == LocalDate.now().getMonth())
                .collect(Collectors.toList());
        double sum = 0;
        for (int i = 0; i < actual_month_run.size(); i++){
            double distance = actual_month_run.get(i).getKm();
            sum += distance;
        }
        return sum;
    }
}
