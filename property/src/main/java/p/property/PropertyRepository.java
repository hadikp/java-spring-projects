package p.property;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PropertyRepository extends MongoRepository<Property, String> {

    @Query("{category : ?0}")
    List<Property> findByCategory(String category);

    @Query("{$and:[{city:?0},{street:?1},{houseNumber:?2}]}")
    Property existByCityAndStreetAndHouseNumber(String city, String street, int houseNumber);

    @Query("{endDate : {$lt:?0}}")
    Property nowBeforeEndDate(LocalDate currentDate);
}
