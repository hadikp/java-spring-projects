package pf.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> getAllUsers() throws ExecutionException, InterruptedException {
        return service.getAllUsers();
    }

    @PostMapping("/create/{id}")
    public String createUser(@PathVariable("id") String id, @RequestBody UserCommand command) throws ExecutionException, InterruptedException {
        return service.createUser(id,command);
    }

    /*@PutMapping("id")
    public UserDto updateUser(@PathVariable("id") String id, @RequestBody UserCommand command){
        return service.updateUser(id, command);
    }*/

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") String id){
        return service.deleteUser(id);
    }
}
