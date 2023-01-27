package marketplace.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("Select distinct p from Product p join fetch p.commentList c")
    List<Product> findAllProductWithComments();

    @Query("Select p from Product p where p.category = :category")
    List<Product> findPoductByCategory(Category category);

    @Query("Select p from Product p where p.productType = :type")
    List<Product> findProductByType(Type type);
}
