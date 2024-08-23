package blog.image;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ImageNotFoundException extends AbstractThrowableProblem {

    public ImageNotFoundException(Long id) {
        super(
                URI.create("image/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Image not found: %d", id)
        );
    }
}
