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

    /*@PutMapping("/{productId}/price/{price}")
    public ProductDto addProductPrice(@PathVariable("productId") String id, @PathVariable("price") int price){
        return service.addProductPrice(id, price);
    }*/
}
