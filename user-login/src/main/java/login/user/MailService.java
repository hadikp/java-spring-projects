package login.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final String defaultFrontendUrl;

    public MailService(JavaMailSender mailSender, @Value("${application.frontend.default-url}") String defaultFrontendUrl) {
        this.mailSender = mailSender;
        this.defaultFrontendUrl = defaultFrontendUrl;
    }

    public void sendForgotMessage(String email, String baseUrl){
        var url = baseUrl != null ? baseUrl : defaultFrontendUrl;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hadikp@freemail.com");
        message.setTo(email);
        message.setSubject("Reset your password!");
        message.setText(String.format("Click <a href='/reset/%s'>here</a> to reset your password!", url));
        mailSender.send(message);
    }
}
