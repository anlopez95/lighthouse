package com.meli.lighthouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// Se realiza la especificacion de la configuracion de seguridad para permitir las pruebas de consumo de api rest en ambiente propio
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      /*  http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/topsecret/").permitAll().requestMatchers("/swagger-ui/", "/v3/api-docs/").permitAll()
            .anyRequest().authenticated();
        return http.build();*/
        
        http
        .authorizeRequests(authorizeRequests -> 
            authorizeRequests.anyRequest().permitAll()
        )
        .csrf().disable(); // Desactiva CSRF si es necesario en tu caso
    return http.build();
    }
}
