package p.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{$and:[{name:?0},{email:?1}]}")
    User existByNameAndEmail(String name, String email);
}
