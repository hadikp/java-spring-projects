package token.security;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.util.Arrays;
import java.util.Optional;

public class JwtCookieStore {
    private static final String COOKIE_NAME = "token";
    private static final int EXPIRATION = 30 * 60 * 1000;
    @Autowired
    private TokenService tokenService;
    private void storeToken(HttpServletResponse response, Authentication auth){
        String token = tokenService.generateToken(auth);
        storeTokenInCookie(response, token);
    }

    private void storeTokenInCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setMaxAge(EXPIRATION);
        cookie.setPath("/api");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

   /* public Optional<Authentication> retrieveToken(HttpServletRequest request){
        Optional<Cookie> cookie = findCookie(request);
        if(cookie.isEmpty()){
            return Optional.empty();
        }
        String token = cookie.get().getValue();

    }*/

    private Optional<Cookie> findCookie(HttpServletRequest request) {
        return Optional.ofNullable(request.getCookies()).stream().flatMap(Arrays::stream)
                .filter(c -> c.getName().equals(COOKIE_NAME)).findAny();
    }


























}
