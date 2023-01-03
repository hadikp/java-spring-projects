package bluesight.swimlane;

import bluesight.board.Board;
import bluesight.col.Col;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "swimlanes")
public class Swimlane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int position;

    @Column(name = "wip_limit")
    private int wipLimit;

    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "swimlane", cascade = CascadeType.PERSIST)
    private List<Col> columns = new ArrayList<>();

    public Swimlane(String name, int position, int wipLimit) {
        this.name = name;
        this.position = position;
        this.wipLimit = wipLimit;
    }

    public void addColumns(Col col){
        columns.add(col);
        col.setSwimlane(this);
    }
}
