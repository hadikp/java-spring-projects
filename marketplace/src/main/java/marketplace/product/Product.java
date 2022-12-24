package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "image_path")
    private String imagePath;

    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private Type productType;

    public Product(String name, String description, String imagePath, int price, Type productType) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.price = price;
        this.productType = productType;
    }

    @ManyToMany(mappedBy = "products")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment){
        commentList.add(comment);
        comment.setProduct(this);
    }
}
