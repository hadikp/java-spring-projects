package marketplace.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Product;
import marketplace.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
//    @JsonBackReference
    private User user;

    @ManyToOne
//    @JsonBackReference
    private Product product;

    public Comment(String content, LocalDate date) {
        this.content = content;
        this.createDate = date;
    }
}
