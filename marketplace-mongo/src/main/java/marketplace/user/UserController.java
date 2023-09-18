package marketplace.user;

import marketplace.product.ProductDto;
import org.springframework.web.bind.annotation.*;

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

   /* @PutMapping("/product/price")
    public UserProductPriceDto addUsersProductPrice(@RequestBody UserProductPriceDto command){
        return service.addUsersProductPrice(command);
    }*/


}
