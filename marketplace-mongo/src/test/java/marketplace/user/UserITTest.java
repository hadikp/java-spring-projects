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
        Product product = new Product("könyv", "Ez egy könyv", "src/images", 1000);
        User user = new User("peter", "hadik@gmail.com", "pass", LocalDate.of(2022, 12, 11));

        productRepository.save(product);
        user.addProduct(product);
        userRepository.save(user);
    }

    @Test
    void startTest(){
        System.out.println();
    }

}