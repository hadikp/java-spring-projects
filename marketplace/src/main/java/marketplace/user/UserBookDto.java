package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.book.BookDto;
import marketplace.userbook.UserBookRelationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBookDto {

    private Long userId;
    private String userName;
    private BookDto book;
    private UserBookRelationType relationType;
}
