package p.property;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PropertyRepository extends MongoRepository<Property, String> {

    @Query("{category : ?0}")
    List<Property> findByCategory(String category);
}
