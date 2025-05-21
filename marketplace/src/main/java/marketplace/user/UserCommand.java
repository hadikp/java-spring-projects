package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String name;
    private String userName;
    private List<String> cities;
    private String email;
    private String password;
    private Long role;
    private LocalDate registrationDate;
}
