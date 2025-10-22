package com.duoc.trabajo22.repository;

import com.duoc.trabajo22.model.Manga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer> {

    /**
     * Buscar por título o título original (case insensitive)
     */
    Page<Manga> findByTituloContainingIgnoreCaseOrTituloOriginalContainingIgnoreCase(
            String titulo, String tituloOriginal, Pageable pageable);

    /**
     * Buscar por autor (case insensitive)
     */
    Page<Manga> findByAutorContainingIgnoreCase(String autor, Pageable pageable);

    /**
     * Buscar por categoría
     */
    @Query("SELECT m FROM Manga m JOIN m.categorias c WHERE LOWER(c.nombre) = LOWER(:categoriaNombre)")
    Page<Manga> findByCategoriasNombreIgnoreCase(@Param("categoriaNombre") String categoriaNombre, Pageable pageable);

    /**
     * Buscar mangas con stock disponible y activos
     */
    Page<Manga> findByStockGreaterThanAndActivoEquals(Integer stock, Byte activo, Pageable pageable);

    /**
     * Buscar mangas con stock crítico
     */
    @Query("SELECT m FROM Manga m WHERE m.stock <= m.stockCritico AND m.stock > 0 AND m.activo = 1")
    List<Manga> findMangasWithCriticalStock();

    /**
     * Verificar si existe un manga con el código
     */
    boolean existsByCodigo(String codigo);

    /**
     * Buscar por código
     */
    Optional<Manga> findByCodigo(String codigo);

    /**
     * Buscar por ISBN
     */
    Optional<Manga> findByIsbn(String isbn);

    /**
     * Buscar por editorial
     */
    @Query("SELECT m FROM Manga m WHERE m.editorial.id = :editorialId")
    Page<Manga> findByEditorialId(@Param("editorialId") Integer editorialId, Pageable pageable);

    /**
     * Buscar por año de publicación
     */
    Page<Manga> findByAñoPublicacion(Integer año, Pageable pageable);

    /**
     * Buscar por estado de serie
     */
    Page<Manga> findByEstadoSerie(String estadoSerie, Pageable pageable);

    /**
     * Buscar por idioma
     */
    Page<Manga> findByIdioma(String idioma, Pageable pageable);

    /**
     * Buscar mangas activos
     */
    Page<Manga> findByActivo(Byte activo, Pageable pageable);

    /**
     * Búsqueda avanzada con múltiples filtros
     */
    @Query("SELECT DISTINCT m FROM Manga m LEFT JOIN m.categorias c " +
            "WHERE (:titulo IS NULL OR LOWER(m.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))) " +
            "AND (:autor IS NULL OR LOWER(m.autor) LIKE LOWER(CONCAT('%', :autor, '%'))) " +
            "AND (:categoria IS NULL OR LOWER(c.nombre) = LOWER(:categoria)) " +
            "AND (:minStock IS NULL OR m.stock >= :minStock) " +
            "AND m.activo = 1")
    Page<Manga> searchMangasWithFilters(
            @Param("titulo") String titulo,
            @Param("autor") String autor,
            @Param("categoria") String categoria,
            @Param("minStock") Integer minStock,
            Pageable pageable);

    /**
     * Obtener mangas más vendidos (basado en detalles de pedidos)
     */
    @Query("SELECT m FROM Manga m " +
            "LEFT JOIN m.detallepedidos dp " +
            "WHERE m.activo = 1 " +
            "GROUP BY m.id " +
            "ORDER BY SUM(dp.cantidad) DESC")
    List<Manga> findTopSellingMangas(Pageable pageable);

    /**
     * Obtener mangas recientes
     */
    @Query("SELECT m FROM Manga m WHERE m.activo = 1 ORDER BY m.fechaCreacion DESC")
    List<Manga> findRecentMangas(Pageable pageable);

    /**
     * Contar mangas por categoría
     */
    @Query("SELECT COUNT(m) FROM Manga m JOIN m.categorias c WHERE c.id = :categoriaId AND m.activo = 1")
    Long countMangasByCategoria(@Param("categoriaId") Integer categoriaId);

    /**
     * Obtener mangas con precio en rango
     */
    @Query("SELECT m FROM Manga m WHERE m.precio BETWEEN :minPrecio AND :maxPrecio AND m.activo = 1")
    Page<Manga> findByPrecioRange(
            @Param("minPrecio") java.math.BigDecimal minPrecio,
            @Param("maxPrecio") java.math.BigDecimal maxPrecio,
            Pageable pageable);

    /**
     * Buscar mangas sin stock
     */
    @Query("SELECT m FROM Manga m WHERE m.stock = 0 AND m.activo = 1")
    List<Manga> findMangasOutOfStock();

    /**
     * Obtener estadísticas de stock
     */
    @Query("SELECT " +
            "COUNT(m) as total, " +
            "SUM(CASE WHEN m.stock > 0 THEN 1 ELSE 0 END) as disponibles, " +
            "SUM(CASE WHEN m.stock = 0 THEN 1 ELSE 0 END) as agotados, " +
            "SUM(CASE WHEN m.stock <= m.stockCritico AND m.stock > 0 THEN 1 ELSE 0 END) as criticos " +
            "FROM Manga m WHERE m.activo = 1")
    Object getStockStatistics();

    /**
     * Buscar mangas por múltiples categorías
     */
    @Query("SELECT DISTINCT m FROM Manga m JOIN m.categorias c WHERE c.id = :categoriaId")
    List<Manga> findMangasByCategoria(@Param("categoriaId") Integer categoriaId);
}