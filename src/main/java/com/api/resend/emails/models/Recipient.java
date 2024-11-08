package com.api.resend.emails.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "email_log_id", referencedColumnName = "id")
    private EmailLog emailLog;
    private String email;
}
