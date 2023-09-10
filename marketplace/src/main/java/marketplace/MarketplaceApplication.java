package marketplace;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class MarketplaceApplication {

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = MarketplaceApplication.class.getClassLoader();
		File file = new File(Objects.requireNonNull(classLoader.getResource("marketplace-firebase-key.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				//.setDatabaseUrl("https://marketplace-8a870.firebaseio.com")
				//.setDatabaseUrl("https://marketplace-8a870-default-rtdb.europe-west1.firebasedatabase.app")
				.build();

		FirebaseApp.initializeApp(options);


		SpringApplication.run(MarketplaceApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}

}
