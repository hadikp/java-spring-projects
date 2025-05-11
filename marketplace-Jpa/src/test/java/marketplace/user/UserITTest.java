package marketplace.user;

import marketplace.comment.Comment;
import marketplace.message.Message;
import marketplace.book.Book;
import marketplace.book.BookRepository;
import marketplace.book.Type;
import marketplace.wish.Wish;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository repository;

    User gergo;
    User peter;
    Book book1;
    Book book2;


    @BeforeEach
    void init(){
        book1 = new Book("író1", "Cím1", "sub1T", "Ez a demand1 könyv","1234","1999",false, false, "src/images");
        book2 = new Book("író2", "Cím2", "sub12", "Ez a demand2 könyv","1234","1998",false, false, "src/images");
        Book book3 = new Book("író3","Cím3", "sub1T", "Ez a demand3 könyv","1234","1997",false, false, "src/images");
        Wish wish1 = new Wish("wish1", "wish1 description", Type.BOOK);
        Wish wish2 = new Wish("wish2", "wish2 description", Type.BOOK);
        Wish wish3 = new Wish("wish3", "wish3 description", Type.RADIO);

        gergo = new User("Gergő", "kissg",List.of("Veszprém","Pápa"), "kissg@gmail.com", "pass123", LocalDate.of(2022, 12, 25));
        peter = new User("Péter", "hadikp",List.of("Veszprém", "Pápa"), "hadikg@gmail.com", "p123", LocalDate.of(2022, 12, 26));

        Comment com1 = new Comment("com1 content", LocalDate.of(2022, 12, 11));
        Comment com2 = new Comment("com2 content", LocalDate.of(2022, 12, 12));
        Comment com3 = new Comment("com3 content", LocalDate.of(2022, 12, 13));

        Message message1 = new Message("message1 subject", "message1 content");
        Message message2 = new Message("message2 subject", "message2 content");
        Message message3 = new Message("message3 subject", "message3 content");
        book1.addComment(com1);
        book1.addComment(com2);
        book2.addComment(com3);

        gergo.addBook(book1);
        gergo.addBook(book2);
        gergo.addMessages(message1);

        /*peter.addBook(book3);
        peter.addMessages(message2);
        peter.addMessages(message3);*/

        gergo.addComments(com1);
        gergo.addComments(com2);
        gergo.addWish(wish1);
        gergo.addWish(wish2);

        /*peter.addWish(wish3);
        peter.addComments(com3);
        repository.save(peter);*/
        repository.save(gergo);
    }

    @Test
    void test(){
        System.out.println();
    }

}