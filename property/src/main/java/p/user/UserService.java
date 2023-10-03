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
        User existUser = repository.existByNameAndEmail(command.getName(), command.getEmail());

        UserDto newUserDto = null;
        if(existUser == null){
            User user = new User(command.getName(), command.getEmail(), command.getTelephone(), command.getCity(), command.getStreet(), command.getRole());
            repository.save(user);
            newUserDto = modelMapper.map(user, UserDto.class);
        } else {
            throw new UserAlreadyExistException(command.getName());
        }

        return newUserDto;
    }

    public void deleteUser(String id) {
        User findUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        repository.delete(findUser);
    }
}
