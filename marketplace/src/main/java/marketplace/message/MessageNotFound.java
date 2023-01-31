package marketplace.message;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MessageNotFound extends AbstractThrowableProblem {
    public MessageNotFound(Long id) {
        super(
                URI.create("message/not-foumd"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Message not found %d", id)
        );
    }
}
