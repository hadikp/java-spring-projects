package run.runs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.training.Training;
import run.training.TrainingRepository;
import run.training.TrainingService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RunTest {

    @Autowired
    TrainingRepository repository;

    @Autowired
    TrainingService service;

    @Test
    void createRun2009() {
        Run b1 = new Run("bicigli", "rövid kerékpározás", 30, LocalDate.of(2013, 5, 5));
        Run futas1 = new Run("futás", "rövid futás", 15, LocalDate.of(2013, 5, 8));
        Run b2 = new Run("bicigli", "rövid kerékpározás", 30, LocalDate.of(2013, 5, 11));
        Run b3 = new Run("bicigli", "rövid kerékpározás", 15, LocalDate.of(2013, 5, 16));
        Run futas2 = new Run("futás", "rövid futás", 15, LocalDate.of(2013, 5, 22));
        Run b4 = new Run("bicigli", "rövid kerékpározás", 15, LocalDate.of(2013, 5, 22));
        Run b5 = new Run("bicigli", "rövid kerékpározás", 30, LocalDate.of(2013, 5, 24));
        Run futas3 = new Run("futás", "rövid futás", 24, LocalDate.of(2013, 5, 26));
        Run futas4 = new Run("futás", "rövid futás", 24, LocalDate.of(2013, 5, 28));

        Run futas5 = new Run("futás", "rövid futás", 19, LocalDate.of(2012, 6, 19));
        Run futas6 = new Run("futás", "rövid futás", 21, LocalDate.of(2012, 6, 20));
        Run futas7 = new Run("futás", "rövid futás", 24, LocalDate.of(2012, 6, 23));

        Training training = new Training("futás", LocalDate.of(2013, 1,30));
        //Training training = new Training("futás", LocalDate.of(2010, 01,23));

        training.addRuns(futas1);
        training.addRuns(futas2);
        training.addRuns(futas3);
        training.addRuns(futas4);
        /*training.addRuns(futas5);
        training.addRuns(futas6);
        training.addRuns(futas7);
        training.addRuns(futas8);*/

        BigDecimal latestKm = service.getLatestKm();
        BigDecimal oneMonthDistance = BigDecimal.valueOf(training.getTrainingOneMonthDistance());
        BigDecimal dbSumKm =  latestKm.add(oneMonthDistance);
        training.setYearlyKm(dbSumKm);
        training.setMonthlyKm(oneMonthDistance);

        repository.save(training);
    }

    void createRun209() {
        Run futas1 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 01, 05));
        Run futas2 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 01, 11));
        Run futas3 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 01, 18));
        Run futas4 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 01, 26));
        Run futas5 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 02, 01));
        Run futas6 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 02, 01));
        Run futas7 = new Run("futás", "hosszű futás", 50, LocalDate.of(2025, 02, 01));
        Run futas8 = new Run("futás", "rövid futás", 15, LocalDate.of(2025, 02, 23));
        Run futas9 = new Run("futás", "rövid futás", 15, LocalDate.of(2025, 03, 01));
        Run bicigli = new Run("bicigli", "rövid bicigéizés", 25, LocalDate.of(2025, 01, 01));
        Training training = new Training("futás", LocalDate.of(2025, 01,30));
        training.addRuns(futas1);
        training.addRuns(futas2);
        training.addRuns(futas3);
        training.addRuns(futas4);
        training.addRuns(futas5);
        training.addRuns(futas6);
        training.addRuns(futas7);
        training.addRuns(futas8);
        training.addRuns(futas9);
        repository.save(training);
    }

}