package properties.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import properties.property.Property;
import properties.property.PropertyRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @BeforeEach
    void init(){

        Property lakas1 = new Property("Lakás1 leírás", "Lakás", 1_000_000, "Veszprém", "Veszprém",
                List.of("src/images1", "src/images2", "src/images3"));
        Property lakas2 = new Property("Lakás2 leírás", "Lakás", 2_000_000, "Fejér", "Székesfehérvár",
                List.of("src/images1", "src/images2", "src/images3"));
        User eniko = new User("Enikő", "ve@gmail.com", "20-528-2234", "Székesfehérvár", "Tóvárosi Ln 42.", 1);

        propertyRepository.save(lakas1);
        propertyRepository.save(lakas2);

        eniko.addProperty(lakas1);
        eniko.addProperty(lakas2);

        userRepository.save(eniko);
    }

    @Test
    void startMongoDB(){
        System.out.println();
    }

}