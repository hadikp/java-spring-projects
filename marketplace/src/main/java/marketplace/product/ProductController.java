package marketplace.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Product has been created")
    public ProductDto createProduct(@RequestBody ProductCommand command){
        return service.createProduct(command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Product")
    @ApiResponse(responseCode = "204", description = "Product has been deleted")
    public void deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
    }
}