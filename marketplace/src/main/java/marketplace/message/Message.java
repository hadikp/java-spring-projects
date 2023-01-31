package marketplace.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String content;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    private User user;

    public Message(String subject, String content, LocalDate createDate) {
        this.subject = subject;
        this.content = content;
        this.createDate = createDate;
    }
}
