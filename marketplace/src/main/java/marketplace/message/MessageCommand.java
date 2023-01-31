package marketplace.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageCommand {

    private String subject;
    private String content;
    private LocalDate createDate;
}
