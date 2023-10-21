package pf;

import com.google.firebase.auth.FirebaseAuth;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PropertyFirebaseApplication {

	public static void main(String[] args){
		SpringApplication.run(PropertyFirebaseApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}

	@Bean
	public FirebaseAuth firebaseAuth(){
		return FirebaseAuth.getInstance();
	}





}
