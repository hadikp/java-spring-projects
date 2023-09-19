package marketplace.user;

import marketplace.price.Details;
import marketplace.price.DetailsRepository;
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
    DetailsRepository detailsRepository;

    @BeforeEach
    void init(){
        Product konyv = new Product("könyv", "Ez egy könyv", "src/images");
        Product radio = new Product("rádió", "Ez egy rádió", "src/images");
        Product tv = new Product("tv", "Ez egy tv", "src/images");

        Details konyvDetails = new Details(1000, 1122);
        Details radioDetails = new Details(5000, 1133);
        Details tvDetails = new Details(15000, 1144);
        User peter = new User("peter", "hadik@gmail.com", "Székesfehérvár, Tóváros", "pass", LocalDate.of(2022, 12, 11));
        User gergo = new User("gergő", "geri@gmail.com", "Bárna, Csókás út", "pass2", LocalDate.of(2022, 11, 10));

        productRepository.save(konyv);
        productRepository.save(radio);
        productRepository.save(tv);

        userRepository.save(peter);

        konyvDetails.setUserId(peter.getId());

        detailsRepository.save(konyvDetails);
        detailsRepository.save(radioDetails);
        detailsRepository.save(tvDetails);

        konyv.addDetails(konyvDetails);
        konyv.addDetails(radioDetails);

        peter.addProduct(konyv);
        peter.addProduct(radio);
        peter.addProduct(tv);
        gergo.addProduct(tv);

        detailsRepository.save(konyvDetails);
        detailsRepository.save(radioDetails);
        detailsRepository.save(tvDetails);

        userRepository.save(peter);
        userRepository.save(gergo);
    }

    @Test
    void startTest(){
        System.out.println();
    }

}