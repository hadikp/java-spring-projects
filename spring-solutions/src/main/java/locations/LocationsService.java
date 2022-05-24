package locations;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LocationsService {

    private ModelMapper modelMapper;
    private AtomicLong idGenerator = new AtomicLong(3);

    private List<Location> locations = new ArrayList<>(List.of(
            new Location(1L, "Budapest", 47.497912, 19.040235),
            new Location(2L, "Debrecen", 47.531605, 21.627312))
    );

    public LocationsService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<LocationDto> getLocations(Optional<String> locationName) {
        Type targetListType = new TypeToken<List<LocationDto>>(){}.getType();
        List<Location> filtered = locations.stream()
                .filter(l -> locationName.isEmpty() || l.getName().toLowerCase().equals(locationName.get().toLowerCase())).toList();
        return modelMapper.map(filtered, targetListType);
    }

    public LocationDto findLocationById(Long id) {
        Location location = locations.stream().filter(l -> l.getId() == id).findAny()
                .orElseThrow(() -> new LocationNotFoundException(id));
        return modelMapper.map(location, LocationDto.class);
    }

    public LocationDto createLocation(CreateLocationCommand command) {
        Location location = new Location(idGenerator.incrementAndGet(), command.getName(), command.getLatitude(), command.getLongitude());
        locations.add(location);
        return modelMapper.map(location, LocationDto.class);
    }

    public LocationDto updateLocation(Long id, UpdateLocationCommand command) {
        Location location = locations.stream().filter(f -> f.getId() == id).findFirst()
                .orElseThrow(() -> new LocationNotFoundException(id));
        location.setName(command.getName());
        location.setLatitude(command.getLat());
        location.setLongitude(command.getLon());
        return modelMapper.map(location, LocationDto.class);
    }

    public void deleteLocation(Long id) {
        Location location = locations.stream().filter(f -> f.getId() == id).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find location!" + id));
        locations.remove(location);
    }
}
