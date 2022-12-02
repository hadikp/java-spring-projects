package blog.entry;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntryDto {

    private String title;

    private String description;

    private String content;

    private LocalDateTime createdAt;
}
