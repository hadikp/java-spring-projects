package bluesight.col;

import bluesight.card.Card;
import bluesight.swimlane.Swimlane;
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
@Table(name = "columns")
public class Col {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "position_number")
    private int position_number;

    @Column(name = "wip_limit")
    private int wip_limit;

    @Column(name = "card_count")
    private int cardCount;

    public Col(String name, int position, int wip_limit, int cardCount) {
        this.name = name;
        this.position_number = position;
        this.wip_limit = wip_limit;
        this.cardCount = cardCount;
    }

    @ManyToMany(mappedBy = "columns")
    private List<Swimlane> swimlanes = new ArrayList<>();

    @OneToMany(mappedBy = "col", cascade = CascadeType.PERSIST)
    private List<Card> cards = new ArrayList<>();

    public void addNewCard(Card card){
        cards.add(card);
        card.setCol(this);
    }

    public void deleteCard(Card card){
        cards.remove(card);
    }
}
