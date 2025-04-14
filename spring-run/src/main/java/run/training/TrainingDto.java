package run.training;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDto {

    private Long id;

    private String type;
    private BigDecimal monthlyKm;
    private BigDecimal yearlyKm;
    private LocalDate date;
}
