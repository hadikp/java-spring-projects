package cinema.actors;

import cinema.movies.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @Embedded
    private Address address;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movieList = new ArrayList<>();

    public Actor(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
