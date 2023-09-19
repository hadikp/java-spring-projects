package marketplace.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.price.Details;
import marketplace.user.User;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String description;
    private String imagePath;

    @JsonBackReference
    @DocumentReference(lazy = true, lookup = "{'products':?#{#self._id} }")
    @ReadOnlyProperty
    private List<User> users = new ArrayList<>();

    private List<Details> detailsList = new ArrayList<>();


    public Product(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public void addDetails(Details details){
        detailsList.add(details);
        details.setProduct(this);
    }


}
