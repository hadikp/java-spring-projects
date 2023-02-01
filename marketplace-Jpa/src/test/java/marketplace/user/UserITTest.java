package marketplace.user;

import marketplace.comment.Comment;
import marketplace.message.Message;
import marketplace.product.Product;
import marketplace.product.ProductRepository;
import marketplace.product.Type;
import marketplace.wish.Wish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository repository;

    User gergo;
    User peter;
    Product book1;
    Product book2;
    Product radio;

    @BeforeEach
    void init(){
        Product demand1 = new Product("könvv", "Ez a demand1 könyv", "src/images", 4300, Type.BOOK);
        Product demand2 = new Product("könvv", "Ez a demand2 könyv", "src/images", 3300, Type.BOOK);
        Product demand3 = new Product("rádió", "Ez a demand3 rádió", "src/images", 12300, Type.RADIO);
        Wish wish1 = new Wish("wish1", "wish1 description", Type.BOOK);
        Wish wish2 = new Wish("wish2", "wish2 description", Type.BOOK);
        Wish wish3 = new Wish("wish3", "wish3 description", Type.RADIO);

        gergo = new User("Gergő", "kissg", "kissg@gmail.com", "pass123", LocalDate.of(2022, 12, 25));
        peter = new User("Péter", "hadikp", "hadikg@gmail.com", "p123", LocalDate.of(2022, 12, 26));
        book1 = new Product("könyv", "Ez egy könyv", "src/images", 510, Type.BOOK);
        book2 = new Product("Másik könyv", "Ez a másik könyv", "src/images", 1510, Type.BOOK);
        radio = new Product("rádió", "Ez egy rádió", "src/images", 5510, Type.RADIO);



        Comment com1 = new Comment("com1 content", LocalDate.of(2022, 12, 11));
        Comment com2 = new Comment("com2 content", LocalDate.of(2022, 12, 12));
        Comment com3 = new Comment("com3 content", LocalDate.of(2022, 12, 13));

        Message message1 = new Message("message1 subject", "message1 content");
        Message message2 = new Message("message2 subject", "message2 content");
        Message message3 = new Message("message3 subject", "message3 content");
        book1.addComment(com1);
        book1.addComment(com2);
        book2.addComment(com3);

        gergo.addProduct(book1);
        gergo.addProduct(radio);
        gergo.addMessages(message1);
        peter.addProduct(book2);
        peter.addMessages(message2);
        peter.addMessages(message3);

        gergo.addComments(com1);
        gergo.addComments(com2);
        gergo.addWish(wish1);
        gergo.addWish(wish2);
        /*gergo.addDemand(demand1);
        gergo.addDemand(demand2);*/
        peter.addWish(wish3);
        peter.addComments(com3);
        repository.save(gergo);
        repository.save(peter);
    }

    @Test
    void test(){
        System.out.println();
    }

}