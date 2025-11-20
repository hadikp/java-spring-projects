package catalog.dto;

import catalog.service.CatalogItemService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDto {

    private Long id;

    private String name;

    private String description;

    private String parameter;

    private LocalDateTime modified;

    private List<CatalogItemDto> items;
}
