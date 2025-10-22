package com.duoc.trabajo22.controller;

import com.duoc.trabajo22.dto.LoginRequest;
import com.duoc.trabajo22.dto.LoginResponse;
import com.duoc.trabajo22.model.Usuario;
import com.duoc.trabajo22.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticación", description = "Endpoints de autenticación")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    @Operation(summary = "Login de usuario")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<Usuario> usuario = usuarioService.findByEmail(loginRequest.getEmail());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(401).body(
                new LoginResponse(null, null, null, null, null, "Usuario no encontrado")
            );
        }

        Usuario u = usuario.get();

        if (!u.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body(
                new LoginResponse(null, null, null, null, null, "Contraseña incorrecta")
            );
        }

        if (u.getActivo() == 0) {
            return ResponseEntity.status(403).body(
                new LoginResponse(null, null, null, null, null, "Usuario inactivo")
            );
        }

        return ResponseEntity.ok(new LoginResponse(
            u.getId(),
            u.getNombre(),
            u.getApellidos(),
            u.getEmail(),
            u.getTipoUsuario(),
            "Login exitoso"
        ));
    }

    @GetMapping("/validar-admin/{id}")
    @Operation(summary = "Validar si usuario es administrador")
    public ResponseEntity<Boolean> validarAdmin(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            boolean esAdmin = "super-admin".equals(usuario.get().getTipoUsuario()) ||
                             "vendedor".equals(usuario.get().getTipoUsuario());
            return ResponseEntity.ok(esAdmin);
        }
        return ResponseEntity.notFound().build();
    }
}
