package login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->auth.requestMatchers("/login").permitAll()
                        .requestMatchers("/")
                        .hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login").failureHandler(userNameAuthenticationFailureHandler()).permitAll())
                .logout(logout -> logout.logoutUrl("/logout").permitAll());
        return http.build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserNameAuthenticationFailureHandler userNameAuthenticationFailureHandler(){
        return new UserNameAuthenticationFailureHandler();
    }
}
