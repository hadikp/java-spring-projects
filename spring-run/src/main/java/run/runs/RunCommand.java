package run.runs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RunCommand {

    private String type;
    private String description;
    private double km;
    private LocalDate date;
}
