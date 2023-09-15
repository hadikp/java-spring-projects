package marketplace.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
    private int price;


    @JoinColumn(name = "user_id")
    private User user;

    public Product(String name, String description, String imagePath, int price) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
    }
}
