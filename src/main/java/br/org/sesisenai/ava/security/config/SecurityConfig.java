package br.org.sesisenai.ava.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

//    private final SecurityContextRepository securityContextRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                authorizationManager ->
                        authorizationManager
                                .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/instrutor").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/cursos").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/cursos/{id}").permitAll()

                                .anyRequest().authenticated()
        );

//        http.securityContext( contextConfigurer -> contextConfigurer.securityContextRepository(securityContextRepository));
        http.sessionManagement(sessionConfigurer -> sessionConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.csrf(AbstractHttpConfigurer::disable);
        http.logout(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);

        return http.build();
    }


}
