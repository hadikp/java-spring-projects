package login.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @Column(name = "user_name")
    private String username;
    private String email;
    private String password;
    private String role;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
}
