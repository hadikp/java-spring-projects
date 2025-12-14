package catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogAndItemsDto {

    private Long id;

    private String name;

    private String description;

    private String parameter;

    private LocalDateTime modified;

    private List<CatalogItemDto> items;
}
