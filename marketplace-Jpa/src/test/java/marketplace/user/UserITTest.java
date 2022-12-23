package marketplace.user;

import marketplace.comment.Comment;
import marketplace.product.Product;
import marketplace.product.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository repository;

    User gergo;
    User peter;
    Product book1;
    Product book2;
    Product radio;

    @BeforeEach
    void init(){
        gergo = new User("Gergő", "kissg",
                "kissg@gmail.com", "pass123", LocalDate.of(2022, 12, 25));
        peter = new User("Péter", "hadikp",
                "hadikg@gmail.com", "p123", LocalDate.of(2022, 12, 26));
        book1 = new Product("könyv", "Ez egy könyv", "src/images", 510, Type.BOOK);
        book2 = new Product("Másik könyv", "Ez a másik könyv", "src/images", 1510, Type.BOOK);
        radio = new Product("rádió", "Ez egy rádió", "src/images", 5510, Type.RADIO);
        gergo.addProduct(book1);
        gergo.addProduct(radio);
        peter.addProduct(book2);

        Comment com1 = new Comment("com1 content", LocalDate.of(2022, 12, 11));
        Comment com2 = new Comment("com2 content", LocalDate.of(2022, 12, 12));
        Comment com3 = new Comment("com3 content", LocalDate.of(2022, 12, 13));
        gergo.addComments(com1);
        gergo.addComments(com2);
        peter.addComments(com3);
        repository.save(gergo);
        repository.save(peter);
    }

    @Test
    void test(){
        System.out.println();
    }

}