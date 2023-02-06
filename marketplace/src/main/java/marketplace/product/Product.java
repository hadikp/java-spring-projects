package marketplace.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private Type productType;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Boolean active;

    @Column(name = "image_path")
    private String imagePath;

    private int price;

    public Product(String productName, String description, Type productType, Category category, Boolean active, String imagePath, int price) {
        this.productName = productName;
        this.description = description;
        this.productType = productType;
        this.category = category;
        this.active = active;
        this.imagePath = imagePath;
        this.price = price;
    }

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment){
        commentList.add(comment);
        comment.setProduct(this);
    }
}
