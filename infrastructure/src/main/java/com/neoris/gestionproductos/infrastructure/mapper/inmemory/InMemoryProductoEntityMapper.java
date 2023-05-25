package com.neoris.gestionproductos.infrastructure.mapper.inmemory;

import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.infrastructure.domain.entity.InMemoryProductoRepositoyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
/**
 * Interfaz de mapeo en memoria para la entidad de Evento.
 * Extiende {@Link InMemoryEntityMapper} para porporcionar métodos de mapeo especificos para la entidad del producto
 */
@Mapper
public interface InMemoryProductoEntityMapper extends InMemoryEntityMapper<Producto, InMemoryProductoRepositoyEntity>{

    InMemoryProductoEntityMapper INSTANCE = Mappers.getMapper(InMemoryProductoEntityMapper.class);

    /**
     * Convierte una entidad de InMemoryProductoRepositoyEntity a un objeto Producto de dominio.
     *
     * @param inmemoryEntity La entidad de InMemoryProductoRepositoyEntity a convertir.
     * @return El objeto Producto resultante de la conversión.
     */
    @Mapping(source="id", target= "id")
    Producto toDomainEntity(InMemoryProductoRepositoyEntity inmemoryEntity);
}
