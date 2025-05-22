package marketplace.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCommand {

    private String author;
    private String title;
    private String subTitle;
    private String description;
    private String isbn;
    private String publication; //kiadás éve
    private Boolean approved; //default false
    private Boolean active;
    private String imagePath;
    private MultipartFile image;



}
