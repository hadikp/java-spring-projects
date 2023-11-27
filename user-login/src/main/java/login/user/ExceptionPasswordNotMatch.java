package login.user;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ExceptionPasswordNotMatch extends AbstractThrowableProblem {
    public ExceptionPasswordNotMatch() {
        super(
                URI.create("login/password-not-match"),
                "Password not match",
                Status.NOT_ACCEPTABLE,
                String.format("The password does not match!")
        );
    }
}
