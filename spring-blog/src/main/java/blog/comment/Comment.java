package blog.comment;

import blog.entry.Entry;
import com.sun.jdi.request.MethodEntryRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String useName;

    private String text;

    private LocalDate date;

    @ManyToOne
    private Entry entry;

    public Comment(String useName, String text, LocalDate date) {
        this.useName = useName;
        this.text = text;
        this.date = date;
    }
}
