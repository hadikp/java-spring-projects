package marketplace.product;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProducService {

    private ProductRepository repository;
    private ModelMapper modelMapper;
    public List<ProductDto> listAllProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }
}
