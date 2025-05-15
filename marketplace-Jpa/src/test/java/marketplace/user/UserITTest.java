package marketplace.user;
import marketplace.comment.Comment;
import marketplace.book.Book;
import marketplace.book.BookRepository;
import marketplace.comment.CommentRepository;
import marketplace.message.Message;
import marketplace.userbook.UserBook;
import marketplace.userbook.UserBookRelationType;
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

    @Autowired
    CommentRepository commentRepository;

    User gergo;
    User peter;
    Book book1;
    Book book2;


    @BeforeEach
    void init(){
        book1 = new Book("író1", "Cím1", "sub1T", "Ez a demand1 könyv","1234","1999",false, false, "src/images");
        book2 = new Book("író2", "Cím2", "sub12", "Ez a demand2 könyv","1234","1998",false, false, "src/images");
        Book book3 = new Book("író3","Cím3", "sub1T", "Ez a demand3 könyv","1234","1997",false, false, "src/images");

        gergo = new User("Gergő", "kissg",List.of("Veszprém","Pápa"), "kissg@gmail.com", "pass123", 1, LocalDate.of(2022, 12, 25));
        peter = new User("Péter", "hadikp",List.of("Veszprém", "Pápa"), "hadikg@gmail.com", "p123", 2,  LocalDate.of(2022, 12, 26));
        UserBook userBook1 = new UserBook(gergo, book1);
        UserBook userBook2 = new UserBook(gergo, book1);
        UserBook userBook3 = new UserBook(gergo, book1);

        gergo.addComment(book1, "com1 content");
        gergo.addComment(book2, "com2 content");
        peter.addComment(book3, "com3 content");

        Message message1 = new Message("gabi@freemail.hu", "message1");
        Message message2 = new Message("jani@gmail.com", "message2");
        Message message3 = new Message("feri@gmail.com", "message3");

        gergo.addMessages(message1);
        peter.addMessages(message2);
        peter.addMessages(message3);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        gergo.addBook(book1, UserBookRelationType.OFFERED);
        gergo.addBook(book2, UserBookRelationType.ACQUIRED);
        peter.addBook(book3, UserBookRelationType.WISH);

        repository.save(peter);
        repository.save(gergo);
    }

    @Test
    void test(){
        System.out.println();
    }

}