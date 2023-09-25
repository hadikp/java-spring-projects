package marketplace.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDto> getAllProduct(){
        return service.getAllProduct();
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable("id") String id){
        return service.findProductById(id);
    }

    @PostMapping("/create")
    public ProductDto createProduct(@RequestBody ProductDto command){
        return service.createProduct(command);
    }


}
