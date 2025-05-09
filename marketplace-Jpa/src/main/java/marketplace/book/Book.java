package marketplace.book;

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
@Embeddable
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String title;

    private String subTitle;

    private String description;

    private String isbn;

    private String publication; //kiadás éve

    private Boolean approved; //default false

    private Boolean active; //ha user felajánlja akkor true; default false

    @Column(name = "image_path")
    private String imagePath;

    @ManyToMany(mappedBy = "books")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<Comment> commentList = new ArrayList<>();


    public void addComment(Comment comment) {
        commentList.add(comment);
        comment.setBook(this);
    }
}
