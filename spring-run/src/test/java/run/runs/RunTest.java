package run.runs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.bike.Bike;
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
        Bike b1 = new Bike("bicigli", "rövid kerékpározás", 15, LocalDate.of(2015,12, 5));
        Bike b2 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2015, 10, 4));
        Bike b3 = new Bike("bicigli", "rövid kerékpározás", 15, LocalDate.of(2015, 10, 9));
        Bike b4 = new Bike("bicigli", "rövid kerékpározás", 15, LocalDate.of(2015, 10, 24));
        Bike b5 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2015, 10, 31));
        Bike b6 = new Bike("bicigli", "rövid kerékpározás", 15, LocalDate.of(2015, 10, 29));
        Bike b7 = new Bike("bicigli", "rövid kerékpározás", 15, LocalDate.of(2014, 8, 30));
        Bike b8 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2014, 8, 20));
        Bike b9 = new Bike("bicigli", "rövid kerékpározás", 20, LocalDate.of(2014, 8, 25));
        Bike b10 = new Bike("bicigli", "rövid kerékpározás", 15, LocalDate.of(2014, 8, 26));
        Bike b11 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2014, 8, 19));
        Bike b12 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2014, 8, 26));
        Bike b13 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2014, 8, 27));
        Bike b14 = new Bike("bicigli", "rövid kerékpározás", 30, LocalDate.of(2014, 8, 28));
        Bike b15 = new Bike("bicigli", "rövid kerékpározás", 10, LocalDate.of(2014, 8, 31));

        Run futas1 = new Run("futás", "rövid futás", 15, LocalDate.of(2015, 12, 5));
        Run futas2 = new Run("futás", "rövid futás", 16, LocalDate.of(2015, 12, 13));
        Run futas3 = new Run("futás", "rövid futás", 19, LocalDate.of(2015, 12, 20));
        Run futas4 = new Run("futás", "rövid futás", 15, LocalDate.of(2015, 12, 30));
        Run futas5 = new Run("futás", "rövid futás", 14, LocalDate.of(2015, 8, 19));
        Run futas6 = new Run("futás", "rövid futás", 15, LocalDate.of(2015, 8, 30));
        Run futas7 = new Run("futás", "rövid futás", 15, LocalDate.of(2015, 3, 23));
        Run futas8 = new Run("futás", "rövid futás", 8, LocalDate.of(2015, 3, 24));
        Run futas9 = new Run("futás", "rövid futás", 15, LocalDate.of(2015, 3, 29));

        Training training_fut = new Training("futás", LocalDate.of(2015, 12,30));
        Training training_bike = new Training("bicigli", LocalDate.of(2015, 12,5));

        training_fut.addRuns(futas1);
        training_fut.addRuns(futas2);
        training_fut.addRuns(futas3);
        training_fut.addRuns(futas4);
        /*training_fut.addRuns(futas5);
        training_fut.addRuns(futas6);
        training_fut.addRuns(futas7);
        training_fut.addRuns(futas8);
        training_fut.addRuns(futas9);*/


        training_bike.addBikes(b1);
        /*training_bike.addBikes(b2);
        training_bike.addBikes(b3);
        training_bike.addBikes(b4);
        training_bike.addBikes(b5);*/
        //training_bike.addBikes(b6);
        //training_bike.addBikes(b7);
        /*training_bike.addBikes(b8);
        training_bike.addBikes(b9);
        training_bike.addBikes(b10);
        training_bike.addBikes(b11);
        training_bike.addBikes(b12);
        training_bike.addBikes(b13);
        training_bike.addBikes(b14);
        training_bike.addBikes(b15);*/

        BigDecimal latestKm = service.getLatestKm();
        BigDecimal oneMonthDistance = BigDecimal.valueOf(training_fut.getTrainingOneMonthDistance());
        BigDecimal dbSumKm =  latestKm.add(oneMonthDistance);
        training_fut.setYearlyKm(dbSumKm);
        training_fut.setMonthlyKm(oneMonthDistance);

        repository.save(training_bike);
        repository.save(training_fut);
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