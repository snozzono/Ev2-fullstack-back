package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {

}