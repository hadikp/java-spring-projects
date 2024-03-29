package login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public List<User> listUsers(){
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug("logged in user: {}", user);
        return userRepository.findAll(Sort.by("username"));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')") //a methódus meghívásakor jogosultság ellenőrzést végez
    public void addUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
}
