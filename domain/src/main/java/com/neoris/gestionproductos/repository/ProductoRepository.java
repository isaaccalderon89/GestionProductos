package com.neoris.gestionproductos.repository;

import com.neoris.gestionproductos.entities.Producto;

import java.util.List;

public interface ProductoRepository {
    /**
     * Metodo que devuelve una lista con todos los productos
     * @return
     */
    List<Producto> findAllProductos();
    /**
     * Metodo que permite crear un producto
     * @param producto
     * @return el producto creado
     */
    Producto createProduct(Producto producto);
    /**
     * Metodo que permite modificar un producto
     * @param producto
     * @return el producto modificado
     */
    Producto updateProducto(Producto producto);
    /**
     * Metodo para eliminar un producto
     * @param id le pasamos el id de un producto que exita y queramos eliminar
     * @return un <b>true</b> si el producto ha sido elimado, <b>false</b> si el producto no ha sido elimando
     */
    Boolean deleteProducto(Integer id);
    /**
     * Metodo que devuelve una lista productos que tengan un stock igual o menos al numero introducido
     * @param stock stock requerido
     * @return lista de productos
     */
    List<Producto> findByStock(Integer stock);
}
