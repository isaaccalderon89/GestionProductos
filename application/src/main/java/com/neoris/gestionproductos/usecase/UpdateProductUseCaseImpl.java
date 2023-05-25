package com.neoris.gestionproductos.usecase;

import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.repository.ProductoRepository;
import com.neoris.gestionproductos.usecases.UpdateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public Producto updateProducto(Producto producto) {
        return productoRepository.updateProducto(producto);
    }
}
