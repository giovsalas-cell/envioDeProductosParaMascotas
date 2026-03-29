package com.envioproductomascota.demo.modelos;

public class Envio {
    private Long idEnvio;
    private String nombreCliente;
    private String direccionEnvio;
    private String estadoEnvio;
    private String ubicacion;
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
