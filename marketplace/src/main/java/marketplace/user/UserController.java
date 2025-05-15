package marketplace.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketplace.userbook.UserBookRelationType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Operations the User")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> listAllUser(){
        return service.listAllUser();
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable("id") Long id){
        return service.findUserById(id);
    }

    @GetMapping("/get-fire")
    public List<FireStoreDto> firebaseData() throws ExecutionException, InterruptedException {
        return service.firebaseDatas();
    }

    @PostMapping("/create-fire")
    public String createFirestore(@RequestBody FireStoreDto fireStoreDto) throws ExecutionException, InterruptedException {
        return service.createFirestore(fireStoreDto);
    }

    @DeleteMapping("/del-fire/{docId}")
    public String deleteFirestore(@PathVariable("docId") String documentId){
       return service.deleteFirestore(documentId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a user")
    @ApiResponse(responseCode = "201", description = "User has been created")
    public UserDto createUser(@RequestBody UserCommand command){
        return service.createUser(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the user")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UpdateUser command){
        return service.updateUser(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a user")
    @ApiResponse(responseCode = "204", description = "User has been deleted")
    public void deleteUser(@PathVariable("id") Long id){
        service.deleteUser(id);
    }

    /*@PostMapping("/{userId}/wish/{wishId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add an existing wish to an existing user")
    @ApiResponse(responseCode = "201", description = "Old wish has been added to the user")
    public UserProductDto userAddOldWish(@PathVariable("userId") Long userId, @PathVariable("wishId") Long wishId){
        return service.userAddExistingWish(userId, wishId);
    }*/

    @PostMapping("/{userId}/book/{bookId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add an existing book to an existing user")
    @ApiResponse(responseCode = "201", description = "Old book has been added to the user")
    public UserBookDto addExistingBookToUser(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId, @RequestParam("relationType") UserBookRelationType relationType) {
        return service.addExistingBookToUser(userId, bookId, relationType);
    }
}
