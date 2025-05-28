package marketplace.book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import marketplace.user.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@Tag(name = "Operations the Books")
public class BookController {

    private BookService service;



    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Books")
    public List<BookDto> listAllBooks(){
        return service.listAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by id")
    public BookDto findBookById(@PathVariable("id") Long id){
        return service.findBookById(id);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Book has been created")
    public ResponseEntity<BookDto> createBook(@ModelAttribute BookCommand command){
        return service.createBook(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the Book")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Long id, @ModelAttribute BookCommand command){
        return service.updateBook(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Book")
    @ApiResponse(responseCode = "204", description = "Book has been deleted")
    public void deleteBook(@PathVariable("id") Long id){
        service.deleteBook(id);
    }

    @GetMapping("/{bookId}/offeredBy") //adott Book-nál melyik User van Offer kapcsolatban vele
    public List<UserDto> getUsersWhoOfferedBook(@PathVariable("bookId") Long bookId){
        return service.getUsersWhoOfferedBook(bookId);
    }

    @PostMapping("/upload") //külön végpont file feltöltésre
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("bookId") Long bookId){
        return service.uploadImage(file, bookId);
    }

}
