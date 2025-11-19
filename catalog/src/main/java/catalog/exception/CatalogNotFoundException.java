package catalog.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CatalogNotFoundException extends AbstractThrowableProblem {

    public CatalogNotFoundException(Long id) {
        super(
                URI.create("catalog/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Catalog not found: %d", id)
        );
    }
}
