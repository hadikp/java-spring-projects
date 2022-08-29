package blog.user;

import blog.entry.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "user_name")
    private String userName;

    private String password;
    private String email;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<Entry> entries = new ArrayList<>();

    public User(String userName, String password, String email, LocalDate registrationDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public void addEntry(Entry entry){
        entries.add(entry);
        entry.setUser(this);
    }
}
