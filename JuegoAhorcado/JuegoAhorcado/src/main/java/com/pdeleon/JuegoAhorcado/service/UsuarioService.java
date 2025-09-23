package com.pdeleon.JuegoAhorcado.service;

import com.pdeleon.JuegoAhorcado.model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}
