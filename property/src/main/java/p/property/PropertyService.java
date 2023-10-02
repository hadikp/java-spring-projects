package p.property;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyService {

    private PropertyRepository repository;

    private ModelMapper modelMapper;

    public List<PropertyDto> listAllProperty() {
        List<Property> properties = repository.findAll();
        return properties.stream().map(p -> modelMapper.map(p, PropertyDto.class)).collect(Collectors.toList());
    }

    public PropertyDto findPropertyById(String id) {
        Property findProperty = repository.findById(id).orElseThrow(() -> new PropertyNotFoundexception(id));
        return modelMapper.map(findProperty, PropertyDto.class);
    }

    public PropertyDto createProperty(PropertyDto command) {
        List<String> imagesList = new ArrayList<>();
        for (String i : command.getImages()){
            imagesList.add(i);
        }
        Property createProperty = new Property(command.getDescription(), command.getCategory(), command.getPrice(),
                command.getCity(), command.getCounty(), imagesList);
        repository.save(createProperty);
        return modelMapper.map(createProperty, PropertyDto.class);
    }

    public void deleteProperty(String id) {
        Property findproperty = repository.findById(id).orElseThrow(() -> new PropertyNotFoundexception(id));
        repository.delete(findproperty);
    }

    public List<PropertyDto> findPropertyByCategory(String category) {
        List<Property> properties = repository.findByCategory(category);
        return properties.stream().map(p -> modelMapper.map(p, PropertyDto.class)).collect(Collectors.toList());
    }
}