package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Detallepedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DetallepedidoRepository extends JpaRepository<Detallepedido, Integer> {
}