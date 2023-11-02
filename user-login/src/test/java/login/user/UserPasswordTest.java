package login.user;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class UserPasswordTest {

    @Test
    void testEncode(){
        System.out.println(new BCryptPasswordEncoder().encode("pass"));
    }

}