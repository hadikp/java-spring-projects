package marketplace.product;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(p -> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
    }

   /* public ProductDto addProductPrice(String id, int price) {
        Product findProduct = productRepository.findById(id).orElseThrow(() -> new PriceNotFoundException(id));
        findProduct.setPrice(price);
        productRepository.save(findProduct);
        return modelMapper.map(findProduct, ProductDto.class);
    }*/
}
