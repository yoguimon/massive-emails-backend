package com.api.resend.emails.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PruebasController {
    @GetMapping("/prueba")
    public String mensaje(){
        return "Hola desde el Backend";
    }
}
