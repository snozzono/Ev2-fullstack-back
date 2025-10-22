package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}