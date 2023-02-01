package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.message.Message;
import marketplace.product.Product;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String password;

   

    private Long role; //1, 2, 3

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Comment> userComments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Message> messages = new ArrayList<>();



    public void addProduct(Product product){
        products.add(product);
        product.getUsers().add(this);
    }

    public void addComment(Comment comment){
        userComments.add(comment);
        comment.setUser(this);
    }

    public void addMessages(Message message){
        messages.add(message);
        message.setUser(this);
    }


}
