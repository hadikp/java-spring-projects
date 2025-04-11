package run.runs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunDto {

    private Long id;
    private String type;
    private String description;
    private double km;
    private LocalDate date;
}
