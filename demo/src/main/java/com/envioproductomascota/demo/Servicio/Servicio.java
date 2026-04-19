package com.envioproductomascota.demo.Servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.envioproductomascota.demo.modelos.Envio;
import com.envioproductomascota.demo.modelos.Producto;

@Service
public class Servicio {

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    EnvioRepository envioRepository;

    private List<Envio> listaEnvios = new ArrayList<>();

    public List<Envio> verEnvios() {
        return envioRepository.findAll();
    }

    public Envio buscarEnvio(Long id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("¡Oops! El producto con ID " + id + " no existe."));
    }

    public Producto buscarProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Envio crearEnvio(Envio envio) {
        return envioRepository.save(envio);

    }

    // preparando-enviando-en transito-pendiente- cancelado
    public Envio actualizEnvio(Long codigoEnvio, String estadoEnvio) {
        Envio envio = envioRepository.findById(codigoEnvio)
                .orElseThrow(() -> new RuntimeException("¡Oops! El producto con ID " + codigoEnvio + " no existe."));
        if (envio != null) {
            envio.setEstadoEnvio(estadoEnvio);
            return envioRepository.save(envio);
        }
        return null;
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Envio actualizarUbicacion(int codigoEnvio, String ubicacion) {
        Envio envio = buscarEnvio(Long.valueOf(codigoEnvio));
        if (envio != null) {
            envio.setUbicacion(ubicacion);
            return envioRepository.save(envio);
        }
        return null;

    }

    public void eliminarEnvio(Long codigoEnvio) {
        if (envioRepository.existsById(codigoEnvio)) {
            envioRepository.deleteById(codigoEnvio);
        } else {

            throw new RuntimeException("El envío con ID " + codigoEnvio + " no existe.");
        }
    }

    public Envio obtenerUbicacion(Long codigoEnvio) {

        Envio envio = buscarEnvio(Long.valueOf(codigoEnvio));
        if (envio != null) {
            return envio;
        }
        return null;

    }
}