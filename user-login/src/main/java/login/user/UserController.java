package login.user;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto>  login(){
        return userService.listUsers();
    }
    @PostMapping("/login")
    public UserDto login(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
       return userService.login(loginRequest, response);
    }

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserCommand command){
        return userService.registerUser(command);
    }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
