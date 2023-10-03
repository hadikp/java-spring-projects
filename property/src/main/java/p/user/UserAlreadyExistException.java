package p.user;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class UserAlreadyExistException extends AbstractThrowableProblem {
    public UserAlreadyExistException(String name) {
        super(
                URI.create("user/already-exist"),
                "User already exist",
                Status.FOUND,
                String.format("User already exist %s", name)
        );
    }
}
