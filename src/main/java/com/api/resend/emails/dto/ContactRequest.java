package com.api.resend.emails.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private int user_id;
    private String name;
    private String email;
}
