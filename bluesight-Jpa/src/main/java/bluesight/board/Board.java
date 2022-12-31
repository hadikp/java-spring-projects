package bluesight.board;


import bluesight.squad.Squad;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Board(String name, int position) {
        this.name = name;
        this.positionNumber = position;
    }
}
