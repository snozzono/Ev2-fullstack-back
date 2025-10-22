package com.duoc.trabajo22.service;

import com.duoc.trabajo22.model.Manga;
import com.duoc.trabajo22.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    public List<Manga> findAll() {
        return mangaRepository.findAll();
    }

    public Optional<Manga> findById(Integer id) {
        return mangaRepository.findById(id);
    }

    public Manga save(Manga manga) {
        if (manga.getFechaCreacion() == null) {
            manga.setFechaCreacion(Instant.now());
        }
        manga.setFechaActualizacion(Instant.now());
        if (manga.getActivo() == null) {
            manga.setActivo((byte) 1);
        }
        if (manga.getStock() == null) {
            manga.setStock(0);
        }
        return mangaRepository.save(manga);
    }

    public Manga update(Integer id, Manga manga) {
        Optional<Manga> existente = mangaRepository.findById(id);
        if (existente.isPresent()) {
            Manga m = existente.get();
            m.setTitulo(manga.getTitulo());
            m.setDescripcion(manga.getDescripcion());
            m.setPrecio(manga.getPrecio());
            m.setStock(manga.getStock());
            m.setImagenPortada(manga.getImagenPortada());
            m.setAutor(manga.getAutor());
            m.setFechaActualizacion(Instant.now());
            return mangaRepository.save(m);
        }
        return null;
    }

    public void deleteById(Integer id) {
        mangaRepository.deleteById(id);
    }

    public Manga inactivar(Integer id) {
        Optional<Manga> manga = mangaRepository.findById(id);
        if (manga.isPresent()) {
            Manga m = manga.get();
            m.setActivo((byte) 0);
            m.setFechaActualizacion(Instant.now());
            return mangaRepository.save(m);
        }
        return null;
    }

    public boolean actualizarStock(Integer id, Integer cantidad) {
        Optional<Manga> manga = mangaRepository.findById(id);
        if (manga.isPresent()) {
            Manga m = manga.get();
            int nuevoStock = m.getStock() + cantidad;
            if (nuevoStock < 0) {
                return false;
            }
            m.setStock(nuevoStock);
            m.setFechaActualizacion(Instant.now());
            mangaRepository.save(m);
            return true;
        }
        return false;
    }
}
