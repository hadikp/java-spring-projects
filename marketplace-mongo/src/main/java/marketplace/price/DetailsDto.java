package marketplace.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {

    private String id;
    private String userId;
    private int price;
    private int isbnNumber;
    private Product product;
}
