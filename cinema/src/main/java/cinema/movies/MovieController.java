package cinema.movies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cinema")
public class MovieController {

    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies(){
        return service.getAllMovies();
    }

    @GetMapping("{id}")
    public MovieDTO getMovieById(@PathVariable("id") Long id){
        return service.getMovieById(id);
    }
}
