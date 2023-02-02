package marketplace.wish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Type;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishDto {

    private Long id;
    private String wishName;
    private String description;
    private Type wishType;
}
