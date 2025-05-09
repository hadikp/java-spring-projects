package run.training;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.bike.Bike;
import run.runs.Run;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Column(name = "sum_month_km")
    private BigDecimal monthlyKm;

    @Column(name = "sum_year_km")
    private BigDecimal yearlyKm;

    @Column(name = "training_date")
    private LocalDate date;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Run> runs = new ArrayList<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Bike> bikes = new ArrayList<>();

    public Training(String type, LocalDate date) {
        this.type = type;
        this.date = date;
    }

    public void setMonthlyKm(BigDecimal monthlyKm) {
        this.monthlyKm = monthlyKm;
    }

    public void setYearlyKm(BigDecimal yearlyKm) {
        BigDecimal bg = yearlyKm.setScale(1, RoundingMode.HALF_UP);
        this.yearlyKm = bg;
    }

    public void updateKmValues() {
        this.monthlyKm = BigDecimal.valueOf(getTrainingOneMonthDistance());
        this.yearlyKm = BigDecimal.valueOf(getTrainingAllDistance());
    }
    public void addRuns(Run run){
        runs.add(run);
        run.setTraining(this);
        //updateKmValues();
    }

    public void addBikes(Bike bike){
        bikes.add(bike);
        bike.setTraining(this);
        updateKmValues();
    }

    public double getTrainingAllDistance() {
        double sum = 0;
        if ("futás".equalsIgnoreCase(type)) {
            for (Run run : runs) {
                sum += run.getKm();
            }
        } else if ("bicigli".equalsIgnoreCase(type)) {
            for (Bike bike : bikes) {
                sum += bike.getKm();
            }
        }
        return sum;
    }

    public double getTrainingOneMonthDistance() {
        double sum = 0;

        if ("futás".equalsIgnoreCase(type)) {
            List<Run> actualMonthRuns = runs.stream()
                    .filter(run -> run.getDate() != null)
                    .filter(run -> run.getDate().getMonth() == LocalDate.of(2024, 12, 21).getMonth())
                    .collect(Collectors.toList());

            for (Run run : actualMonthRuns) {
                sum += run.getKm();
            }
        } else if ("bicigli".equalsIgnoreCase(type)) {
            List<Bike> actualMonthBikes = bikes.stream()
                    .filter(bike -> bike.getDate() != null)
                    .filter(bike -> bike.getDate().getMonth() == LocalDate.of(2019, 9, 21).getMonth())
                    .collect(Collectors.toList());

            for (Bike bike : actualMonthBikes) {
                sum += bike.getKm();
            }
        }

        return sum;
    }
}
