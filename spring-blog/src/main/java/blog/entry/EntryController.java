package blog.entry;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class EntryController {

    private EntryService service;

    public EntryController(EntryService service) {
        this.service = service;
    }

    @GetMapping
    public List<EntryDto> listAllPost(){
        return service.listAllPost();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Post has been created")
    public EntryDto createPost(@RequestBody EntryCommand command){
        return service.createPost(command);
    }

    @PutMapping("/{id}")
    public EntryDto updateEntry(@PathVariable("id") Long id, @RequestBody EntryCommand command){
        return service.updateEntry(id, command);
    }
}
