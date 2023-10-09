package pf.user;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create/{id}")
    public String createUser(@PathVariable("id") String id, @RequestBody UserCommand command) throws ExecutionException, InterruptedException {
        return service.createUser(id,command);
    }
}
