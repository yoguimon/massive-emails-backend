package com.api.resend.emails.service;

import com.api.resend.emails.dto.EmailRequest;
import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final Resend resend;

    // Inyecta la API Key de Resend desde el archivo de propiedades
    public EmailService(@Value("${resend.api.key}") String apiKey) {
        this.resend = new Resend(apiKey);
    }

    public void sendMassiveEmail(EmailRequest emailRequest) {
        for (String email : emailRequest.getEmails()) {
            CreateEmailOptions params = CreateEmailOptions.builder()
                    .from("TuNombre <your-email@example.com>")  // Cambia por tu correo registrado en Resend
                    .to(email)
                    .subject(emailRequest.getSubject())
                    .html(emailRequest.getBody())
                    .build();

            try {
                CreateEmailResponse data = resend.emails().send(params);
                System.out.println("Correo enviado con ID: " + data.getId());
            } catch (ResendException e) {
                System.err.println("Error al enviar el correo a " + email + ": " + e.getMessage());
            }
        }
    }
}
