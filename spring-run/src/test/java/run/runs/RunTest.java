package run.runs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RunTest {

    @Autowired
    RunRepository repository;

    @Test
    void create(){
        Run run = new Run("rövid futás", 10, LocalDate.of(2025, 04, 12));
        repository.save(run);
    }

}