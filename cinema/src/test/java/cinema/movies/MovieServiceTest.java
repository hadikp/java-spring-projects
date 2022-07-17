package cinema.movies;

import cinema.actors.Actor;
import cinema.actors.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieServiceTest {

    @Autowired
    MoviesRepository repository;

    @Test
    void testCreate(){
        Address address = new Address("Veszprém", "Balatoni út", 112);
        Actor actor = new Actor("Arnold Schwarzenegger", 44, address);
        Movie movie = new Movie("Terminátor", LocalDateTime.of(2022, 02, 13, 20, 10), 350);
        movie.addActors(actor);
        repository.save(movie);
    }
}