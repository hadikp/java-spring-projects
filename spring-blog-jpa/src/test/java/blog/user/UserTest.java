package blog.user;

import blog.comment.Comment;
import blog.entry.Entry;
import blog.image.ImageData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserTest {

    @Autowired
    UserRepository repository;

    @Test
    void create(){
        User csaba = new User("Csaba", "kcsaba@freemail.hu", "pass", LocalDate.of(2024, Month.APRIL, 25));
        User janos = new User("János", "bjani@freemail.hu", "pass123", LocalDate.of(2024, Month.AUGUST, 11));
        Entry firstEntry = new Entry("First post", "Description of first post", "Body of first post", LocalDate.of(2024, 11, 12));
        Entry secondEntry = new Entry("Second post", "Description of second post", "Body of second post", LocalDate.of(2024, 11, 12));
        Entry thirdEntry = new Entry("Third post", "Description of third post", "Body of third post", LocalDate.of(2024, 12, 12));
        Comment firstComment = new Comment("Csaba", "First comment", LocalDate.of(2024, 05, 22));
        Comment secondComment = new Comment("János", "Second comment", LocalDate.of(2024, 05, 28));
        Comment thirdComment = new Comment("János", "Third comment", LocalDate.of(2024, 05, 29));
        ImageData firstImage = new ImageData("Olimpia", "jpg");
        ImageData secondImage = new ImageData("Peru", "tiff");
        ImageData thirdImage = new ImageData("Liliom", "jpg");

        firstEntry.addComment(firstComment);
        firstEntry.addImage(firstImage);
        secondEntry.addComment(secondComment);
        secondEntry.addComment(thirdComment);
        secondEntry.addImage(secondImage);
        secondEntry.addImage(thirdImage);

        csaba.addEntries(firstEntry);
        janos.addEntries(secondEntry);
        janos.addEntries(thirdEntry);

        repository.save(csaba);
        repository.save(janos);
    }


}