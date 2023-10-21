package pf.security;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private String jwtSecret;
    private int jwtExpirationMs;
    private String jwtCookie;
}
