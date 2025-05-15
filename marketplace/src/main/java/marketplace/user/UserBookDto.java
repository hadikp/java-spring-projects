package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.userbook.UserBookRelationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBookDto {

    private Long userId;
    private String userName;
    private Long bookId;
    private String bookTitle;
    private UserBookRelationType relationType;
}
