package run.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostTest {

    @Autowired
    PostRepository repository;

    @Test
    void create() {
        Post post = new Post("rövid futás", 15, LocalDate.of(2025, 04, 01));
        repository.save(post);
    }
}