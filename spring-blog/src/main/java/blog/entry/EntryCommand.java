package blog.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntryCommand {

    private Long userId;
    private String title;
    private String description;
    private String content;
}
