package bluesight.col;

import bluesight.swimlane.Swimlane;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "columns")
public class Col {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int position;

    @Column(name = "wip_limit")
    private int wip_limit;

    @Column(name = "card_count")
    private int cardCount;

    public Col(String name, int position, int wip_limit, int cardCount) {
        this.name = name;
        this.position = position;
        this.wip_limit = wip_limit;
        this.cardCount = cardCount;
    }

    @ManyToOne
    private Swimlane swimlane;
}
