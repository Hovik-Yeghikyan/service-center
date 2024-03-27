package am.itspace.servicecenter.service.Impl;

import am.itspace.servicecenter.entity.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class SendMailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Async
    public void sendWelcomeMail(User user) {

        final Context ctx = new Context();
        ctx.setVariable("user", user);

        final String htmlContent = templateEngine.process("mail/welcome-mail.html", ctx);

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setSubject("Welcome Html Mail");
            message.setTo(user.getEmail());

            message.setText(htmlContent, true); // true = isHtml

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

}