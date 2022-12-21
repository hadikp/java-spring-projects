package marketplace.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository repository;

    @Test
    void testCreate(){
        User user = new User("Péter", "hadikp", "hadikp@gmail.com", "pass123", LocalDate.of(2022, 12, 23));
        repository.save(user);
    }

}