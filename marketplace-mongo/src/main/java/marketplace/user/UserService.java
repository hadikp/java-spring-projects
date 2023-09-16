package marketplace.user;

import lombok.AllArgsConstructor;
import marketplace.product.Product;
import marketplace.product.ProductDto;
import marketplace.product.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    public List<ProductDto> UserWithProducts(String userId) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        List<Product> findProducts = userRepository.findUserWithProducts(userId);
        return findProducts.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }
}
