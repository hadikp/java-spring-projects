package marketplace.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    private Long id;
    private String subject;
    private String content;
    private LocalDate createDate;
    private Long userId;
}
