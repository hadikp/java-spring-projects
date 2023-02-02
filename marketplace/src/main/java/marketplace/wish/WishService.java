package marketplace.wish;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WishService {

    private WishRepository repository;
    private ModelMapper modelMapper;

    public List<WishDto> listAllWish() {
        List<Wish> wishes = repository.findAll();
        return wishes.stream().map(w -> modelMapper.map(w, WishDto.class)).collect(Collectors.toList());
    }
}
