package blog.entry;

import blog.comment.Comment;
import blog.image.ImageData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EntryTest {

    @Autowired
    EntryRepository repository;

    @Test
    void create(){
        Comment comment = new Comment("peter", "First comment", LocalDate.of(2024, Month.APRIL, 23));
        ImageData imageData = new ImageData("First image", "jpg");
        Entry entry = new Entry("First post", "Description of first post", "Body of first post",
                LocalDate.of(2024, 05, 12));

        entry.addComment(comment);
        entry.addImage(imageData);
        repository.save(entry);
    }

}