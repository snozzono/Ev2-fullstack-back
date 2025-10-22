package com.duoc.trabajo22.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "manga")
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Size(max = 200)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 200)
    @Column(name = "tituloOriginal", length = 200)
    private String tituloOriginal;

    @Size(max = 100)
    @NotNull
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Size(max = 100)
    @Column(name = "ilustrador", length = 100)
    private String ilustrador;

    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "`añoPublicacion`")
    private Integer añoPublicacion;

    @Size(max = 20)
    @Column(name = "isbn", length = 20)
    private String isbn;

    @Column(name = "paginas")
    private Integer paginas;

    @Size(max = 20)
    @ColumnDefault("'Español'")
    @Column(name = "idioma", length = 20)
    private String idioma;

    @ColumnDefault("'en_curso'")
    @Lob
    @Column(name = "estadoSerie")
    private String estadoSerie;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    @NotNull
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @ColumnDefault("0")
    @Column(name = "stock")
    private Integer stock;

    @ColumnDefault("5")
    @Column(name = "stockCritico")
    private Integer stockCritico;

    @Size(max = 255)
    @Column(name = "imagenPortada")
    private String imagenPortada;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaCreacion")
    private Instant fechaCreacion;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaActualizacion")
    private Instant fechaActualizacion;

    @ColumnDefault("1")
    @Column(name = "activo")
    private Byte activo;

    @OneToMany
    @JoinColumn(name = "manga_id")
    private Set<Carrito> carritos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn(name = "manga_id")
    private Set<Comentario> comentarios = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn(name = "manga_id")
    private Set<Detallepedido> detallepedidos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn(name = "manga_id")
    private Set<Favorito> favoritos = new LinkedHashSet<>();

    @ManyToMany
    private Set<Categoria> categorias = new LinkedHashSet<>();

}