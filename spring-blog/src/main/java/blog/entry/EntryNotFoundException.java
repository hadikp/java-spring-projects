package blog.entry;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class EntryNotFoundException extends AbstractThrowableProblem {

    public EntryNotFoundException(Long id) {
        super(
                URI.create("entry/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Post not found: %d", id)
        );
    }
}
