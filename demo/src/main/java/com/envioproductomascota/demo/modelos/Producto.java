package com.envioproductomascota.demo.modelos;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @NotBlank(message = "Descripcion es obligatorio")
    @Size(min = 30, max = 200, message = "La descripción debe tener entre 30 y 200 caracteres")
    @Column(name = "descripcionProducto")
    private String descripcionProducto;
    @NotNull(message = "El valor del producto es obligatorio")
    @Column(name = "ValorProducto")
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
