package blog.entry;

import blog.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String body;

    @Column(name = "create_time")
    private LocalDateTime createdAt;

    @ManyToOne
    private User user;

    public Entry(String title, String description, String body, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.createdAt = createdAt;
    }
}
