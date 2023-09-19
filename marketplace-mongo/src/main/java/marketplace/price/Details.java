package marketplace.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Product;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "details")
public class Details {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String userId;
    private int price;
    private int isbnNumber;

    @DBRef
    private Product product;

    public Details(int price, int isbnNumber) {
        this.price = price;
        this.isbnNumber = isbnNumber;
    }
}
