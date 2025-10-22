package com.duoc.trabajo22.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "mensajecontacto")
public class Mensajecontacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 500)
    @NotNull
    @Column(name = "comentario", nullable = false, length = 500)
    private String comentario;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaEnvio")
    private Instant fechaEnvio;

    @ColumnDefault("0")
    @Column(name = "leido")
    private Byte leido;

    @ColumnDefault("0")
    @Column(name = "respondido")
    private Byte respondido;

}