package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}