package cinema.movies;

import cinema.actors.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime date;

    @Column(name = "max_space")
    private int maxSpace;
    @Column(name = "free_spaces")
    private int freeSpaces;

  
    @JoinTable(joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors = new ArrayList<>();

    public Movie(String title, LocalDateTime date, int maxSpace) {
        this.title = title;
        this.date = date;
        this.maxSpace = maxSpace;
    }

    public void addActors(Actor actor){
        actors.add(actor);
        actor.getMovieList().add(this);
    }

    public void reservation(int reserve){
        if(reserve >= freeSpaces){
            freeSpaces -= reserve;
        } else {
            throw new IllegalStateException("Not enough free place!");
        }
    }
}
