package marketplace.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{$and:[{name:?0},{email:?1}]}")
    User existByNameAndEmail(String name, String email);
    Optional<User> findByUserName(String username);
    Boolean existByUsername(String username);
    Boolean existByEmail(String email);

}
