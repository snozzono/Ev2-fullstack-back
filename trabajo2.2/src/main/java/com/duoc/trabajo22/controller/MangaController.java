package com.duoc.trabajo22.controller;

import com.duoc.trabajo22.model.Manga;
import com.duoc.trabajo22.service.MangaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "Gestión de productos (mangas)")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    public List<Manga> getAll() {
        return mangaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener producto por ID")
    public ResponseEntity<Manga> getById(@PathVariable Integer id) {
        return mangaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo producto")
    public Manga create(@Valid @RequestBody Manga manga) {
        return mangaService.save(manga);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar producto")
    public ResponseEntity<Manga> update(@PathVariable Integer id, @Valid @RequestBody Manga manga) {
        Manga updated = mangaService.update(id, manga);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar producto")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        mangaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/inactivar")
    @Operation(summary = "Inactivar producto")
    public ResponseEntity<Manga> inactivar(@PathVariable Integer id) {
        Manga manga = mangaService.inactivar(id);
        if (manga != null) {
            return ResponseEntity.ok(manga);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/stock")
    @Operation(summary = "Actualizar stock de producto")
    public ResponseEntity<String> actualizarStock(@PathVariable Integer id, @RequestParam Integer cantidad) {
        boolean success = mangaService.actualizarStock(id, cantidad);
        if (success) {
            return ResponseEntity.ok("Stock actualizado correctamente");
        }
        return ResponseEntity.badRequest().body("No se pudo actualizar el stock");
    }
}
