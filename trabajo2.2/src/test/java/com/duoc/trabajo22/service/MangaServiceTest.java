package com.duoc.trabajo22.service;

import com.duoc.trabajo22.model.Manga;
import com.duoc.trabajo22.repository.MangaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MangaServiceTest {

    @Mock
    private MangaRepository mangaRepository;

    @InjectMocks
    private MangaService mangaService;

    private Manga manga;

    @BeforeEach
    void setUp() {
        manga = new Manga();
        manga.setId(1);
        manga.setTitulo("One Piece Vol. 1");
        manga.setAutor("Eiichiro Oda");
        manga.setPrecio(new BigDecimal("9990"));
        manga.setStock(10);
        manga.setActivo((byte) 1);
    }

    @Test
    void testFindAll() {
        List<Manga> mangas = Arrays.asList(manga);
        when(mangaRepository.findAll()).thenReturn(mangas);

        List<Manga> result = mangaService.findAll();

        assertEquals(1, result.size());
        assertEquals("One Piece Vol. 1", result.get(0).getTitulo());
        verify(mangaRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        when(mangaRepository.save(any(Manga.class))).thenReturn(manga);

        Manga result = mangaService.save(manga);

        assertNotNull(result);
        assertEquals("One Piece Vol. 1", result.getTitulo());
        assertNotNull(result.getFechaCreacion());
        verify(mangaRepository, times(1)).save(any(Manga.class));
    }

    @Test
    void testActualizarStock_Success() {
        when(mangaRepository.findById(1)).thenReturn(Optional.of(manga));
        when(mangaRepository.save(any(Manga.class))).thenReturn(manga);

        boolean result = mangaService.actualizarStock(1, 5);

        assertTrue(result);
        assertEquals(15, manga.getStock());
        verify(mangaRepository, times(1)).save(manga);
    }

    @Test
    void testActualizarStock_StockInsuficiente() {
        when(mangaRepository.findById(1)).thenReturn(Optional.of(manga));

        boolean result = mangaService.actualizarStock(1, -20);

        assertFalse(result);
        verify(mangaRepository, never()).save(any(Manga.class));
    }
}
