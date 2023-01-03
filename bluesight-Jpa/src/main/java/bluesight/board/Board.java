package bluesight.board;


import bluesight.squad.Squad;
import bluesight.swimlane.Swimlane;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "position_number")
    private int positionNumber;

    @OneToOne(mappedBy = "board")
    private Squad squad;

    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
    private List<Swimlane> swimlanes = new ArrayList<>();

    public Board(String name, int position) {
        this.name = name;
        this.positionNumber = position;
    }

    public void addSwimlane(Swimlane swimlane){
        swimlanes.add(swimlane);
        swimlane.setBoard(this);
    }
}
