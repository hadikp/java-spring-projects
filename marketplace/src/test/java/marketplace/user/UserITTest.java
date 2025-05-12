package marketplace.user;

import marketplace.comment.Comment;
import marketplace.book.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository repository;

    User gergo;
    User peter;
    Book book1;
    Book book2;
    Book radio;

    @Test
    void testCreate(){
        gergo = new User("Gergő", "kissg", "Bárna", "kissg@gmail.com", "pass123", 1L, LocalDate.of(2022, 12, 23));
        peter = new User("Péter", "hadikp", "Veszprém", "hadikp@gmail.com", "p345", 2L, LocalDate.of(2022, 12, 24));
        book1 = new Book("könyv", "Ez egy könyv", Type.BOOK, Category.GIFT, true, "src/images", 510);
        book2 = new Book("Másik könyv", "Ez a másik könyv", Type.BOOK, Category.SALE, false, "src/images", 1510);
        radio = new Book("rádió", "Ez egy rádió", Type.RADIO, Category.GIFT, true, "src/images", 5510);

        Comment com1 = new Comment("com1 content", LocalDate.of(2022, 12, 11), this);
        Comment com2 = new Comment("com2 content", LocalDate.of(2022, 12, 12), this);
        Comment com3 = new Comment("com3 content", LocalDate.of(2022, 12, 13), this);

        book1.addComment(com1);
        book1.addComment(com2);
        book2.addComment(com3);

        gergo.addProduct(book1);
        gergo.addProduct(radio);
        peter.addProduct(book2);

        gergo.addComment(com1);
        gergo.addComment(com2);
        peter.addComment(com3);
        repository.save(gergo);
        repository.save(peter);
    }

}