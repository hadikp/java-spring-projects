package login.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String username;
    private String email;
    private String password;
    private String passwordConfirm;
    private String role;
}
