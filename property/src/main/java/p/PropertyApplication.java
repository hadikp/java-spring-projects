package p;

import jakarta.annotation.Resource;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import p.file.FileStorageService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PropertyApplication implements CommandLineRunner {

	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(PropertyApplication.class, args);
	}

	public void run(String... arg) throws Exception{
		storageService.init();
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}

}
