package com.neoris.gestionproductos.usecase;

import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.repository.ProductoRepository;
import com.neoris.gestionproductos.usecases.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public Producto createProduct(Producto producto) {
        return productoRepository.createProduct(producto);
    }
}
