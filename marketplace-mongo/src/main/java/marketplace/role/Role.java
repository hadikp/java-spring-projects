package marketplace.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "roles")
public class Role {

    @MongoId
    private String id;
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }
}
