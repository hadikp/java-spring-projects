package marketplace.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateProduct {

    private String productName;
    private String description;
    private Type productType;
    private Category category;
    private Boolean active;
    private String imagePath;
    private int price;
}
