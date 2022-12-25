package marketplace.product;

import lombok.AllArgsConstructor;
import marketplace.comment.Comment;
import marketplace.comment.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
