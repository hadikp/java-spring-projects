package run.bike;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import run.run.Post;
import run.training.Training;
import run.training.TrainingRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BikeTest {

    @Autowired
    TrainingRepository repository;

    @Test
    void createBike(){
        Post futas1 = new Post("futás1", "rövid futás", 15, LocalDate.of(2025, 04, 01));
        Post futas2 = new Post("futás2", "rövid futás", 25, LocalDate.of(2025, 04, 02));
        Post futas3 = new Post("futás3", "rövid futás", 10, LocalDate.of(2025, 04, 02));
        Bike  bike1 = new Bike("bicigli", "rövid bike", 20, LocalDate.of(2025, 04, 12));
        Bike  bike2 = new Bike("bicigli", "rövid bike", 25, LocalDate.of(2025, 04, 15));
        Training fut = new Training("futások", 20);
        Training bicigli = new Training("bicigli", 30);

        fut.addPosts(futas1);
        fut.addPosts(futas2);
        fut.addPosts(futas3);

        bicigli.addBike(bike1);
        bicigli.addBike(bike2);
        repository.save(fut);
        repository.save(bicigli);


    }

}