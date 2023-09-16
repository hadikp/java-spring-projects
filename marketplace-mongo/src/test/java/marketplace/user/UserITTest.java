package marketplace.user;

import marketplace.product.Product;
import marketplace.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void init(){
        Product konyv = new Product("könyv", "Ez egy könyv", "src/images", 1000);
        Product radio = new Product("rádió", "Ez egy rádió", "src/images", 5000);
        Product tv = new Product("tv", "Ez egy tv", "src/images", 15000);
        User peter = new User("peter", "hadik@gmail.com", "pass", LocalDate.of(2022, 12, 11));
        User gergo = new User("gergő", "geri@gmail.com", "pass2", LocalDate.of(2022, 11, 10));

        productRepository.save(konyv);
        productRepository.save(radio);
        productRepository.save(tv);
        peter.addProduct(konyv);
        peter.addProduct(radio);
        peter.addProduct(tv);
        gergo.addProduct(radio);
        gergo.addProduct(tv);
        userRepository.save(peter);
        userRepository.save(gergo);
    }

    @Test
    void startTest(){
        System.out.println();
    }

}