package com.neoris.gestionproductos.usecases;

import com.neoris.gestionproductos.entities.Producto;

import java.util.List;

public interface FindByStockUseCase {
    List<Producto> findByStock(Integer stock);
}
