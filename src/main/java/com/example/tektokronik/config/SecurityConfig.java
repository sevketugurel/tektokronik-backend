package com.example.tektokronik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CORS yapılandırmasını etkinleştir
                .cors(Customizer.withDefaults())
                // CSRF korumasını devre dışı bırak (geliştirme aşamasında)
                .csrf().disable()
                // Yetkilendirme kurallarını tanımla
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Frontend'inizin çalıştığı URL'yi ekleyin
        configuration.setAllowedOrigins(Arrays.asList("http://localhost", "http://127.0.0.1"));
        // İzin verilen HTTP metodlarını belirtin
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // İzin verilen başlıkları belirtin
        configuration.setAllowedHeaders(Arrays.asList("*"));
        // Kimlik bilgisi (credentials) gönderimine izin ver
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Tüm yollar için CORS yapılandırmasını uygula
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
