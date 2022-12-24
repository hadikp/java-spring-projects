package marketplace.product;

import marketplace.comment.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductITTest {

    @Autowired
    ProductRepository repository;

    @Test
    void testCreate(){
        Product product = new Product("könyv", "Ez egy könyv", "src/images/", 1100, Type.BOOK);
        Comment com1 = new Comment("com1 content", LocalDate.of(2022, 12, 01));
        product.addComment(com1);
        repository.save(product);
    }

}