package com.duoc.trabajo22.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "ordenCompra", nullable = false, length = 50)
    private String ordenCompra;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Size(max = 150)
    @NotNull
    @Column(name = "nombreEntrega", nullable = false, length = 150)
    private String nombreEntrega;

    @Size(max = 300)
    @NotNull
    @Column(name = "direccionEntrega", nullable = false, length = 300)
    private String direccionEntrega;

    @Size(max = 50)
    @NotNull
    @Column(name = "regionEntrega", nullable = false, length = 50)
    private String regionEntrega;

    @Size(max = 50)
    @NotNull
    @Column(name = "comunaEntrega", nullable = false, length = 50)
    private String comunaEntrega;

    @Size(max = 100)
    @NotNull
    @Column(name = "emailEntrega", nullable = false, length = 100)
    private String emailEntrega;

    @Size(max = 20)
    @Column(name = "telefonoEntrega", length = 20)
    private String telefonoEntrega;

    @ColumnDefault("current_timestamp()")
    @Column(name = "fechaPedido")
    private Instant fechaPedido;

    @ColumnDefault("'pendiente'")
    @Lob
    @Column(name = "estadoPedido")
    private String estadoPedido;

    @ColumnDefault("'pendiente'")
    @Lob
    @Column(name = "estadoPago")
    private String estadoPago;

    @NotNull
    @Column(name = "subtotal", nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ColumnDefault("0.00")
    @Column(name = "costoEnvio", precision = 10, scale = 2)
    private BigDecimal costoEnvio;

    @NotNull
    @Column(name = "total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @ColumnDefault("'webpay'")
    @Lob
    @Column(name = "metodoPago")
    private String metodoPago;

    @Size(max = 100)
    @Column(name = "tokenWebpay", length = 100)
    private String tokenWebpay;

    @Lob
    @Column(name = "notas")
    private String notas;

}