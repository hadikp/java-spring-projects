package blog.entry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EntryITTest {

    @Autowired
    EntryRepository repository;

    @Test
    void create(){
        Entry entry = new Entry("First post", "Description of first post", "Body of first post"
                , LocalDateTime.of(2022, 01, 15, 10, 10, 15));
        repository.save(entry);
    }

}