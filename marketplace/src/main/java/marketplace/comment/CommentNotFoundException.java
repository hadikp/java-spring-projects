package marketplace.comment;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CommentNotFoundException extends AbstractThrowableProblem {
    public CommentNotFoundException(Long id) {
        super(
                URI.create("comment/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Comment not found %d", id)
        );
    }
}
