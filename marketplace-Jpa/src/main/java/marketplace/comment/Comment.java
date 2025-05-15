package marketplace.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.book.Book;
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

    private LocalDate date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public Comment(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }

}
