package marketplace.product;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PriceNotFoundException extends AbstractThrowableProblem {
    public PriceNotFoundException(String id) {
        super(
                URI.create("product/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Product not found %d", id)
        );
    }
}
