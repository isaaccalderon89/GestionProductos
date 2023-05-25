package com.neoris.gestionproductos.infrastructure.controller;

import com.neoris.gestionproductos.entities.Producto;
import com.neoris.gestionproductos.usecases.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador REST para la gestión de productos
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private FindAllProductosUseCase findAllProductosUseCase;
    private CreateProductUseCase createProductUseCase;
    private UpdateProductUseCase updateProductUseCase;
    private DeleteProductUseCase deleteProductUseCase;
    private FindByStockUseCase findByStockUseCase;

    public ProductoController(FindAllProductosUseCase findAllProductosUseCase, CreateProductUseCase createProductUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase, FindByStockUseCase findByStockUseCase) {
        this.findAllProductosUseCase = findAllProductosUseCase;
        this.createProductUseCase = createProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.findByStockUseCase = findByStockUseCase;
    }
    /**
     * Recupera todos los productos.
     *
     * @return ResponseEntity con una lista de productos en formato JSON si la solicitud es exitosa.
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity.ok(findAllProductosUseCase.findAllProductos());
    }
    /**
     * Crea un nuevo producto.
     *
     * @param producto El objeto Producto enviado en el cuerpo de la solicitud.
     * @return ResponseEntity con el producto creado en formato JSON si la solicitud es exitosa y el código de estado HTTP 201 (CREATED).
     *         Si ocurre una excepción, se devuelve una respuesta con el código de estado HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        try{
            Producto newProducto = createProductUseCase.createProduct(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProducto);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    /**
     * Actualiza un producto existente.
     *
     * @param producto El objeto Producto enviado en el cuerpo de la solicitud.
     * @return ResponseEntity con el producto actualizado en formato JSON si la solicitud es exitosa y el código de estado HTTP 201 (CREATED).
     *         Si ocurre una excepción, se devuelve una respuesta con el código de estado HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
      try{
          Producto newProducto = updateProductUseCase.updateProducto(producto);
          return ResponseEntity.status(HttpStatus.CREATED).body(newProducto);
      } catch (Exception e){
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    }
    /**
     * Elimina un producto existente por su ID.
     *
     * @param id El ID del producto a eliminar.
     * @return ResponseEntity sin contenido y código de estado HTTP 204 (NO_CONTENT) si la eliminación es exitosa.
     *         Si el producto no se encuentra, se devuelve un ResponseEntity con el código de estado HTTP 404 (NOT_FOUND).
     */
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        if(deleteProductUseCase.deleteProducto(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Busca productos por cantidad de stock.
     *
     * @param stock La cantidad de stock por la cual buscar los productos.
     * @return ResponseEntity con una lista de productos en formato JSON si la búsqueda es exitosa.
     *         Si ocurre una excepción, se devuelve una respuesta con el código de estado HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @GetMapping(value = "/cantidad/{stock}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> findByCantidad(@PathVariable Integer stock){
        try{
            List<Producto> newProductos = findByStockUseCase.findByStock(stock);
            return ResponseEntity.ok(newProductos);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
