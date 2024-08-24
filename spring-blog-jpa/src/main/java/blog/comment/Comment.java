package blog.comment;

import blog.entry.Entry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "comment")
    private String commentContent;

    private LocalDate date;

    public Comment(String userName, String commentContent, LocalDate date) {
        this.userName = userName;
        this.commentContent = commentContent;
        this.date = date;
    }

    @ManyToOne
    private Entry entry;
}
