package blog.image;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImageDataService {

    private ImageDataRepository repository;
    private ModelMapper modelMapper;

    public List<ImageDataDto> listAllImages() {
        List<ImageData> imagesDatas = repository.findAll();
        return imagesDatas.stream().map(i -> modelMapper.map(i, ImageDataDto.class)).collect(Collectors.toList());
    }
}
