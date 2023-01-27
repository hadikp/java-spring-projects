package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCommand {

    private String productName;
    private String description;
    private Type productType;
    private Category category;
    private Boolean active;
    private String imagePath;
    private int price;


}
