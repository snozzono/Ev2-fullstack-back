package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}