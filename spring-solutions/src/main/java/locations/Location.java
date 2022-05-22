package locations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    private Long id;
    private String name;
    private double latitude;
    private double longitude;
}
