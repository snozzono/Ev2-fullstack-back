package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}