package com.envioproductomascota.demo.modelos;

public class Producto {
    private Long idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private int ValorProducto;

    public Producto() {
    }

    public Producto(Long idProducto, String nombreProducto, String descripcionProducto, int valorProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        ValorProducto = valorProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getValorProducto() {
        return ValorProducto;
    }

    public void setValorProducto(int valorProducto) {
        ValorProducto = valorProducto;
    }

}
