package login.user;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private static final String COOKIE_NAME = "user-dto";
    private static final int EXPIRATION = 30 * 60 * 1000;

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

    public UserDto login(LoginRequest loginRequest, HttpServletResponse response) {
        String username = loginRequest.getUsername();
        User user = repository.findUserByUsername(username).orElseThrow(() -> new ExceptionUserNotFound(username));
        if(!new BCryptPasswordEncoder().matches(loginRequest.getPassword(), user.getPassword())){
            throw new ExceptionPasswordNotMatch();
        } else {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            storeUserCookie(response, userDto);
            return userDto;
        }
    }

    private void storeUserCookie(HttpServletResponse response, UserDto userDto) {
        Cookie cookie = new Cookie(COOKIE_NAME, userDto.getUsername());
        cookie.setMaxAge(EXPIRATION);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public List<UserDto> listUsers() {
        List<User> users = repository.findAll();
        return  users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public LogoutResponse logout(HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return new LogoutResponse("User logout");
    }
}
