package catalog.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItemDto {

    private Long id;

    private String value;

    private String name;

    private LocalDateTime modified;
}
