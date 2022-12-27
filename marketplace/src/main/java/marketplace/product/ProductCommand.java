package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCommand {

    private String name;
    private String description;
    private String imagePath;
    private int price;
    private Type productType;
}
