package pf;

import com.google.firebase.auth.FirebaseAuth;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import pf.security.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PropertyFirebaseApplication {

	public static void main(String[] args){
		SpringApplication.run(PropertyFirebaseApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}






}
