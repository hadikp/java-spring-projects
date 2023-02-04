package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.message.Message;
import marketplace.product.Product;
import marketplace.wish.Wish;

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

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String password;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Message> messages = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_wish", joinColumns = @JoinColumn(name = "user_id"),
     inverseJoinColumns = @JoinColumn(name = "wish_id"))
    private List<Wish> wishes = new ArrayList<>();

    public User(String name, String userName, String email, String password, LocalDate registrationDate) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    public void addProduct(Product product){
        products.add(product);
        product.getUsers().add(this);
    }

    public void addComments(Comment comment){
        comments.add(comment);
        comment.setUser(this);
    }

    public void addMessages(Message message){
        messages.add(message);
        message.setUser(this);
    }

    public void addWish(Wish wish){
        wishes.add(wish);
        wish.getUsers().add(this);
    }



}
