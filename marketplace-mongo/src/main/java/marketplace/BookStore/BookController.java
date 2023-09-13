package marketplace.BookStore;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookDto> getAllBook(){
        return service.getAllBook();
    }

    @GetMapping("/{id}")
    public BookDto getOneBook(@PathVariable("id") String id){
        return service.getOneBook(id);
    }

    @PostMapping("/create")
    public BookDto createBook(@RequestBody BookDto command){
        return service.createBook(command);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable("id") String id, BookDto command){
        return service.updateBook(id, command);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") String id){
       return service.deleteBook(id);
    }
}
