package p.property;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class PropertyAlreadyExistException extends AbstractThrowableProblem {
    public PropertyAlreadyExistException(String city, String street) {
        super(
                URI.create("property/already-exist"),
                "Already exist",
                Status.FOUND,
                String.format("Property already exist %s %s", city, street)
        );
    }
}
