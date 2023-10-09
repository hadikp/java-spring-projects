package pf.user;


import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @DocumentId
    private String id;
    private String name;
    private String email;
    private String telephone;
    private String city;
    private String street;
    private int role; //hozzáf //hozzáf

}
