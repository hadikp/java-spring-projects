package marketplace.user;

import marketplace.comment.Comment;
import marketplace.book.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

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
        gergo = new User("Gergő", "kissg",  "kissg@gmail.com", "pass123", 1L, LocalDate.of(2022, 12, 23));

        book1 = new Book("Asimov", "könyv cime","subtitle", "Ez egy könyv", "1122","2022",  true, false, "src/images");
        book2 = new Book("Asimov", "könyv cime","subtitle", "Ez egy könyv", "1122","2022",  true, false, "src/images");
        Book book3 = new Book("Asimov", "könyv cime","subtitle", "Ez egy könyv", "1122","2022",  true, false, "src/images");



        gergo.addComment(book1, "ez a könyv");
        gergo.addComment(book2, "ez a könyv");
        peter.addComment(book3, "ez a könyv");




        repository.save(gergo);
        repository.save(peter);
    }

}