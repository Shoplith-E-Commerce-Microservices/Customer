package com.shoplith.customers.config;

import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.method.configuration
        .EnableMethodSecurity;

import org.springframework.security.config.annotation.web.builders
        .HttpSecurity;

import org.springframework.security.config.annotation.web.configuration
        .EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers
        .AbstractHttpConfigurer;

import org.springframework.security.config.http
        .SessionCreationPolicy;

import org.springframework.security.oauth2.jwt.JwtDecoder;

import org.springframework.security.oauth2.jwt
        .NimbusJwtDecoder;

import org.springframework.security.oauth2.server.resource.authentication
        .JwtAuthenticationConverter;

import org.springframework.security.oauth2.server.resource.authentication
        .JwtGrantedAuthoritiesConverter;

import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        JwtGrantedAuthoritiesConverter
                grantedAuthoritiesConverter =
                new JwtGrantedAuthoritiesConverter();

        grantedAuthoritiesConverter
                .setAuthoritiesClaimName("roles");

        grantedAuthoritiesConverter
                .setAuthorityPrefix("");

        JwtAuthenticationConverter converter =
                new JwtAuthenticationConverter();

        converter.setJwtGrantedAuthoritiesConverter(
                grantedAuthoritiesConverter
        );

        http

                // Disable CSRF
                .csrf(AbstractHttpConfigurer::disable)

                // Stateless Session
                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                // Route Security
                .authorizeHttpRequests(auth -> auth

                        // Public Routes
                        .requestMatchers(
                                "/api/v1/customers/me",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**",
                                "/actuator/**"
                        ).permitAll()

                        // USER Routes
                        .requestMatchers(
                                "/api/v1/customer/**"
                        ).hasAnyRole("USER", "ADMIN")

                        // Any Authenticated User
                        .anyRequest()
                        .authenticated()
                )

                // OAuth2 Resource Server
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwt ->
                                jwt.jwtAuthenticationConverter(
                                        converter
                                )
                        )
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {

        SecretKey key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );

        return NimbusJwtDecoder
                .withSecretKey(key)
                .build();
    }
}