package p.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import p.property.Property;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String name;
    private String email;
    private String telephone;
    private String city;
    private String street;
    private int role; //hozzáférés

    @DocumentReference(lazy = true)
    private List<Property> properties = new ArrayList<>();

    public User(String name, String email, String telephone, String city, String street, int role) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.city = city;
        this.street = street;
        this.role = role;
    }

    public void addProperty(Property property){
        properties.add(property);
        property.setUser(this);
    }

}
