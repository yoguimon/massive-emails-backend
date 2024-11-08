package com.api.resend.emails.dto;

import lombok.Data;

import java.util.List;
@Data
public class EmailRequest {
    private int user_id;
    private String subject;
    private String body;
    private List<String> emails;
}
