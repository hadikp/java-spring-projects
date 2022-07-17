package cinema.movies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieCommand {

    @NotBlank(message = "The title can't be empty!")
    private String title;

    private LocalDateTime date;
    private int maxSpace;
}
