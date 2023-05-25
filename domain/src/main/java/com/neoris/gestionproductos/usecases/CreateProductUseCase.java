package com.neoris.gestionproductos.usecases;

import com.neoris.gestionproductos.entities.Producto;

public interface CreateProductUseCase {
    Producto createProduct(Producto producto);
}
