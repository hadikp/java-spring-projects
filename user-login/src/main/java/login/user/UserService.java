package login.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private UserRepository repository;
    private ModelMapper modelMapper;
    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public List<User> listUsers(){
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.debug("logged in user: {}", user);
        return repository.findAll(Sort.by("username"));
    }

    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserDto registerUser(UserCommand command){
       /* if(!command.getPassword().equals(command.getPasswordConfirm())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password do not match!");
        }*/

        User newUser = new User(command.getUsername(), command.getEmail(), command.getRole(), LocalDate.now());
        newUser.setPassword(new BCryptPasswordEncoder().encode(command.getPassword()));
        repository.save(newUser);
        return modelMapper.map(newUser, UserDto.class);
    }


    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
