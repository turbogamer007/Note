package com.example.Note.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // component for class
@EnableWebSecurity
public class SecurityConfig {

    @Bean// bean for method
    //builder design pattern
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST,"/api/user/**").authenticated()
                        .requestMatchers(HttpMethod.GET,"/api/user/**").authenticated()
                        .requestMatchers(HttpMethod.POST,"/api/note/**").authenticated()
                        .requestMatchers(HttpMethod.GET,"/api/note/**").authenticated()
                        .anyRequest().denyAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
