package marketplace.BookStore;

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
}
