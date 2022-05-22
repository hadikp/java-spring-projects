package locations;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSolutionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSolutionsApplication.class, args);
	}

	/*@Bean
	public LocationsService locationsService() {
		return new LocationsService();
	}*/

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
