package locations;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateLocationCommand {

    @Schema(example = "1")
    private Long id;

    @Schema(description = "Name of the location", example = "Bp")
    @NotBlank(message = "Name can't be empty!")
    private String name;

    @Schema(example = "47.49000")
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private double lat;

    @Schema(example = "1.11111")
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private double lon;
}
