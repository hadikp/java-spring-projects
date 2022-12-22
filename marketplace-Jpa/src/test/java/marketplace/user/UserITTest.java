package marketplace.user;

import marketplace.product.Product;
import marketplace.product.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository repository;

    @Test
    void testCreate(){
        User user = new User("Gergő", "hadikg",
                "hadikg@gmail.com", "pass123", LocalDate.of(2022, 12, 25));
        Product book = new Product("könyv", "Ez egy könyv", "src/images", 510, Type.BOOK);
        Product radio = new Product("rádió", "Ez egy rádió", "src/images", 510, Type.RADIO);
        user.addProduct(book);
        user.addProduct(radio);
        repository.save(user);
    }
}