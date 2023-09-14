package marketplace.product;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.user.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private String imagePath;
    private int price;

    @ManyToOne()
    private User user;

    public Product(String name, String description, String imagePath, int price) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
    }
}
