package marketplace.wish;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public WishDto findWishById(Long id) {
        Wish wish = repository.findById(id).orElseThrow(() -> new WishNotFoundException(id));
        return modelMapper.map(wish, WishDto.class);
    }

    public WishDto createWish(WishCommand command) {
        Wish wish = new Wish(command.getWishName(), command.getDescription(), command.getWishType());
        repository.save(wish);
        return modelMapper.map(wish, WishDto.class);
    }

    @Transactional
    public WishDto updateWish(Long id, UpdateWish command) {
        Wish findWish = repository.findById(id).orElseThrow(() -> new WishNotFoundException(id));
        findWish.setWishName(command.getWishName());
        findWish.setDescription(command.getDescription());
        findWish.setWishType(command.getWishType());
        return modelMapper.map(findWish, WishDto.class);
    }

    public void deleteWish(Long id) {
        repository.deleteById(id);
    }
}
