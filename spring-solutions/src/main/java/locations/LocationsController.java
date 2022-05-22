package locations;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
@Tag(name = "Operations the locations")
public class LocationsController {

    private LocationsService locationsService;

    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping
    @Operation(summary = "get all locations")
    public String  getLocations(@RequestParam Optional<String> locationName) {
        return locationsService.getLocations(locationName).toString();
    }

    @GetMapping("/{id}")
    @Operation(summary = "find one location by id")
    public LocationDto findLocationById(@PathVariable("id") Long id) {
        return locationsService.findLocationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "creates a location")
    @ApiResponse(responseCode = "201", description = "location has been created")
    public LocationDto createLocation(@Valid @RequestBody CreateLocationCommand command){
        return locationsService.createLocation(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update a location")
    @ApiResponse(description = "location has been updated")
    public LocationDto updateLocation(@PathVariable("id") Long id, @RequestBody UpdateLocationCommand command){
        return locationsService.updateLocation(id, command);
    }

     @DeleteMapping
     @ResponseStatus(HttpStatus.NO_CONTENT)
     @Operation(summary = "delete one location by id")
     @ApiResponse(responseCode = "204", description = "location has been deleted")
     public void deleteLocation(@PathVariable("id") Long id){
        locationsService.deleteLocation(id);
     }
}
