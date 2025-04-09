package run.training;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import run.runs.Run;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {

    @Autowired
    TrainingRepository repository;

    @Test
    void testAllKm(){
        Run futas1 = new Run("futás1", "rövid futás", 15, LocalDate.of(2025, 04, 01));
        Run futas2 = new Run("futás2", "rövid futás", 15, LocalDate.of(2025, 04, 02));
        Run futas3 = new Run("futás3", "rövid futás", 10, LocalDate.of(2025, 04, 02));
        Training training = new Training("futások");
        training.addRuns(futas1);
        training.addRuns(futas2);
        training.addRuns(futas3);
        assertEquals(40, training.getTrainingAllDistance());
    }

    @Test
    void testOneMonthDistance(){
        Run futas1 = new Run("futás1", "rövid futás", 15, LocalDate.of(2025, 03, 01));
        Run futas2 = new Run("futás2", "rövid futás", 15, LocalDate.of(2025, 04, 02));
        Run futas3 = new Run("futás3", "rövid futás", 10, LocalDate.of(2025, 04, 02));
        Training training = new Training("futások");
        training.addRuns(futas1);
        training.addRuns(futas2);
        training.addRuns(futas3);
        assertEquals(25, training.getTrainingOneMonthDistance());
    }

}