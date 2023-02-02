package marketplace.wish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishCommand {

    private String wishName;
    private String description;
    private Type wishType;
}
