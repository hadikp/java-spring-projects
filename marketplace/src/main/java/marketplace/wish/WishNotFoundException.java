package marketplace.wish;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class WishNotFoundException extends AbstractThrowableProblem {
    public WishNotFoundException(Long id) {
        super(
                URI.create("wish/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Wish not found %d", id)
        );
    }
}
