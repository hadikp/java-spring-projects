package marketplace.book;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class BookNotFoundException extends AbstractThrowableProblem {
    public BookNotFoundException(Long id) {
        super(
                URI.create("product/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Product not found %d", id)
        );
    }
}
