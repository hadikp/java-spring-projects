package cinema.movies;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MovieNotFoundException extends AbstractThrowableProblem {

    public MovieNotFoundException(Long id) {
        super(URI.create("movie/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Movie not found: %d", id));
    }
}
