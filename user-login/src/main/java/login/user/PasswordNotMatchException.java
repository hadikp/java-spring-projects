package login.user;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PasswordNotMatchException extends AbstractThrowableProblem {
    public PasswordNotMatchException() {
        super(
                URI.create("login/password-not-match"),
                "Password not match",
                Status.NOT_ACCEPTABLE,
                String.format("The password does not match!")
        );
    }
}
