package p.property;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import p.user.User;

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
    private String street;
    private int houseNumber;

    private List<String> images = new ArrayList<>(); //több kép is

    @JsonBackReference
    private User user;

    public Property(String description, String category, int price, String city, String county, String street, int houseNumber, List<String> images) {
        this.description = description;
        this.category = category;
        this.price = price;
        this.city = city;
        this.county = county;
        this.street = street;
        this.houseNumber = houseNumber;
        this.images = images;
    }
}
