package com.neoris.gestionproductos.infrastructure.repository;

import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.infrastructure.domain.entity.InMemoryProductoRepositoyEntity;
import com.neoris.gestionproductos.infrastructure.mapper.inmemory.InMemoryProductoEntityMapper;
import com.neoris.gestionproductos.infrastructure.repository.jpa.ProductoJpaRepository;
import com.neoris.gestionproductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoEntityRepository implements ProductoRepository {

    @Autowired
    private ProductoJpaRepository productoJpaRepository;
    @Override
    public List<Producto> findAllProductos() {
        List<InMemoryProductoRepositoyEntity> result = productoJpaRepository.findAll();
        return InMemoryProductoEntityMapper.INSTANCE.toDomainEntityList(result);
    }

    @Override
    public Producto createProduct(Producto producto) {
        InMemoryProductoRepositoyEntity result = productoJpaRepository.save(InMemoryProductoEntityMapper.INSTANCE.fromDomainEntity(producto));
        return InMemoryProductoEntityMapper.INSTANCE.toDomainEntity(result);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        InMemoryProductoRepositoyEntity result = productoJpaRepository.save(InMemoryProductoEntityMapper.INSTANCE.fromDomainEntity(producto));
        return InMemoryProductoEntityMapper.INSTANCE.toDomainEntity(result);
    }

    @Override
    public Boolean deleteProducto(Integer id) {
        if(productoJpaRepository.existsById(id)){
            productoJpaRepository.deleteById(id);
            return true;
        }
        return null;
    }

    @Override
    public List<Producto> findByStock(Integer stock) {
        List<InMemoryProductoRepositoyEntity> result = productoJpaRepository.findByStock(stock);
        return InMemoryProductoEntityMapper.INSTANCE.toDomainEntityList(result);
    }
}
