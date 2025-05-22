package marketplace.book;

import lombok.AllArgsConstructor;
import marketplace.user.UserDto;
import marketplace.userbook.UserBookRelationType;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BookService {

    private static final String UPLOAD_DIR = "uploads/";
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

    public List<UserDto> getUsersWhoOfferedBook(Long bookId) {
        Book book = repository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
        return book.getUserRelations().stream()
                .filter(rel -> rel.getRelationType() == UserBookRelationType.OFFERED)
                .map(rel -> modelMapper.map(rel.getUser(), UserDto.class))
                .collect(Collectors.toList());
    }

    public ResponseEntity<String> uploadImage(MultipartFile file, Long bookId) {
        Book book = repository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));

        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("A fájl üres.");
            }

            // Fájl mentési útvonal
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path uploadPath = Paths.get(UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(filename);
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }

            // Útvonal mentése a könyvhöz
            book.setImagePath(filename);
            repository.save(book);

            return ResponseEntity.ok("Sikeres feltöltés: " + filename);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Hiba a feltöltés során: " + e.getMessage());
        }
    }
}
