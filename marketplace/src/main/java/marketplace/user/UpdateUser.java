package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUser {

    private String name;
    private String userName;
    private String email;
    private String password;
    private LocalDate registrationDate;
}
