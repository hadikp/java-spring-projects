package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    private String email;

    private String password;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public User(String name, String userName, String email, String password, LocalDate registrationDate) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
    }
}
