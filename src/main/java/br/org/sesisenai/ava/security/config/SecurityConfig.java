package br.org.sesisenai.ava.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(
            authorizationManager ->
                    authorizationManager
                            .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/instrutor").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/cursos").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/cursos/{id}").permitAll()

//                            .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api").permitAll()

                            .anyRequest().authenticated()
        );

        http.logout(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);

        http.sessionManagement( sessionConfigurer -> sessionConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }

}
