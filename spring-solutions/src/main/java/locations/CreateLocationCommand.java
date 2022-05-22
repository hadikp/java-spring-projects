package locations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateLocationCommand {

    @Schema(description = "Name of the location", example = "Szeged")
    @NotBlank(message = "Name can't be empty!")
    private String name;

    @Schema(example = "46.253010")
    @DecimalMin("-90")
    @DecimalMax("91")
    private double latitude;

    @Schema(example = "20.141425")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private double longitude;
}
