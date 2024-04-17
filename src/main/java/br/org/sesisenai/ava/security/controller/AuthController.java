package br.org.sesisenai.ava.security.controller;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.security.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/path")
public class AuthController {

//    private final AuthenticationManager authManager;
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(
            @RequestBody Usuario user,
            HttpServletRequest request,
            HttpServletResponse response
            ){
        Authentication authToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        AuthenticationManager authManager = getAuthManager();
        Authentication auth = authManager.authenticate(authToken);

        return ResponseEntity.ok("Foi yayyy");
    }

    private AuthenticationManager getAuthManager(){
        DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(authService);
        return new ProviderManager(provider);
    }

}
