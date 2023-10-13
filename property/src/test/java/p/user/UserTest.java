package p.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import p.property.Category;
import p.property.Property;
import p.property.PropertyRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PropertyRepository propertyRepository;

    @BeforeEach
    void init(){
        Property lakas1 = new Property("Lakás1 leírás", Category.LAKAS, 1_000_000, "Veszprém", "Veszprém", "Bocskai ut", 1, false,
                LocalDate.of(2023,10,11), LocalDate.of(2024, 01, 11), List.of("src/images1", "src/images2", "src/images3"));
        Property lakas2 = new Property("Lakás2 leírás", Category.LAKAS, 2_000_000, "Fejér", "Székesfehérvár", "Budai út", 128, false, LocalDate.of(2023,9, 13), LocalDate.of(2023, 12, 13), List.of("src/images1", "src/images2", "src/images3"));
        Property telek = new Property("Telek leírás", Category.TELEK, 2_000_000, "Fejér", "Székesfehérvár", "Palotai út", 40, false, LocalDate.of(2023, 8, 21), LocalDate.of(2023, 11, 21), List.of("src/images1", "src/images2", "src/images3"));
        User eniko = new User("Enikő", "ve@gmail.com", "20-528-2234", "Székesfehérvár", "Tóvárosi Ln 42.", 1);
        User peter = new User("Péter", "pet@gmail.com", "20-522-1122", "Veszprém", "Vári út 11.", 2);

        propertyRepository.save(lakas1);
        propertyRepository.save(lakas2);
        propertyRepository.save(telek);

        eniko.addProperty(lakas1);
        eniko.addProperty(lakas2);
        peter.addProperty(telek);

        userRepository.save(eniko);
        userRepository.save(peter);
    }

    @Test
    void createMongoDb(){
        System.out.println();
    }


}