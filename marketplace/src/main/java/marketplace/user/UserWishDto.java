package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.wish.WishDto;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWishDto {

    private Long id;
    private String name;
    private String city;
    private String userName;
    private String email;
    private String password;
    private Long role;
    private LocalDate registrationDate;

    private List<WishDto> wishes;
}
