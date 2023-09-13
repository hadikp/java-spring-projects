package marketplace.BookStore;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class BookNotFoundException extends AbstractThrowableProblem {
    public BookNotFoundException(String id) {
        super(
                URI.create("book/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Book not found %s", id)
        );
    }
}
