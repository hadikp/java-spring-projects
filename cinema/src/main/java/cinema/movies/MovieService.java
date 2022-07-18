package cinema.movies;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private MoviesRepository repository;
    private ModelMapper modelMapper;

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = repository.findAll();
        return movies.stream().map(m -> modelMapper.map(m, MovieDTO.class)).collect(Collectors.toList());
    }

    public MovieDTO getMovieById(Long id) {
        Movie movie = repository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
        return modelMapper.map(movie, MovieDTO.class);
    }
}
