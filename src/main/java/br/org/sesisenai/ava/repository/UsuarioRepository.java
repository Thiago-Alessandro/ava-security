package br.org.sesisenai.ava.repository;

import br.org.sesisenai.ava.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
    //tem que ser o email do usuario (getUsername da interface UserDetails retorna o email do usuario)

}
