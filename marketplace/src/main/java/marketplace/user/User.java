package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.message.Message;
import marketplace.book.Book;
import marketplace.userbook.UserBook;
import marketplace.userbook.UserBookRelationType;

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

    @ElementCollection
    @CollectionTable(name = "user_cities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "city")
    private List<String>  cities = new ArrayList<>();

    private String email;

    private String password;

    private Long role; //1, 2, 3

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public User(String name, String userName, String email, String password, Long role, LocalDate registrationDate) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.registrationDate = registrationDate;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Message> messages = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<UserBook> bookRelations = new ArrayList<>();


   /* public void addComments(Book book, String content){
        Comment comment = new Comment(content, LocalDate.now(), this);
        comments.add(comment);
        book.getCommentList().add(comment);
    }*/

    public void addMessages(Message message){
        messages.add(message);
        message.setUser(this);
    }

    public void addBook(Book book, UserBookRelationType relationType){
        UserBook userBook = new UserBook(this, book, relationType);
        bookRelations.add(userBook);
        book.getUserRelations().add(userBook);
    }

    public void removeBook(Book book, UserBookRelationType relationType) {
        bookRelations.removeIf(ub -> ub.getBook().equals(book) && ub.getRelationType() == relationType);
        book.getUserRelations().removeIf(ub -> ub.getUser().equals(this) && ub.getRelationType() == relationType);
    }


}
