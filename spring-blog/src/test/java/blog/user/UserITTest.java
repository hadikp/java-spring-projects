package blog.user;

import blog.comment.Comment;
import blog.entry.Entry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository repository;

    @Test
    void testCreate(){
        Entry firstE = new Entry("First post", "Description of first post", "Body of first post"
                , LocalDateTime.of(2022, 02, 15, 10, 10, 15));
        Entry secondE = new Entry("Second post", "Description of second post", "Body of second post"
            , LocalDateTime.of(2022, 02, 16, 11, 11, 13, 11));
        Comment firstComment = new Comment("Péter", "First comment", LocalDate.of(2022, 03, 15));
        Comment secondComment = new Comment("János", "Second comment", LocalDate.of(2022, 03, 17));
        Comment thirdComment = new Comment("János", "Third comment", LocalDate.of(2022, 03, 18));
        User janos = new User("János", "pass123", "hadikp@freemail.hu", LocalDate.of(2022, 05, 16));
        User peter = new User("Péter", "pass", "nagy@freemail.hu", LocalDate.of(2022, 05, 18));

        firstE.addComment(firstComment);
        firstE.addComment(thirdComment);
        secondE.addComment(secondComment);

        janos.addEntry(firstE);
        peter.addEntry(secondE);

        repository.save(janos);
        repository.save(peter);
    }
}