package com.api.resend.emails.dto;

import lombok.Data;

import java.util.List;
@Data
public class EmailRequest {
    private int userId;
    private String subject;
    private String body;
    private List<String> emails;
}
