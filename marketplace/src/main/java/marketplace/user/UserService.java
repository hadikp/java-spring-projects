package marketplace.user;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository repository;
    private ModelMapper modelMapper;

    public List<UserDto> listAllUser() {
        List<User> users = repository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto findUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto createUser(UserCommand command) {
        User user = new User(command.getName(), command.getUserName(), command.getEmail(), command.getPassword(), command.getRegistrationDate());
        repository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public UserDto updateUser(Long id, UpdateUser command) {
        User findUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        findUser.setName(command.getName());
        findUser.setUserName(command.getUserName());
        findUser.setEmail(command.getEmail());
        findUser.setPassword(command.getPassword());
        findUser.setRegistrationDate(command.getRegistrationDate());
        return modelMapper.map(findUser, UserDto.class);
    }
}
