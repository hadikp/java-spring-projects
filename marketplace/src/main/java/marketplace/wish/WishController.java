package marketplace.wish;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
