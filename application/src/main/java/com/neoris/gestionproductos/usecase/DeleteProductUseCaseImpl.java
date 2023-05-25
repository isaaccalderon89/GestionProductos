package com.neoris.gestionproductos.usecase;

import com.neoris.gestionproductos.repository.ProductoRepository;
import com.neoris.gestionproductos.usecases.DeleteProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public Boolean deleteProducto(Integer id) {
        return productoRepository.deleteProducto(id);
    }
}
