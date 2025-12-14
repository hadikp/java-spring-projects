package catalog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogItemHistoryDto {

    private Long id;

    private String parameter;

    private String comment;

    private LocalDateTime modified;
}
