package com.duoc.trabajo22.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private String tipoUsuario;
    private String mensaje;
}
