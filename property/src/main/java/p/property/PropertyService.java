package p.property;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public PropertyDto createProperty(PropertyCommand command) {
        Property propertyExist = repository.existByCityAndStreetAndHouseNumber(command.getCity(), command.getStreet(), command.getHouseNumber());

        PropertyDto newPropertyDto = null;
        if(propertyExist == null){
            newPropertyDto = getPropertyDto(command);
        } else if (propertyExist.getPrice() != command.getPrice()) {
                newPropertyDto = getPropertyDto(command);
        } else {
            throw new PropertyAlreadyExistException(command.getCity(), command.getStreet());
        }
        return newPropertyDto;
    }

    private PropertyDto getPropertyDto(PropertyCommand command) {
        PropertyDto newPropertyDto;
        LocalDate startDate = LocalDate.now();
        Property createProperty = new Property(command.getDescription(), command.getCategory(), command.getPrice(),
                command.getCity(), command.getCounty(), command.getStreet(), command.getHouseNumber(), command.getActive(),
                startDate, startDate.plusDays(90), command.getImages());
        repository.save(createProperty);
        newPropertyDto = modelMapper.map(createProperty, PropertyDto.class);
        return newPropertyDto;
    }

    public void deleteProperty(String id) {
        Property findproperty = repository.findById(id).orElseThrow(() -> new PropertyNotFoundexception(id));
        repository.delete(findproperty);
    }

    public List<PropertyDto> findPropertyByCategory(String category) {
        List<Property> properties = repository.findByCategory(category);
        return properties.stream().map(p -> modelMapper.map(p, PropertyDto.class)).collect(Collectors.toList());
    }

    public void expiredProperty(){
        List<Property> properties = repository.findAll();
        List<Property> findPropertyList = new ArrayList<>();
        for (Property p: properties){
            LocalDate currentDate = LocalDate.now();
            findPropertyList = repository.nowBeforeEndDate(currentDate);
        }
        if (findPropertyList != null){
            for (Property p: findPropertyList){
                System.out.println("Property expired: " + p.getDescription());
            }
        }
    }

    @Transactional
    public PropertyDto updateProperty(String id, PropertyCommand command) {
        Property findproperty = repository.findById(id).orElseThrow(() -> new PropertyNotFoundexception(id));
        findproperty.setDescription(command.getDescription());
        findproperty.setCategory(command.getCategory());
        findproperty.setPrice(command.getPrice());
        findproperty.setCity(command.getCity());
        findproperty.setCounty(command.getCounty());
        findproperty.setStreet(command.getStreet());
        findproperty.setHouseNumber(command.getHouseNumber());
        findproperty.setActive(command.getActive());
        findproperty.setStartDate(command.getStartDate());
        findproperty.setEndDate(command.getEndDate());
        findproperty.setImages(command.getImages());
        repository.save(findproperty);
        return modelMapper.map(findproperty, PropertyDto.class);
    }
}
