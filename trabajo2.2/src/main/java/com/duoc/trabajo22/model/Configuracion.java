package com.duoc.trabajo22.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "configuracion")
public class Configuracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "clave", nullable = false, length = 50)
    private String clave;

    @Lob
    @Column(name = "valor")
    private String valor;

    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;

}