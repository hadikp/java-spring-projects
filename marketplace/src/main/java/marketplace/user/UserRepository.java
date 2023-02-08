package marketplace.user;

import marketplace.product.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "Select u from User u join fetch u.products where u.id = :id")
    User findProductThisUser(Long id);

    @Query(value = "Select u from User u join fetch u.wishes where u.id = :id")
    User findWishThisUser(Long id);
}
