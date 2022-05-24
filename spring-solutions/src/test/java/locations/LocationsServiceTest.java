package locations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LocationsServiceTest {

    LocationsService service;

    @BeforeEach
    void init() {
        ModelMapper modelMapper = new ModelMapper();
        service = new LocationsService(modelMapper);
    }

    @Test
    void getAllLocations() {
        List<LocationDto> expected = service.getLocations(Optional.empty());
        assertThat(expected).hasSize(2).extracting(LocationDto::getName).contains("Budapest", "Debrecen");
    }

    @Test
    void testOneLocation() {
        Optional<String> locationBp = Optional.of("Budapest");
        List<LocationDto> expected = service.getLocations(locationBp);
        assertThat(expected).hasSize(1).extracting(LocationDto::getName).contains("Budapest");
    }

    @Test
    void testFindLocationById() {
        LocationDto expected = service.findLocationById(2L);
        assertEquals("Debrecen", expected.getName());
    }
}

