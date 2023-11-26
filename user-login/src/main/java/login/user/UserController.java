package login.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping()
    public UserDto login(){
        return userService.listUsers();
    }*/

    @GetMapping(value = "/")
    public ModelAndView index(@AuthenticationPrincipal User user){
        return new ModelAndView("index", Map.of("users", userService.listUsers(), "user", new User()));
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
