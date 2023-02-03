package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.wish.Wish;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String name;
    private String city;
    private String userName;
    private String email;
    private String password;
    private Long role;
    private LocalDate registrationDate;
    private List<Wish> wishes = new ArrayList<>();
}
