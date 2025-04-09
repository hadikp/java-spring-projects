package run.runs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.training.Training;
import run.training.TrainingRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RunTest {

    @Autowired
    TrainingRepository repository;

    @Test
    void createDatabase() {
        Run futas1 = new Run("futás1", "rövid futás", 15, LocalDate.of(2025, 03, 01));
        Run futas2 = new Run("futás2", "rövid futás", 15, LocalDate.of(2025, 04, 02));
        Run bicigli = new Run("bicigli", "rövid bicigéizés", 25, LocalDate.of(2025, 04, 01));
        Training training = new Training("bicigli", LocalDate.now());
        training.addRuns(futas1);
        training.addRuns(futas2);
        repository.save(training);
    }

}