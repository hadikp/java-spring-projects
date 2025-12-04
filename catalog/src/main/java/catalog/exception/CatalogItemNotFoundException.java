package catalog.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CatalogItemNotFoundException extends AbstractThrowableProblem {

    public CatalogItemNotFoundException(Long id) {
        super(
                URI.create("catalog-item/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("CatalogItem not found: %d", id)
        );
    }
}
