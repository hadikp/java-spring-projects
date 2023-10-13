package p.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyCommand {

    private String description;
    private Category category;
    private int price;
    private String city;
    private String county;
    private String street;
    private int houseNumber;
    private Boolean active;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> images;
}
