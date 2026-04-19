package com.envioproductomascota.demo.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table
@Entity(name = "envio")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnvio;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @NotBlank(message = "La dirección de envío es obligatoria")
    @Size(min = 10, max = 200, message = "La dirección de envío debe tener entre 10 y 200 caracteres")
    @Column(name = "direccion_envio")
    private String direccionEnvio;
    @NotBlank(message = "El estado de envío es obligatorio")
    @Column(name = "estado_envio")
    private String estadoEnvio;
    @NotBlank(message = "La ubicación es obligatoria")
    @Size(min = 10, max = 200, message = "La ubicación debe tener entre 30 y 200 caracteres")
    @Column(name = "ubicacion")
    private String ubicacion;
    @ManyToOne
    @NotNull(message = "El producto es obligatorio")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Envio() {
    }

    public Envio(Long idEnvio, String nombreCliente, String direccionEnvio, String estadoEnvio, String ubicacion,
            Producto producto) {
        this.idEnvio = idEnvio;
        this.nombreCliente = nombreCliente;
        this.direccionEnvio = direccionEnvio;
        this.ubicacion = ubicacion;
        this.estadoEnvio = estadoEnvio;
        this.producto = producto;
    }

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}
