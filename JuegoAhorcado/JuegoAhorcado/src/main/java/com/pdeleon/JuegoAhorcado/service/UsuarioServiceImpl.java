package com.pdeleon.JuegoAhorcado.service;

import com.pdeleon.JuegoAhorcado.model.Usuario;
import com.pdeleon.JuegoAhorcado.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final List<String> dominiosPermitidos = Arrays.asList(
            "@gmail.com",
            "@outlook.com",
            "@hotmail.com",
            "@yahoo.com",
            "@icloud.com"
    );

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        validarId(id);
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró un usuario con el ID: " + id));
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        validarCampos(usuario);
        validarCorreo(usuario.getCorreo());

        if (usuarioRepository.findByCorreo(usuario.getCorreo()) != null) {
            throw new RuntimeException("El correo ingresado ya está en uso");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        validarId(id);
        validarCampos(usuario);
        validarCorreo(usuario.getCorreo());

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró un usuario con el ID: " + id));

        // Si existe otro usuario con el mismo correo y distinto id → error
        Usuario otro = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (otro != null && !otro.getCodigoUsuario().equals(id)) {
            throw new RuntimeException("El correo ya pertenece a otro usuario");
        }

        existente.setNombre(usuario.getNombre());
        existente.setApellido(usuario.getApellido());
        existente.setCorreo(usuario.getCorreo());
        existente.setContrasena(usuario.getContrasena());

        return usuarioRepository.save(existente);
    }

    @Override
    public void deleteUsuario(Integer id) {
        validarId(id);
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, el usuario con ID " + id + " no existe");
        }
        usuarioRepository.deleteById(id);
    }

    // ---------------- MÉTODOS AUXILIARES ---------------- //

    private void validarCampos(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre no puede estar vacío");
        }
        if (usuario.getApellido() == null || usuario.getApellido().trim().isEmpty()) {
            throw new RuntimeException("El apellido no puede estar vacío");
        }
        if (usuario.getCorreo() == null || usuario.getCorreo().trim().isEmpty()) {
            throw new RuntimeException("El correo no puede estar vacío");
        }
    }

    private void validarCorreo(String correo) {
        String correoLower = correo.toLowerCase();
        boolean dominioValido = dominiosPermitidos.stream()
                .anyMatch(correoLower::endsWith);

        if (!dominioValido) {
            throw new RuntimeException(
                    "El correo debe terminar en uno de los siguientes dominios: " + dominiosPermitidos
            );
        }
    }

    private void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("El ID debe ser un número positivo y no nulo");
        }
    }
}
