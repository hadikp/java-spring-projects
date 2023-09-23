package marketplace.price;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/det")
public class DetailsController {

    private DetailsService service;

    public DetailsController(DetailsService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetailsDto> getAllDetails(){
        return service.getAllDetails();
    }

    @GetMapping("/user/{userId}")
    public List<DetailsDto> getUserProductAllDetails(@PathVariable("userId") String userId){
        return service.getUserProductAllDetails(userId);
    }
}
