package com.envioproductomascota.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.envioproductomascota.demo.Servicio.Servicio;
import com.envioproductomascota.demo.modelos.Envio;

@RestController
public class controller {

    @Autowired
    private Servicio servicio;

    @GetMapping("/")
    public List listarEnvio() {
        return servicio.verEnvios();
    }

    @GetMapping("/envios/actualiza-envio/{id}/{estadoEnvio}")
    public Envio actualizaEnvio(@PathVariable int id, @PathVariable String estadoEnvio) {
        return servicio.actualizEnvio(id, estadoEnvio);
    }

    @GetMapping("/envios/actualiza-ubicacion/{id}/{ubicacion}")
    public Envio actualizarubicacion(@PathVariable int id, @PathVariable String ubicacion) {
        return servicio.actualizarUbicacion(id, ubicacion);
    }

    @GetMapping("/envio/buscar-envio/{id}")
    public Envio buscarEnvio(@PathVariable Long id) {
        return servicio.buscarEnvio(id);
    }

}
