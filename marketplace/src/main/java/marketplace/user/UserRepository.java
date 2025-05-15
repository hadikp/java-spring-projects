package marketplace.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {


    /*@Query(value = "Select u from User u join fetch u.book where u.id = :id")
    User findBookThisUser(Long id);

    @Query(value = "Select u from User u join fetch u.wishes where u.id = :id")
    User findWishThisUser(Long id);*/
}
