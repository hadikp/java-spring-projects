package marketplace.message;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import marketplace.comment.UpdateComment;
import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    private MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "List all message")
    public List<MessageDto> listAllMessage(){
        return service.listAllMessage();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find message by id")
    public MessageDto findMessageById(@PathVariable("id") Long id){
        return service.findMessageById(id);
    }

    /*@PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Message has been created")
    public MessageDto createMessage(@RequestBody MessageCommand command){
        return service.createMessage(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Message update")
    public MessageDto updateMessage(@PathVariable("id") Long id, @RequestBody UpdateMessage command){
        return service.updateMessage(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Message delete")
    @ApiResponse(responseCode = "204", description = "Message has been deleted")
    public void deleteMessage(@PathVariable("id") Long id){
        service.deleteMessage(id);
    }*/
}
