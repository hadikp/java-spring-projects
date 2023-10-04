package p.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCommand {

    private String description;
    private String category;
    private int price;
    private String city;
    private String county;
    private String street;
    private int houseNumber;
    private List<String> images;
}
