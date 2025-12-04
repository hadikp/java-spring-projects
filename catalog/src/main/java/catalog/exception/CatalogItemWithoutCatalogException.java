package catalog.exception;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CatalogItemWithoutCatalogException extends AbstractThrowableProblem {

    public CatalogItemWithoutCatalogException(Long itemId) {
        super(
                URI.create("catalog-item/no-catalog"),
                "Invalid state",
                Status.CONFLICT,
                String.format("CatalogItem with ID %d does not belong to any Catalog", itemId)
        );
    }
}
