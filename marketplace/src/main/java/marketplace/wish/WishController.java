package marketplace.wish;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wish")
@Tag(name = "Operation for the wish")
public class WishController {

    private WishService service;

    public WishController(WishService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "List all wish")
    public List<WishDto> listAllWish(){
        return service.listAllWish();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find wish by id")
    public WishDto findWishById(@PathVariable("id") Long id){
        return service.findWishById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a wish")
    @ApiResponse(responseCode = "201", description = "Wish has been created")
    public WishDto createWish(@RequestBody WishCommand command){
        return service.createWish(command);
    }
}
