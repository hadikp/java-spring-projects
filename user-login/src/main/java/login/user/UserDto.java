package login.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    private String username;
    private String email;
    private String password;
    private String role;
    private Boolean authenticate;
    private LocalDate registrationDate;
}
