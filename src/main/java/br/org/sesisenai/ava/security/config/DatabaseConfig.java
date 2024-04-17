package br.org.sesisenai.ava.security.config;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
public class DatabaseConfig {

    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init(){
        createUserTest();
    }

    public Usuario createUserTest(){
        Usuario user = new Usuario();
        user.setSenha(new BCryptPasswordEncoder().encode("thiago123"));
        user.setEmail("thiago");
        return usuarioRepository.save(user);
    }

}
