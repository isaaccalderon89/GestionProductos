package com.neoris.gestionproductos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * Aqui tenemos la clase de negocio con anotaciones lombok para obtener el constructor con parametros,
 * constructor sin parametros, getters and setters.
 * @Author Isaac Calderón
 *
 */
public class Producto {

    private Integer id;
    private String descripcion;
    private Integer cantidad;
    private Double precio;
    private Integer anio;

}
