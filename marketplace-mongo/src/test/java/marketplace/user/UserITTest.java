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
import java.time.LocalDateTime;

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
        Product konyvWilbur = new Product("A tigris szeme", "Ez egy kalandregény", "src/images");
        Product konyvAsimov = new Product("Én a robot", "Ez egy Sci-fi", "src/images");
        Product radio = new Product("rádió", "Ez egy rádió", "src/images");
        Product tv = new Product("tv", "Ez egy tv", "src/images");
        Product tv2 = new Product("tv2", "Ez egy tv2", "src/images");

        Details konyvDetails = new Details(3000, 1122);
        Details konyvWilburDetails = new Details(4000, 1133);
        Details konyvAsimovDetails = new Details(4500, 1144);
        Details konyvAsimovDetails2 = new Details(5500, 1155);
        Details konyvAsimovDetails3 = new Details(6500, 1166);
        Details radioDetails = new Details(5000, 2211);
        Details tvDetails = new Details(15000, 3311);
        Details tv2Details = new Details(17000, 3322);
        User peter = new User("Péter", "hadik@gmail.com", "Székesfehérvár, Tóváros 11", "pass", LocalDateTime.of(2022, 12, 11, 11,22));
        User gergo = new User("Gergő", "geri@gmail.com", "Bárna, Csókás út 5", "pass2", LocalDateTime.of(2022, 11, 10, 10,11));
        User jani = new User("János", "jani@gmail.com", "Veszprém, Fenyő út 22", "pass22", LocalDateTime.of(2023, 10, 22, 12, 23));

        productRepository.save(konyv);
        productRepository.save(konyvWilbur);
        productRepository.save(konyvAsimov);
        productRepository.save(radio);
        productRepository.save(tv);
        productRepository.save(tv2);

        userRepository.save(peter);
        userRepository.save(gergo);
        userRepository.save(jani);

        konyvDetails.setUserId(peter.getId());
        konyvWilburDetails.setUserId(peter.getId());
        konyvAsimovDetails.setUserId(peter.getId());
        konyvAsimovDetails2.setUserId(peter.getId());
        konyvAsimovDetails3.setUserId(gergo.getId());
        radioDetails.setUserId(gergo.getId());
        tvDetails.setUserId(jani.getId());
        tv2Details.setUserId(jani.getId());

        detailsRepository.save(konyvDetails);
        detailsRepository.save(konyvWilburDetails);
        detailsRepository.save(konyvAsimovDetails);
        detailsRepository.save(konyvAsimovDetails2);
        detailsRepository.save(konyvAsimovDetails3);
        detailsRepository.save(radioDetails);
        detailsRepository.save(tvDetails);
        detailsRepository.save(tv2Details);

        konyv.addDetails(konyvDetails);
        konyvWilbur.addDetails(konyvWilburDetails);
        konyvAsimov.addDetails(konyvAsimovDetails);
        konyvAsimov.addDetails(konyvAsimovDetails2);
        konyvAsimov.addDetails(konyvAsimovDetails3);
        radio.addDetails(radioDetails);
        tv.addDetails(tvDetails);
        tv2.addDetails(tv2Details);

        peter.addProduct(konyv);
        peter.addProduct(konyvWilbur);
        peter.addProduct(konyvAsimov);
        gergo.addProduct(radio);
        gergo.addProduct(konyvAsimov);
        jani.addProduct(tv);
        jani.addProduct(tv2);

        detailsRepository.save(konyvDetails);
        detailsRepository.save(konyvWilburDetails);
        detailsRepository.save(konyvAsimovDetails);
        detailsRepository.save(konyvAsimovDetails2);
        detailsRepository.save(konyvAsimovDetails3);
        detailsRepository.save(radioDetails);
        detailsRepository.save(tvDetails);
        detailsRepository.save(tv2Details);

        userRepository.save(peter);
        userRepository.save(gergo);
        userRepository.save(jani);
    }

    @Test
    void startTest(){
        System.out.println();
    }

}