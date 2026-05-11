package com.dolsoft.authorservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll()   // 👈 временно разрешаем всё
            .and()
            .csrf().disable();
        return http.build();
    }
} // временно для лабы 9
/*
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig {
 * 
 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
 * Exception { http .csrf().disable() .authorizeRequests()
 * .antMatchers("/actuator/health", "/actuator/prometheus",
 * "/actuator/**").permitAll() .anyRequest().authenticated() .and()
 * .oauth2ResourceServer() .jwt(); return http.build(); }
 * 
 * @Bean public JwtDecoder jwtDecoder() { return NimbusJwtDecoder.withJwkSetUri(
 * "http://localhost:8180/realms/spmia-realm/protocol/openid-connect/certs"
 * ).build(); } }
 */