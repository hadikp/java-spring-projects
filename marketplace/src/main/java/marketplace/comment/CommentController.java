package marketplace.comment;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@Tag(name = "Operations the Comments")
public class CommentController {

    private CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all comment")
    public List<CommentDto> listAllComment(){
        return service.listAllComment();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a comment by id")
    public CommentDto findCommentById(@PathVariable("id") Long id){
        return service.findCommentById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a comment")
    @ApiResponse(responseCode = "201", description = "Comment has been created")
    public CommentDto createComment(@RequestBody CommentCommand command){
        return service.createComment(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the Comment")
    public CommentDto updateCommand(@PathVariable("id") Long id, @RequestBody UpdateComment command){
        return service.updateComment(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete the Comment")
    @ApiResponse(responseCode = "204", description = "Comment has been deleted")
    public void deleteComment(@PathVariable("id") Long id){
        service.deleteComment(id);
    }
}
