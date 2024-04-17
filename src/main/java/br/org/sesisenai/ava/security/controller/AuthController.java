package br.org.sesisenai.ava.security.controller;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authManager;

    @GetMapping("/login")
    public ResponseEntity<String> authenticate(
            @RequestBody Usuario usuario,
            HttpServletRequest request,
            HttpServletResponse response
    ){

        Authentication authToken = new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());
        Authentication auth = authManager.authenticate(authToken);

        return ResponseEntity.ok("Foi yuhuuuuu");
    }

}
