package bluesight.project;

import bluesight.squad.Squad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String status;
    private String description;

    @Column(name = "closed_at")
    private LocalDate closedAt;

    @Column(name = "due_date")
    private LocalDate dueDate;

    public Project(String name, String status, String description, LocalDate closedAt, LocalDate dueDate) {
        this.name = name;
        this.status = status;
        this.description = description;
        this.closedAt = closedAt;
        this.dueDate = dueDate;
    }

    @ManyToOne
    private Squad squad;


}
