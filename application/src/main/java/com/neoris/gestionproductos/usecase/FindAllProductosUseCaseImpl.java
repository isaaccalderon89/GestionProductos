package com.neoris.gestionproductos.usecase;

import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.repository.ProductoRepository;
import com.neoris.gestionproductos.usecases.FindAllProductosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllProductosUseCaseImpl implements FindAllProductosUseCase {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAllProductos() {
        return productoRepository.findAllProductos();
    }
}
