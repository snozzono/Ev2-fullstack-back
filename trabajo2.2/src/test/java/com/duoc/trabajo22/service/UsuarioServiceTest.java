package com.duoc.trabajo22.service;

import com.duoc.trabajo22.model.Usuario;
import com.duoc.trabajo22.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("Juan");
        usuario.setApellidos("Pérez");
        usuario.setEmail("juan@test.com");
        usuario.setPassword("123456");
        usuario.setTipoUsuario("cliente");
        usuario.setActivo((byte) 1);
    }

    @Test
    void testSave() {
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioService.save(usuario);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals("cliente", result.getTipoUsuario());
        assertNotNull(result.getFechaRegistro());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }

    @Test
    void testInactivar() {
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario result = usuarioService.inactivar(1);

        assertNotNull(result);
        assertEquals((byte) 0, result.getActivo());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void testFindByEmail() {
        when(usuarioRepository.findByEmail("juan@test.com")).thenReturn(Optional.of(usuario));

        Optional<Usuario> result = usuarioService.findByEmail("juan@test.com");

        assertTrue(result.isPresent());
        assertEquals("juan@test.com", result.get().getEmail());
        verify(usuarioRepository, times(1)).findByEmail("juan@test.com");
    }
}
