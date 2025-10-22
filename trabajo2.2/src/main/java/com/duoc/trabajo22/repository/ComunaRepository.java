package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
}