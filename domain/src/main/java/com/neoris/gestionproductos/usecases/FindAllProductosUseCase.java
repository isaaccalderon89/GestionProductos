package com.neoris.gestionproductos.usecases;

import com.neoris.gestionproductos.entities.Producto;

import java.util.List;

public interface FindAllProductosUseCase {

    List<Producto> findAllProductos();
}
