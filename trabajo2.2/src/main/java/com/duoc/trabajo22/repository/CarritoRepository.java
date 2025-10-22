package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
}