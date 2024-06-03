package com.example.develup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 보호 기능 비활성화(임시)
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 모든 요청에 대해 접근 허용
                        .anyRequest().permitAll()
                )
                .httpBasic(withDefaults());
        return http.build();
    }
}
