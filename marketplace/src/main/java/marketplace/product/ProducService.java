package marketplace.product;

import lombok.AllArgsConstructor;
import marketplace.comment.Comment;
import marketplace.comment.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public List<ProductDto> listAllProductsWithCommnets() {
        List<Product> productsWithCommentsFromDB = repository.findAllProductWithComments();
        List<ProductDto> productWithCommentDtoList = new ArrayList<>();

        for(Product p: productsWithCommentsFromDB){
            ProductDto pDto = modelMapper.map(p, ProductDto.class);

            for(Comment c: p.getCommentList()){
                CommentDto cDto = modelMapper.map(c, CommentDto.class);
                pDto.getCommentDtoList().add(cDto);
            }
            productWithCommentDtoList.add(pDto);
        }
        return productWithCommentDtoList;
    }

    public ProductDto createProduct(ProductCommand command) {
        Product product = new Product(command.getProductName(), command.getDescription(), command.getProductType(),
                command.getCategory(), command.getActive(), command.getImagePath(), command.getPrice());
        repository.save(product);
        return modelMapper.map(product, ProductDto.class);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public ProductDto updateProduct(Long id, UpdateProduct command) {
        Product findProduct = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        findProduct.setProductName(command.getProductName());
        findProduct.setDescription(command.getDescription());
        findProduct.setProductType(command.getProductType());
        findProduct.setCategory(command.getCategory());
        findProduct.setActive(command.getActive());
        findProduct.setImagePath(command.getImagePath());
        findProduct.setPrice(command.getPrice());
        return modelMapper.map(findProduct, ProductDto.class);
    }

    public ProductDto findProductById(Long id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        return modelMapper.map(product, ProductDto.class);
    }
}
