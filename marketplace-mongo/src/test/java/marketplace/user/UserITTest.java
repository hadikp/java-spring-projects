package marketplace.user;

import marketplace.price.Price;
import marketplace.price.PriceRepository;
import marketplace.product.Product;
import marketplace.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PriceRepository priceRepository;

    @BeforeEach
    void init(){
        Product konyv = new Product("könyv", "Ez egy könyv", "src/images");
        Product radio = new Product("rádió", "Ez egy rádió", "src/images");
        Product tv = new Product("tv", "Ez egy tv", "src/images");
        Price konyvPrice = new Price(1000);
        Price radioPrice = new Price(5000);
        Price tvPrice = new Price(11000);
        User peter = new User("peter", "hadik@gmail.com", "Székesfehérvár, Tóváros", "pass", LocalDate.of(2022, 12, 11));
        User gergo = new User("gergő", "geri@gmail.com", "Bárna, Csókás út", "pass2", LocalDate.of(2022, 11, 10));

        productRepository.save(konyv);
        productRepository.save(radio);
        productRepository.save(tv);

        priceRepository.save(konyvPrice);
        priceRepository.save(radioPrice);
        priceRepository.save(tvPrice);

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