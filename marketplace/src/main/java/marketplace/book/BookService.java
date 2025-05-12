package marketplace.book;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private BookRepository repository;
    private ModelMapper modelMapper;
    public List<BookDto> listAllBooks() {
        List<Book> books = repository.findAll();
        return books.stream().map(p -> modelMapper.map(p, BookDto.class)).collect(Collectors.toList());
    }


    public BookDto createBook(BookCommand command) {
        Book book = new Book(command.getAuthor(), command.getTitle(), command.getSubTitle(), command.getDescription(),
                command.getIsbn(), command.getPublication(), command.getApproved(), command.getActive(), command.getImagePath());
        repository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public BookDto updateBook(Long id, UpdateBook command) {
        Book findBook = repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        findBook.setAuthor(command.getAuthor());
        findBook.setTitle(command.getTitle());
        findBook.setSubTitle(command.getSubTitle());
        findBook.setDescription(command.getDescription());
        findBook.setIsbn(command.getIsbn());
        findBook.setPublication(command.getPublication());
        findBook.setApproved(command.getApproved());
        findBook.setActive(command.getActive());
        findBook.setImagePath(command.getImagePath());
        return modelMapper.map(findBook, BookDto.class);
    }

    public BookDto findBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        return modelMapper.map(book, BookDto.class);
    }

}
