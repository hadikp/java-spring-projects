package marketplace.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public List<UserProductDto> listAllUser(){
        return service.listAllUser();
    }

    @GetMapping("/{id}")
    public UserProductDto findUserById(@PathVariable("id") Long id){
        return service.findUserById(id);
    }

    @GetMapping("/get-fire/{firestoreId}")
    public FireStoreDto firebaseData(@PathVariable("firestoreId") String documentId) throws ExecutionException, InterruptedException {
        return service.firebaseData(documentId);
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
    public UserProductDto createUser(@RequestBody UserCommand command){
        return service.createUser(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the user")
    public UserProductDto updateUser(@PathVariable("id") Long id, @RequestBody UpdateUser command){
        return service.updateUser(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a user")
    @ApiResponse(responseCode = "204", description = "User has been deleted")
    public void deleteUser(@PathVariable("id") Long id){
        service.deleteUser(id);
    }

    @PostMapping("/{id}/wish")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new wish to an existing user")
    @ApiResponse(responseCode = "201", description = "New wish has been added to the user")
    public UserProductDto userAddNewWish(@PathVariable("id") Long id, @RequestBody UserAddWishCommand command){
        return service.userAddWish(id, command);
    }

    @PostMapping("/{userId}/wish/{wishId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add an existing wish to an existing user")
    @ApiResponse(responseCode = "201", description = "Old wish has been added to the user")
    public UserProductDto userAddOldWish(@PathVariable("userId") Long userId, @PathVariable("wishId") Long wishId){
        return service.userAddExistingWish(userId, wishId);
    }

    @PostMapping("/{userId}/product/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add an existing product to an existing user")
    @ApiResponse(responseCode = "201", description = "Old product has been added to the user")
    public UserProductDto userAddExistingProduct(@PathVariable("userId") Long userId, @PathVariable("productId") Long productId) {
        return service.userAddExistingProduct(userId, productId);
    }
}
