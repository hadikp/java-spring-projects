package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Product;
import marketplace.role.Role;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private LocalDateTime registrationDate;

   @DocumentReference(lazy = true)
    private List<Product> products = new ArrayList<>();

   private Set<Role> roles = new HashSet<>();


    public User(String name, String email, String address, String password, LocalDateTime registrationDate) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void addProduct(Product product){
        products.add(product);
        product.getUsers().add(this);
    }

    /*public void addRole(Role role){
        roles.add(role);
        role.
    }*/
}
