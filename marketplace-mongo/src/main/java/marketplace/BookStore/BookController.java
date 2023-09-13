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

    @PostMapping("/create")
    public BookDto createBook(@RequestBody BookDto command){
        return service.createBook(command);
    }
}
