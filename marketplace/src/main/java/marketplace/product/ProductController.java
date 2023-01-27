package marketplace.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@Tag(name = "Operations the Products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all Products")
    public List<ProductDto> listAllProducts(){
        return service.listAllProducts();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by id")
    public ProductDto findProductById(@PathVariable("id") Long id){
        return service.findProductById(id);
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

    @PutMapping("/{id}")
    @Operation(summary = "Update the user")
    public ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProduct command){
        return service.updateProduct(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete Product")
    @ApiResponse(responseCode = "204", description = "Product has been deleted")
    public void deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
    }

    @GetMapping("/category")
    @Operation(summary = "Find Product by category")
    public List<ProductDto> findProductByCategory(@RequestParam Category category){
        return service.findProductByCategory(category);
    }

    @GetMapping("/type")
    @Operation(summary = "Find Product by type")
    public List<ProductDto> findProductByType(@RequestParam Type type){
        return service.findProductByType(type);
    }
}
