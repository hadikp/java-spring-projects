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
        /*Run futas1 = new Run("futás", "rövid futás", 5, LocalDate.of(2010, 01, 03));
        Run futas2 = new Run("futás", "rövid futás", 7.6, LocalDate.of(2010, 01, 17));
        Run futas3 = new Run("futás", "rövid futás", 6.2, LocalDate.of(2010, 01, 23));*/

       /* Run futas1 = new Run("futás", "rövid futás", 9.2, LocalDate.of(2009, 9, 05));
        Run futas2 = new Run("futás", "rövid futás", 31, LocalDate.of(2009, 9, 06));*/

        Run futas1 = new Run("futás", "rövid futás", 16, LocalDate.of(2012, 7, 8));
        Run futas2 = new Run("futás", "rövid futás", 16, LocalDate.of(2012, 7, 22));
        Run futas3 = new Run("futás", "rövid futás", 15, LocalDate.of(2012, 7, 30));
        Run futas4 = new Run("futás", "rövid futás", 17, LocalDate.of(2012, 6, 13));
        Run futas5 = new Run("futás", "rövid futás", 17, LocalDate.of(2012, 6, 16));
        Run futas6 = new Run("futás", "rövid futás", 19, LocalDate.of(2012, 6, 19));
        Run futas7 = new Run("futás", "rövid futás", 21, LocalDate.of(2012, 6, 20));
        Run futas8 = new Run("futás", "rövid futás", 24, LocalDate.of(2012, 6, 23));


        //Training training = new Training("futás", LocalDate.of(2009, 9,06));

        Training training = new Training("futás", LocalDate.of(2012, 7,30));
        //Training training = new Training("futás", LocalDate.of(2010, 01,23));

        training.addRuns(futas1);
        training.addRuns(futas2);
        training.addRuns(futas3);
        /*training.addRuns(futas4);
        training.addRuns(futas5);
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