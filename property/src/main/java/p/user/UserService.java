package p.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    private ModelMapper modelMapper;

    public List<UserDto> getAllUser() {
        List<User> users = repository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto findUserById(String id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto createUser(UserDto command) {
        User user = new User(command.getName(), command.getEmail(), command.getTelephone(), command.getCity(), command.getStreet(), command.getRole());
        repository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public void deleteUser(String id) {
        User findUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        repository.delete(findUser);
    }
}
