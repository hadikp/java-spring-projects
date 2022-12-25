package marketplace.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "Operations the Products")
public class ProductController {

    private ProducService service;

    public ProductController(ProducService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Products")
    public List<ProductDto> listAllProducts(){
        return service.listAllProducts();
    }

    @GetMapping("/comment")
    public List<ProductDto> listAllProductsWithComments(){
        return service.listAllProductsWithCommnets();
    }
}
