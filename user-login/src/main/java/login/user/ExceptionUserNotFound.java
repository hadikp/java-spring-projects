package login.user;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ExceptionUserNotFound extends AbstractThrowableProblem {

    public ExceptionUserNotFound(String username) {
        super(
                URI.create("user/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("User not found: %s", username)
        );
    }
}
