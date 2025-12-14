package catalog.request;

import catalog.dto.ParameterDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItemCreateRequest {

    @Column(name = "item_value")
    private String value;

    private String name;

    private Long catalogId;

    private List<ParameterDto> currentItems;
}
