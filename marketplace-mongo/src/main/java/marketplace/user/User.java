package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.price.Price;
import marketplace.product.Product;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String email;

    private String address;
    private String password;
    private LocalDate registrationDate;

   @DocumentReference(lazy = true)
    private Map<Integer, Product> products = new HashMap<>();


    public User(String name, String email, String address, String password, LocalDate registrationDate) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void addProduct(Product product){

        products.put(product.getPrice(), product);
        product.getUsers().add(this);
    }
}
