package com.envioproductomascota.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.envioproductomascota.demo.Servicio.Servicio;
import com.envioproductomascota.demo.modelos.Envio;
import com.envioproductomascota.demo.modelos.Producto;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class controller {

    @Autowired
    private Servicio servicio;

    @GetMapping("/")
    public List<Envio> listarEnvio() {
        return servicio.verEnvios();

    }

    @PostMapping("/envios/crear-envio")
    public Envio crearEnvio(@Valid @RequestBody Envio envio) {
        return servicio.crearEnvio(envio);
    }

    @PutMapping("/envios/actualiza-envio/{id}/{estadoEnvio}")
    public Envio actualizaEnvio(@PathVariable Long id, @RequestParam String estadoEnvio) {
        return servicio.actualizEnvio(id, estadoEnvio);
    }

    @PostMapping
    public Producto postMethodName(@RequestBody Producto producto) {

        return servicio.crearProducto(producto);
    }

    @PutMapping("/envios/actualiza-ubicacion/{id}/{ubicacion}")
    public Envio actualizarubicacion(@PathVariable int id, @PathVariable String ubicacion) {
        return servicio.actualizarUbicacion(id, ubicacion);
    }

    @GetMapping("/envio/buscar-envio/{id}")
    public Envio buscarEnvio(@PathVariable Long id) {
        return servicio.buscarEnvio(id);
    }

    @GetMapping("/envio/obtener-ubicacion/{idEnvio}")
    public Envio obtenerInformcion(@PathVariable Long idEnvio) {

        return servicio.obtenerUbicacion(idEnvio);
    }

    @DeleteMapping("/envios/eliminar-envio/{id}")
    public void eliminarEnvio(@PathVariable Long id) {
        servicio.eliminarEnvio(id);
    }

}
