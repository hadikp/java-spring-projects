package marketplace.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.price.Details;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProductDetailsCommand {

    private String productId;
    private Details details;

}
