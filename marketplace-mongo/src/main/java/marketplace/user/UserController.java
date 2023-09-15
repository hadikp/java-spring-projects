package marketplace.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> getAllUser(){
        return service.getAllUser();
    }
}
