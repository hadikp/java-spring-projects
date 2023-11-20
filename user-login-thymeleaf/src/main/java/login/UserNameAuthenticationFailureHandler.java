package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class UserNameAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final String LAST_USERNAME_KEY = "lastUsername";

    public UserNameAuthenticationFailureHandler() {
        super("/login?error");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception)
            throws IOException, ServletException {
        var usernameParameter = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY;
        var lastUserName = req.getParameter(usernameParameter);

        var session = req.getSession(false);
        if (session != null || isAllowSessionCreation()) {
            req.getSession().setAttribute(LAST_USERNAME_KEY, lastUserName);
        }

        super.onAuthenticationFailure(req, resp, exception);
    }
}
