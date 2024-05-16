package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    @Order(1)
    SecurityFilterChain filterChainActuator(HttpSecurity http) throws Exception {

        var useWorkaround = true;

        if (useWorkaround) {
            http.securityMatcher(request -> request.getServletPath().startsWith("/actuator"));
        } else {
            http.securityMatcher("/actuator/**");
        }

        return http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain filterChainBase(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            .formLogin(form -> {})
            .build();
    }


}
