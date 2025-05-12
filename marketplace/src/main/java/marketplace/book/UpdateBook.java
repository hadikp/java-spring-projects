package marketplace.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBook {

    private String author;
    private String title;
    private String subTitle;
    private String description;
    private String isbn;
    private String publication; //kiadás éve
    private Boolean approved; //default false
    private Boolean active;
    private String imagePath;
}
