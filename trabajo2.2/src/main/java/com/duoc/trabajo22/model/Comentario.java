package com.duoc.trabajo22.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "manga_id", nullable = false)
    private Manga manga;

    @NotNull
    @Lob
    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "calificacion")
    private Integer calificacion;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaComentario")
    private Instant fechaComentario;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Byte activo;

}