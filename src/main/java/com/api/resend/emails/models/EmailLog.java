package com.api.resend.emails.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "email_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private Message message;
    private byte status;
    private LocalDateTime sent_at;
    @JsonIgnore
    @OneToMany(mappedBy = "emailLog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipient> recipients;
}
