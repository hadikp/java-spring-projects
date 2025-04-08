package run;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringRunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRunApplication.class, args);
	}

	@Bean
	public ModelMapper createModelmapper(){
		return new ModelMapper();
	}

}
