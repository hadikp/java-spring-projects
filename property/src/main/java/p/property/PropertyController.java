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

    @PostMapping("/create")
    public PropertyDto createProperty(@RequestBody PropertyDto command){
        return service.createProperty(command);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable("id") String id){
        service.deleteProperty(id);
    }
}
