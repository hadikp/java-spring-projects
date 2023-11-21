package login.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping(value = "/")
    public ModelAndView index(@AuthenticationPrincipal User user){
        return new ModelAndView("index", Map.of("users", userService.listUsers(), "user", new User()));
    }
    @PostMapping(value = "/reg")
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }
}
