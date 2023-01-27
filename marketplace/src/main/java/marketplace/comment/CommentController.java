package marketplace.comment;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<CommentDto> listAllComment(){
        return service.listAllComment();
    }

    @GetMapping("/{id}")
    public CommentDto findCommentById(@PathVariable("id") Long id){
        return service.findCommentById(id);
    }
}
