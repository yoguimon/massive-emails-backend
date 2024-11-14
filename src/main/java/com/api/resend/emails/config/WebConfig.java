package com.api.resend.emails.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir todas las rutas
                .allowedOrigins("https://massive-emails-frontend.vercel.app") // URL de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("Authorization", "Content-Type", "Accept", "X-Requested-With") // Encabezados necesarios
                .allowCredentials(true); // Permitir credenciales si es necesario
    }
}