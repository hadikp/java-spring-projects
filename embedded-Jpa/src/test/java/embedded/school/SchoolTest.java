package embedded.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolTest {

    @Autowired
    SchoolRepository repository;

    @BeforeEach
    void init(){
        Address address = new Address("Veszprém", "Búzavirág ut", 12);
        School school = new School("Bólyai János gimnézium", address);
        repository.save(school);
    }

    @Test
    void test(){
        System.out.println();
    }

}