package marketplace.wish;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import marketplace.product.Type;
import marketplace.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@Table(name = "wishes")
@Embeddable
public class Wish {


    @Column(name = "wish_name")
    private String wishName;

    private String description;

    @Column(name = "wish_type")
    @Enumerated(EnumType.STRING)
    private Type wishType;

   /* @ManyToMany(mappedBy = "wishes")
    private List<User> users = new ArrayList<>();*/

    public Wish(String wishName, String description, Type wishType) {
        this.wishName = wishName;
        this.description = description;
        this.wishType = wishType;
    }
}
