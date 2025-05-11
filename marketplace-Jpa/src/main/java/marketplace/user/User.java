package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.comment.Comment;
import marketplace.message.Message;
import marketplace.book.Book;
import marketplace.wish.Wish;

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

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public User(String name, String userName, List<String> cities, String email, String password, LocalDate registrationDate) {
        this.name = name;
        this.userName = userName;
        this.cities = cities;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_product", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Book> books = new ArrayList<>(); //saját, felkínált könyvek, szerzett könyvek

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Message> messages = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_wish", joinColumns = @JoinColumn(name = "user_id"),
     inverseJoinColumns = @JoinColumn(name = "wish_id"))
    private List<Wish> wishes = new ArrayList<>(); //könyvek listája


    public void addBook(Book book){
        books.add(book);
        book.getUsers().add(this);
    }

    public void addComments(Comment comment){
        comments.add(comment);
        comment.setUser(this);
    }

    public void addMessages(Message message){
        messages.add(message);
        message.setUser(this);
    }

    public void addWish(Wish wish){
        wishes.add(wish);
        wish.getUsers().add(this);
    }
}
