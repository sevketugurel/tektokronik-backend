package com.example.tektokronik.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Apply CORS settings to specific endpoints
                .allowedOrigins("http://localhost:5173")  // Allow the frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow necessary HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Enable credentials if necessary
    }
}
