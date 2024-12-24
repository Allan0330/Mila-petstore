package com.example.demo_petstore.security;

import com.example.demo_petstore.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration// Marca la clase como una clase de configuración
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;
    private final CustomAuthenticationSuccessHandler successHandler;

// Constructor para inyectar el servicio UserDetailsService
public SecurityConfig(UserDetailsServiceImpl userDetailsService, CustomAuthenticationSuccessHandler successHandler) {
    this.userDetailsService = userDetailsService;
    this.successHandler = successHandler;
}

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/h2-console/**").permitAll() 
                .requestMatchers("/admin/**").hasRole("ADMIN") 
                .requestMatchers("/user/**").hasRole("USER") 
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") 
                .successHandler(successHandler) 
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()) // Disable CSRF for H2 console
            .headers(headers -> headers.frameOptions().disable()); // Allow H2 console frames
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); 
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
