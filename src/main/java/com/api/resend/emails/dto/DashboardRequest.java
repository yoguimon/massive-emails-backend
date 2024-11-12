package com.api.resend.emails.dto;

import com.api.resend.emails.models.Message;
import lombok.Data;

import java.util.List;

@Data
public class DashboardRequest {
    private int number;
    private List<Object[]> messages;
}
