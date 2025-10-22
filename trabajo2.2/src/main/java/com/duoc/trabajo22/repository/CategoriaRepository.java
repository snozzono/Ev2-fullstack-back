package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}