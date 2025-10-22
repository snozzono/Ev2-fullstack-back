package com.duoc.trabajo22.service;

import com.duoc.trabajo22.model.Blog;
import com.duoc.trabajo22.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog crear(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog obtenerPorId(Integer id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));
    }

    public List<Blog> obtenerTodos() {
        return (List<Blog>) blogRepository.findAll();
    }

    public void eliminar(int id){
        if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog no encontrado");
        }
        blogRepository.deleteById(id);
    }

    public Blog actualizar(int id, Blog actualizado) {
        Blog existente = obtenerPorId(id);
        existente.setTitulo(actualizado.getTitulo());
        return blogRepository.save(existente);
    }

}
