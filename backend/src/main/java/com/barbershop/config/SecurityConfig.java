package com.barbershop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> {}) // ✅ ATIVA CORS com Spring Security
            .csrf(csrf -> csrf.disable()) // ✅ DESATIVA CSRF (necessário pra API)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // ✅ LIBERA TODAS requisições
            );

        return http.build();
    }
}