package blog.entry;

import blog.comment.Comment;
import blog.image.ImageData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate createdAt;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "entry", cascade = CascadeType.PERSIST)
    private List<ImageData> images = new ArrayList<>();

    public Entry(String title, String description, String content, LocalDate createdAt) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.createdAt = createdAt;
    }

    public void addComment (Comment comment){
        comments.add(comment);
        comment.setEntry(this);
    }

    public void addImage (ImageData imageData){
        images.add(imageData);
        imageData.setEntry(this);
    }

}
