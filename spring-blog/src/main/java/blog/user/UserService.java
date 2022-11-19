package blog.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private ModelMapper modelMapper;


    public List<UserDto> listAllUser() {
        List<User> users = repository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }


    public UserDto createUser(UserCommand command) {
        User user = new User(command.getEmail(), command.getPassword());
        user.setRegistrationDate(LocalDate.now());
        user.setUserName("Péter");
        repository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto findUserByEmail(UserCommand command) {
        User user = repository.findUserByEmail(command.getEmail());
        return modelMapper.map(user, UserDto.class);
    }
}
