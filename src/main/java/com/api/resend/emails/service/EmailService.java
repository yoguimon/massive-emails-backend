package com.api.resend.emails.service;

import com.api.resend.emails.dto.EmailRequest;
import com.api.resend.emails.models.EmailLog;
import com.api.resend.emails.models.Message;
import com.api.resend.emails.models.Recipient;
import com.api.resend.emails.models.User;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class EmailService {
    @PersistenceContext
    EntityManager entityManager;
    private final Resend resend;
    public EmailService(@Value("${resend.api.key}") String apiKey) {
        this.resend = new Resend(apiKey);
    }

    public void sendMassiveEmail(EmailRequest emailRequest) {
        User user = entityManager.find(User.class,emailRequest.getUser_id());
        Message message = Message.builder()
                .user(user)
                .subject(emailRequest.getSubject())
                .body(emailRequest.getBody())
                .build();
        entityManager.persist(message);
        EmailLog emailLog = EmailLog.builder()
                .message(message)
                .status((byte) 1)
                .sent_at(LocalDateTime.now())
                .build();
        entityManager.persist(emailLog);
        for (String email : emailRequest.getEmails()) {
            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from("Jhonny <yogui@jhoninformatica.online>")
                    .to(email)
                    .subject(emailRequest.getSubject())
                    .html(emailRequest.getBody())
                    .build();
            try {
                CreateEmailResponse data = resend.emails().send(params);
                Recipient recipient = Recipient.builder()
                        .emailLog(emailLog)
                        .email(email)
                        .build();
                entityManager.persist(recipient);
                System.out.println("Correo enviado con ID: " + data.getId());
            } catch (ResendException e) {
                System.err.println("Error al enviar el correo a " + email + ": " + e.getMessage());
            }
        }
    }
}
