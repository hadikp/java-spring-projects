package marketplace.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String email;
    private String password;
    private LocalDate registrationDate;


    @DBRef
    private List<Product> products = new ArrayList<>();

    public User(String name, String email, String password, LocalDate registrationDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void addProduct(Product product){
        products.add(product);
        product.setUser(this);
    }
}
