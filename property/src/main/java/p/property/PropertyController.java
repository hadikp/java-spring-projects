package p.property;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property")
public class PropertyController {

    private PropertyService service;

    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @GetMapping
    public List<PropertyDto> listAllProperty(){
        return service.listAllProperty();
    }

    @GetMapping("/{id}")
    public PropertyDto findPropertyById(@PathVariable("id") String id){
        return service.findPropertyById(id);
    }

    @GetMapping("/category/{category}")
    public List<PropertyDto> findPropertyByCategory(@PathVariable("category") String category){
        return service.findPropertyByCategory(category);
    }

    @PutMapping("/{id}")
    public PropertyDto updateProperty(@PathVariable("id") String id, @RequestBody PropertyCommand command){
        return service.updateProperty(id, command);
    }

    @PostMapping("/create")
    public PropertyDto createProperty(@RequestBody PropertyCommand command){
        return service.createProperty(command);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable("id") String id){
        service.deleteProperty(id);
    }
}
