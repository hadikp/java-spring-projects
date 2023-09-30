package marketplace.user;

import lombok.AllArgsConstructor;
import marketplace.product.Product;
import marketplace.product.ProductNotFoundException;
import marketplace.product.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public UserDto createUser(UserDto command) {
        User userExist = userRepository.existByNameAndEmail(command.getName(), command.getEmail());
        System.out.println(userExist);

        UserDto newUserDto = null;
        if(userExist==null){
            User newUser = new User(command.getName(), command.getEmail(), command.getAddress(), command.getPassword(), LocalDateTime.now());
            userRepository.save(newUser);
            newUserDto = modelMapper.map(newUser, UserDto.class);
        } else {
            throw new UserAlreadyExistException(command.getName());
        }
        return newUserDto;
    }


}
