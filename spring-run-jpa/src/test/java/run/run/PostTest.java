package run.run;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.training.Training;
import run.training.TrainingRepository;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostTest {

    @Autowired
    PostRepository repository;

    @Autowired
    TrainingRepository trainingRepository;

    @Test
    void create() {
        Training training_fut = new Training("futások", 20);
        Training training_by = new Training("kerékpár", 40);
        Post futas1 = new Post("futás1", "rövid futás", 15, LocalDate.of(2025, 04, 01));
        Post futas2 = new Post("futás2", "rövid futás", 18, LocalDate.of(2025, 04, 02));
        Post bicigli_1 = new Post("biciglizés1", "rövid edzés", 25, LocalDate.of(2025, 04, 02));
        Post bicigli_2 = new Post("biciglizés2", "rövid edzés", 35, LocalDate.of(2025, 04, 03));
        training_fut.addPosts(futas1);
        training_fut.addPosts(futas2);
        training_by.addPosts(bicigli_1);
        training_by.addPosts(bicigli_2);
        //trainingRepository.save(training_fut);
        //trainingRepository.save(training_by);
    }
}