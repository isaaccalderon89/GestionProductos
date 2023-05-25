package com.neoris.gestionproductos.infrastructure.repository.jpa;

import com.neoris.gestionproductos.infrastructure.domain.entity.InMemoryProductoRepositoyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Repositorio de JPA para la entidad Producto.
 */
@Repository
public interface ProductoJpaRepository extends JpaRepository<InMemoryProductoRepositoyEntity,Integer> {
    /**
     * Busca entidades de InMemoryProductoRepositoyEntity por cantidad de stock.
     *
     * @param stock La cantidad de stock por la cual buscar las entidades.
     * @return Una lista de entidades de InMemoryProductoRepositoyEntity que cumplen con el criterio de búsqueda.
     */
    @Query("SELECT c FROM InMemoryProductoRepositoyEntity c WHERE c.cantidad <= :stock")
    List<InMemoryProductoRepositoyEntity> findByStock(@Param("stock")Integer stock);
}
