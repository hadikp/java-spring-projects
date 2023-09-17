package marketplace.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.price.Price;
import marketplace.user.User;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
    @DocumentReference(lazy = true, lookup = "{products : ?#{#self._id} }")
    @ReadOnlyProperty
    private List<User> users = new ArrayList<>();

    private int price;


    public Product(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }


}
