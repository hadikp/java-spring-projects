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

    @Column(name = "product_name")
    private String productName;

    private String description;

    @Column(name = "image_path")
    private String imagePath;

    private int price;

    private Boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private Type productType;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Product(String name, String description, String imagePath, int price, Type productType) {
        this.productName = name;
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
