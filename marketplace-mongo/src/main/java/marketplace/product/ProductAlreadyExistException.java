package marketplace.product;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ProductAlreadyExistException extends AbstractThrowableProblem {
    public ProductAlreadyExistException(String name) {
        super(
                URI.create("product/already-exist"),
                "Already exist",
                Status.FOUND,
                String.format("Product already exist %s", name)
        );
    }
}
