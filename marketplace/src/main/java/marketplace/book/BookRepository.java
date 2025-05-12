package marketplace.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    /*@Query("Select distinct p from Product p join fetch p.commentList c")
    List<Book> findAllProductWithComments();*/

}
