package br.org.sesisenai.ava.security.config;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import br.org.sesisenai.ava.security.model.entity.UserDetailsEntity;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@AllArgsConstructor
public class DatabaseConfig {

    private final UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init(){
        createUserTest();
    }

    private void createUserTest(){
        try{
            usuarioRepository.findByUserDetailsEntity_Username("luka").get();
        }catch (Exception e){
            Usuario user = new Usuario();
            user.setNome("luka");
            user.setUserDetailsEntity(
                    UserDetailsEntity.builder()
                            .username("luka")
                            .password(new BCryptPasswordEncoder().encode("luka123"))
                            .authorities(List.of())
                            .isEnabled(true)
                            .isAccountNonLocked(true)
                            .isCredentialsNonExpired(true)
                            .isAccountNonExpired(true)
                            .build()
            );
            usuarioRepository.save(user);
        }
    }
}
