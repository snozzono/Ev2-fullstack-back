package com.duoc.trabajo22.controller;

import com.duoc.trabajo22.model.Blog;
import com.duoc.trabajo22.model.Categoria;
import com.duoc.trabajo22.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/blogs")
class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blog) {
        Blog nuevoBlog = blogService.crear(blog);
        return ResponseEntity.ok(nuevoBlog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Blog blog = blogService.obtenerPorId(id);
        return ResponseEntity.ok(blog);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blog = blogService.obtenerTodos();
        return ResponseEntity.ok(blog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        blogService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> update(@PathVariable int id, @RequestBody Blog blog) {
        Blog updateBlog = blogService.obtenerPorId(id);
        return ResponseEntity.ok(updateBlog);
    }

}
