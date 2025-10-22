package com.duoc.trabajo22.service;

import com.duoc.trabajo22.model.Usuario;
import com.duoc.trabajo22.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        if (usuario.getFechaRegistro() == null) {
            usuario.setFechaRegistro(Instant.now());
        }
        if (usuario.getActivo() == null) {
            usuario.setActivo((byte) 1);
        }
        if (usuario.getTipoUsuario() == null) {
            usuario.setTipoUsuario("cliente");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Integer id, Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.findById(id);
        if (existente.isPresent()) {
            Usuario u = existente.get();
            u.setNombre(usuario.getNombre());
            u.setApellidos(usuario.getApellidos());
            u.setEmail(usuario.getEmail());
            if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
                u.setPassword(usuario.getPassword());
            }
            u.setDireccion(usuario.getDireccion());
            u.setTelefono(usuario.getTelefono());
            u.setFechaNacimiento(usuario.getFechaNacimiento());
            u.setTipoUsuario(usuario.getTipoUsuario());
            return usuarioRepository.save(u);
        }
        return null;
    }

    public void deleteById(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario inactivar(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario u = usuario.get();
            u.setActivo((byte) 0);
            return usuarioRepository.save(u);
        }
        return null;
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
