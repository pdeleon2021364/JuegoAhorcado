package com.pdeleon.JuegoAhorcado.repository;

import com.pdeleon.JuegoAhorcado.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreo(String correo);
}
