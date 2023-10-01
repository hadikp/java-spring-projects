package p.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> getAllUser(){
        return service.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable("id") String id){
        return service.findUserById(id);
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto command){
        return service.createUser(command);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id){
        service.deleteUser(id);
    }
}
