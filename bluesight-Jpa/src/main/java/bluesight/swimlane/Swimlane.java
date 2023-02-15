package bluesight.swimlane;

import bluesight.board.Board;
import bluesight.card.Card;
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
    private int position_number;

    @Column(name = "wip_limit")
    private int wipLimit;

    @ManyToOne
    private Board board;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "swimlane_column", joinColumns = @JoinColumn(name = "swimlane_id"),
        inverseJoinColumns = @JoinColumn(name = "column_id"))
    private List<Col> columns = new ArrayList<>();

    @OneToMany(mappedBy = "swimlane", cascade = CascadeType.PERSIST)
    private List<Card> cards = new ArrayList<>();

    public Swimlane(String name, int position, int wipLimit) {
        this.name = name;
        this.position_number = position;
        this.wipLimit = wipLimit;
    }

    public void addColumns(Col col){
        columns.add(col);
        col.getSwimlanes().add(this);
    }

    public void addCard(Card card){
        cards.add(card);
        card.setSwimlane(this);
    }
}
