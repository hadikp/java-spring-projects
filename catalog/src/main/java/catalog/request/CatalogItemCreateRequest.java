package catalog.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItemCreateRequest {

    @Column(name = "item_value")
    private String itemValue;

    private String name;

    private Long catalogId;
}
