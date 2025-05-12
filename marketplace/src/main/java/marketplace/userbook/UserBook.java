package marketplace.userbook;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.book.Book;
import marketplace.user.User;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user_book")
public class UserBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    @Enumerated(EnumType.STRING)
    private UserBookRelationType relationType;

    public UserBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public UserBook(User user, Book book, UserBookRelationType relationType) {
        this.user = user;
        this.book = book;
        this.relationType = relationType;
    }
}
