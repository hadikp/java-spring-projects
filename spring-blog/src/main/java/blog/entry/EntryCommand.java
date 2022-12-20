package blog.entry;

import lombok.Data;

@Data
public class EntryCommand {

    private Long userId;
    private String title;
    private String description;
    private String content;
}
