package blog.user;

import blog.entry.Entry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCommand {

    private String userName;

    private String email;

    private String password;

    private List<Entry> entries = new ArrayList<>();
}
