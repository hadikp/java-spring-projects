package blog.image;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageDataController {

    private ImageDataService service;

    public ImageDataController(ImageDataService service) {
        this.service = service;
    }

    @GetMapping
    public List<ImageDataDto> listAllImages(){
        return service.listAllImages();
    }

    @GetMapping("/{id}")
    public ImageDataDto findImageById(@PathVariable("id") Long id){
        return service.findImageById(id);
    }
}
