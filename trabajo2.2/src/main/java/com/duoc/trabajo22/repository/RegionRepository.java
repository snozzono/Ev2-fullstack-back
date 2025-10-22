package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}