package com.neoris.gestionproductos.infrastructure.domain.entity;

import jakarta.persistence.*;
/**
 * Esta es la clase de base de datos, con las anotaciones Spring estamos indicando el nombre de la tabla
 * en la base de datos, así como las columnas y la clase primaria y la estrategia que esta va a seguir.
 */
@Entity
@Table(name="PRODUCTOS")
public class InMemoryProductoRepositoyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PRODUCTO")
    private Integer id;
    @Column(name="DESCRIPCION")
    private String descripcion;
    @Column(name="CANTIDAD")
    private Integer cantidad;
    @Column(name="PRECIO")
    private Double precio;
    @Column(name="ANIO_FABRICA")
    private Integer anio;

    public InMemoryProductoRepositoyEntity(Integer id, String descripcion, Integer cantidad, Double precio, Integer anio) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.anio = anio;
    }

    public InMemoryProductoRepositoyEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
}
