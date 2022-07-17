package cinema.movies;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private MoviesRepository repository;
    private ModelMapper modelMapper;
}
