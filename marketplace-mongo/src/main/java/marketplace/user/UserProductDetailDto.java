package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProductDetailDto {

    private User user;
    private Product product;
}
