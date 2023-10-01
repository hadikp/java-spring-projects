package p.property;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PropertyNotFoundexception extends AbstractThrowableProblem {
    public PropertyNotFoundexception(String id) {
        super(
                URI.create("property/not-found"),
                "Not-Found",
                Status.NOT_FOUND,
                String.format("Property not found %s", id)
        );
    }
}
