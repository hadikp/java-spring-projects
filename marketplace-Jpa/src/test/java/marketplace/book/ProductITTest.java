package marketplace.book;

import marketplace.comment.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductITTest {

    @Autowired
    BookRepository repository;

    @Test
    void testCreate(){
        Book book = new Book("könyv", "Ez egy könyv", "src/images/", 1100, Type.BOOK);
        Comment com1 = new Comment("com1 content", LocalDate.of(2022, 12, 01));
        book.addComment(com1);
        repository.save(book);
    }

}