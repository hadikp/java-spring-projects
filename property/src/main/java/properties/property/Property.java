package properties.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import properties.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "properties")
public class Property {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String description;
    private String category; //lakás ház telek
    private int price;
    private String city;
    private String county;

    private List<String> images = new ArrayList<>(); //több kép is

    private User user;

    public Property(String description, String category, int price, String city, String county, List<String> images) {
        this.description = description;
        this.category = category;
        this.price = price;
        this.city = city;
        this.county = county;
        this.images = images;
    }
}
