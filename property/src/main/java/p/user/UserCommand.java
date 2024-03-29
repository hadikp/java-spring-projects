package p.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import p.property.Property;

import java.util.List;

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
    private List<Property> properties;
}
