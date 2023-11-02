package login.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }



}
