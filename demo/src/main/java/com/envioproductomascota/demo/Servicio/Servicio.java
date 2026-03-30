package com.envioproductomascota.demo.Servicio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.envioproductomascota.demo.modelos.Envio;
import com.envioproductomascota.demo.modelos.Producto;

@Service
public class Servicio {

    List<Envio> listaEnvios = new ArrayList<>();

    public Servicio() {

        Producto p1 = new Producto(1L, "Purina Pro Plan", "Alimento gato adulto 3kg", 23000);
        Producto p2 = new Producto(2L, "Arenero M1", "Arenero cerrado con filtro", 15000);
        Producto p3 = new Producto(3L, "Tuya Dispensador", "Dispensador automático WiFi", 80000);
        Producto p4 = new Producto(4L, "Rascador Cactus", "Rascador de sisal 80cm", 35000);
        Producto p5 = new Producto(5L, "Cama Ortopédica", "Cama memory foam mediana", 42000);
        Producto p6 = new Producto(6L, "Arnés reflectante", "Arnés ajustable talla M", 12500);
        Producto p7 = new Producto(7L, "Juguete Láser", "Láser automático rotatorio", 18900);
        Producto p8 = new Producto(8L, "Snacks Dentales", "Pack 24 unidades limpieza dental", 9990);

        Envio e1 = new Envio(1L, "Giovanni Salas", "Av. Libertad 450", "Preparando", "Bodega Central", p1);
        Envio e2 = new Envio(2L, "Emilio Iturra", "Ruta 68 Km 10", "Enviando", "Camión Reparto 04", p2);
        Envio e3 = new Envio(3L, "Isabel Allende", "Calle Los Alerces 12", "Entregado", "Casa Cliente", p3);
        Envio e4 = new Envio(4L, "Carlos Peña", "Pasaje El Roble 44", "Preparando", "Bodega Norte", p4);
        Envio e5 = new Envio(5L, "Daniela Vega", "Diagonal Sur 900", "Enviando", "Centro Distribución", p5);
        Envio e6 = new Envio(6L, "Roberto Belmar", "Los Militares 5000", "En Tránsito", "Aduana", p6);
        Envio e7 = new Envio(7L, "Paola Troncoso", "Vicuña Mackenna 123", "Pendiente", "Validación Pago", p7);
        Envio e8 = new Envio(8L, "Ignacio Israel", "Avenida El Golf 88", "Enviando", "Ruta Las Condes", p8);

        listaEnvios.add(e1);
        listaEnvios.add(e2);
        listaEnvios.add(e3);
        listaEnvios.add(e4);
        listaEnvios.add(e5);
        listaEnvios.add(e6);
        listaEnvios.add(e7);
        listaEnvios.add(e8);
    }

    public List<Envio> verEnvios() {
        return listaEnvios;
    }

    public Envio buscarEnvio(Long id) {
        for (Envio e : listaEnvios) {
            if (e.getIdEnvio().equals(id)) {
                return e;
            }
        }
        return null;
    }

    // preparando-enviando-en transito-pendiente- cancelado
    public Envio actualizEnvio(int codigoEnvio, String estadoEnvio) {
        for (Envio e : listaEnvios) {
            if (e.getIdEnvio() == codigoEnvio) {
                e.setEstadoEnvio(estadoEnvio);
                return e;
            }
        }
        return null;
    }

    public Envio actualizarUbicacion(int codigoEnvio, String ubicacion) {
        for (Envio e : listaEnvios) {
            if (e.getIdEnvio() == codigoEnvio) {
                e.setUbicacion(ubicacion);
                return e;
            }
        }
        return null;

    }

    public String obtenerUbicacion(int codigoEnvio) {
        for (Envio envio : listaEnvios) {
            if (envio.getIdEnvio() == codigoEnvio) {

                return "El envio " + envio.getIdEnvio() + " se encuentra en: " + envio.getUbicacion();

            }
        }
        return null;

    }
}