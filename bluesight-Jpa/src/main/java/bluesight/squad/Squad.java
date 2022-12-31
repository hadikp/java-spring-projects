package bluesight.squad;

import bluesight.board.Board;
import bluesight.project.Project;
import bluesight.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "squads")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @ManyToMany(mappedBy = "squads")
    private List<User> users = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    private Board board;

    @OneToMany(mappedBy = "squad", cascade = CascadeType.PERSIST)
    private List<Project> projects = new ArrayList<>();

    public Squad(String name, String description, LocalDate startDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
    }

    public void addProject(Project project){
        projects.add(project);
        project.setSquad(this);
    }

}
