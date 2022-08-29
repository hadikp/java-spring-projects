package blog.entry;

import blog.comment.Comment;
import blog.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description; //summary

    private String content;

    @Column(name = "create_time")
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    public Entry(String title, String description, String content, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.createdAt = createdAt;
    }

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setEntry(this);
    }
}
