package com.api.resend.emails.controller;

import com.api.resend.emails.dto.DashboardRequest;
import com.api.resend.emails.dto.EmailRequest;
import com.api.resend.emails.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendMassiveEmail(emailRequest);
            return ResponseEntity.ok("Correos enviados exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al enviar los correos: " + e.getMessage());
        }
    }
    @GetMapping("/dashboard")
    public ResponseEntity<?> getInformation(){
        try {
            DashboardRequest dashboardRequest = emailService.getDasboardInformation();
            return ResponseEntity.ok(dashboardRequest);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener la información del dashboard: " + e.getMessage());
        }
    }
}
