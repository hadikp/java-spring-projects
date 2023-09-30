package marketplace.product;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.repository.Query;
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

    public ProductDto createProduct(ProductDto command) {
        Product nameExist = productRepository.existByName(command.getName());

        ProductDto newProductDto = null;
        if(nameExist == null){
           Product newProduct = new Product(command.getName(), command.getDescription(), command.getImagePath());
            productRepository.save(newProduct);
            newProductDto = modelMapper.map(newProduct, ProductDto.class);
        }else {
            throw new ProductAlreadyExistException(nameExist.getName());
        }
        return newProductDto;
    }


    public ProductDto findProductById(String id) {
        Product findProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return modelMapper.map(findProduct, ProductDto.class);
    }
}
