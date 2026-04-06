package com.crio.video_rental_basic.config;

import com.crio.video_rental_basic.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

  private final CustomUserDetailsService userDetailsService;

  // Password Encoder Bean
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // Authentication Provider (Updated for Spring Security 6+)
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider auth = new DaoAuthenticationProvider(userDetailsService);

    auth.setPasswordEncoder(passwordEncoder());
    return auth;
  }

  // Security Filter Chain Configuration
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        // Disable CSRF (for APIs)
        .csrf(csrf -> csrf.disable())

        // Register Authentication Provider
        .authenticationProvider(authenticationProvider())

        // Authorization Rules
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/register").permitAll()
            .requestMatchers("/api/videos/**").authenticated()
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated())

        // Basic Authentication (NEW syntax)
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }
}