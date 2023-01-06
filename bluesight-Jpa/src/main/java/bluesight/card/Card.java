package bluesight.card;

import bluesight.col.Col;
import bluesight.swimlane.Swimlane;
import bluesight.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private int priority;
    private int status;

    @Column(name = "position_number")
    private int position_number;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "opened_at")
    private LocalDate openedAt;

    @Column(name = "closed_at")
    private LocalDate closedAt;

    @Column(name = "due_at")
    private LocalDate dueAt;

    @ManyToOne
    private Col col;

    @ManyToOne
    private User user;

    @ManyToOne
    private Swimlane swimlane;

    public Card(String title, String description, int priority, int status, int position, LocalDate createDate, LocalDate openedAt, LocalDate closedAt, LocalDate dueAt) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.position_number = position;
        this.createDate = createDate;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.dueAt = dueAt;
    }
}
