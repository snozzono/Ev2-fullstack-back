package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer> {
}