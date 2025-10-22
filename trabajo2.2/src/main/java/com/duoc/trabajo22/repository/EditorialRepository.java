package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
}