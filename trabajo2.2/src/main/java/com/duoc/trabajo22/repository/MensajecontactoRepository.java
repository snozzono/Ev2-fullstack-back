package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Mensajecontacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface MensajecontactoRepository extends JpaRepository<Mensajecontacto, Integer> {
}