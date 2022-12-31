package bluesight.user;

import bluesight.squad.Squad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

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

    private String email;
    private String password;
    private String country;
    private Boolean admin;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_squad", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "squad_id"))
    private List<Squad> squads = new ArrayList<>();

    public User(String name, String userName, String email, String password, String country, Boolean admin, LocalDate registrationDate) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.admin = admin;
        this.registrationDate = registrationDate;
    }

    public void addSquad(Squad squad){
        squads.add(squad);
        squad.getUsers().add(this);
    }
}
