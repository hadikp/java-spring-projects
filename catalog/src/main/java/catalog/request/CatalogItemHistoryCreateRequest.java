package catalog.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItemHistoryCreateRequest {

    @Column(name = "catalog_item_id")
    private Long catalogItemId;

    private String parameter;

    private String comment;
}
