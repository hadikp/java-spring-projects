package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private Type productType;

    @ManyToMany(mappedBy = "products")
    private List<User> users = new ArrayList<>();
}
