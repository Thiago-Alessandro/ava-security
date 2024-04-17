package br.org.sesisenai.ava.repository;

import br.org.sesisenai.ava.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUserDetailsEntity_Username(String username);
    //no caso o "username" é o email do usuario pois "precisa" ser unico

}
