package marketplace.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.user.User;
import marketplace.userbook.UserBook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    private Boolean active;

    @Column(name = "image_path")
    private String imagePath;

    public Book(String author, String title, String subTitle, String description, String isbn, String publication, Boolean approved, Boolean active, String imagePath) {
        this.author = author;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.isbn = isbn;
        this.publication = publication;
        this.approved = approved;
        this.active = active;
        this.imagePath = imagePath;
    }

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<UserBook> userRelations = new ArrayList<>();
}
