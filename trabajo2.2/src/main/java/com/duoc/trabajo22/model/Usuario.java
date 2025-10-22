package com.duoc.trabajo22.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 9)
    @NotNull
    @Column(name = "run", nullable = false, length = 9)
    private String run;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @ColumnDefault("'cliente'")
    @Lob
    @Column(name = "tipoUsuario")
    private String tipoUsuario;

    @Size(max = 300)
    @NotNull
    @Column(name = "direccion", nullable = false, length = 300)
    private String direccion;

    @Size(max = 20)
    @Column(name = "telefono", length = 20)
    private String telefono;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaRegistro")
    private Instant fechaRegistro;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Byte activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "createdBy")
    private Usuario createdBy;

}