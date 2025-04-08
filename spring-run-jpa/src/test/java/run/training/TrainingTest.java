package run.training;

import org.junit.jupiter.api.Test;
import run.run.Post;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainingTest {


    @Test
    void testAllKm(){
        Post futas1 = new Post("futás1", "rövid futás", 15, LocalDate.of(2025, 04, 01));
        Post futas2 = new Post("futás2", "rövid futás", 15, LocalDate.of(2025, 04, 02));
        Post futas3 = new Post("futás3", "rövid futás", 10, LocalDate.of(2025, 04, 02));
        Training training = new Training("futások", 20);
        training.addPosts(futas1);
        training.addPosts(futas2);
        training.addPosts(futas3);
        assertEquals(40, training.getTrainingAllDistance());
    }

    @Test
    void testActualMonthKm(){
        Post futas1 = new Post("futás1", "rövid futás", 15, LocalDate.of(2025, 03, 01));
        Post futas2 = new Post("futás2", "rövid futás", 10, LocalDate.of(2025, 04, 02));
        Post futas3 = new Post("futás3", "rövid futás", 15, LocalDate.of(2025, 04, 21));
        Training training = new Training("futások", 20);
        training.addPosts(futas1);
        training.addPosts(futas2);
        training.addPosts(futas3);
        assertEquals(25, training.getTrainingOneMonthDistance());
    }

}