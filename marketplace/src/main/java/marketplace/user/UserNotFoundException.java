package marketplace.user;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class UserNotFoundException extends AbstractThrowableProblem {
    public UserNotFoundException(Long id) {
        super(
                URI.create("user/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("User not found %d", id)
        );
    }
}
