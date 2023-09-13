package marketplace;

import marketplace.BookStore.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class MarketplaceMongoApplication {

	@Autowired
	BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceMongoApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}

}
