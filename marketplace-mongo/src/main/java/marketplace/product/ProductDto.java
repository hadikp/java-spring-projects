package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.price.Details;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private String name;
    private String description;
    private String imagePath;
    //private List<Details> detailsList;
}
