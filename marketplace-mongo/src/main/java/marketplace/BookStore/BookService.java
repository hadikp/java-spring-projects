package marketplace.BookStore;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {


    private BookRepository repository;
    private ModelMapper modelMapper;

    public List<BookDto> getAllBook() {
        List<Book> bookList = repository.findAll();
        return bookList.stream().map(b -> modelMapper.map(b, BookDto.class)).collect(Collectors.toList());
    }

    public BookDto createBook(BookDto command) {
        Book book = new Book(command.getBookName(), command.getAuthorName());
        repository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    public String deleteBook(String id) {
        repository.deleteById(id);
        return "Succesfully deleted";
    }

    public BookDto updateBook(String id, BookDto command) {
        Book findBook = repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        findBook.setBookName(command.getBookName());
        findBook.setAuthorName(command.getAuthorName());
        return modelMapper.map(findBook, BookDto.class);
    }

    public BookDto getOneBook(String id) {
        Book findBook = repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return modelMapper.map(findBook, BookDto.class);
    }
}
