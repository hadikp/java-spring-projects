package blog.entry;

import lombok.Data;

@Data
public class EntryCommand {

    private String title;
    private String description;
    private String content;
}
