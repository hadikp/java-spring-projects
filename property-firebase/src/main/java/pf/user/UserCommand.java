package pf.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand {

    private String name;
    private String email;
    private String telephone;
    private String city;
    private String street;
    private int role;
}
