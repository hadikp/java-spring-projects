package login.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private UserRepository repository;
    private ModelMapper modelMapper;


    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserDto registerUser(UserCommand command){
        if(command.getPassword().equals(command.getPasswordConfirm())){
            User newUser = new User(command.getUsername(), command.getEmail(), command.getRole(), LocalDate.now());
            newUser.setPassword(new BCryptPasswordEncoder().encode(command.getPassword()));
            repository.save(newUser);
            return modelMapper.map(newUser, UserDto.class);
        } else {
            throw new ExceptionPasswordNotMatch();
        }

    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public UserDto login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        User user = repository.findUserByUsername(username).orElseThrow(() -> new ExceptionUserNotFound(username));
        if(!new BCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword())){
            throw new ExceptionPasswordNotMatch();
        } else {
            return modelMapper.map(user, UserDto.class);
        }
    }

    public List<UserDto> listUsers() {
        List<User> users = repository.findAll();
        return  users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }
}
