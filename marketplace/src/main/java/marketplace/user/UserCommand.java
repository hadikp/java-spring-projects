package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String name;
    private String userName;
    private String email;
    private String password;
    private Long role;
    private LocalDate registrationDate;
}
