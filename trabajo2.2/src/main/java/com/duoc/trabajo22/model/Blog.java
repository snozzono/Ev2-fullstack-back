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
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 200)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 300)
    @Column(name = "descripcionCorta", length = 300)
    private String descripcionCorta;

    @NotNull
    @Lob
    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaPublicacion")
    private Instant fechaPublicacion;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Byte activo;

}