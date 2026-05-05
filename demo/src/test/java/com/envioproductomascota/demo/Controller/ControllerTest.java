package com.envioproductomascota.demo.Controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.envioproductomascota.demo.Servicio.Servicio;
import com.envioproductomascota.demo.controlador.controller;
import com.envioproductomascota.demo.modelos.Envio;
import com.envioproductomascota.demo.modelos.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;

@WebMvcTest(controller.class) // levanta SOLO la capa web (sin base de datos)
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Servicio servicio;

    @Autowired
    private ObjectMapper objectMapper; // convierte objetos Java ↔ JSON

    private Producto productoEjemplo;
    private Envio envioEjemplo;

    @BeforeEach
    void setUp() {
        productoEjemplo = new Producto(
                1L,
                "Croquetas premium",
                "Alimento balanceado para perros adultos de razas grandes",
                25000);

        envioEjemplo = new Envio(
                1L,
                "Carlos García",
                "Av. Providencia 1234, Santiago",
                "preparando",
                "Bodega central, Santiago",
                productoEjemplo);
    }

    @Test
    void listarEnvio_retornaLista200() throws Exception {
        when(servicio.verEnvios()).thenReturn(Arrays.asList(envioEjemplo));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /envio/buscar-envio/{id} - retorna envío existente")
    void buscarEnvio_idExiste_retorna200() throws Exception {
        when(servicio.buscarEnvio(1L)).thenReturn(envioEjemplo);

        mockMvc.perform(get("/envio/buscar-envio/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEnvio").value(1))
                .andExpect(jsonPath("$.estadoEnvio").value("preparando"));
    }

    @Test
    @DisplayName("POST /envios/crear-envio - crea envio y retorna 200")
    void crearEnvio_datosValidos_retorna200() throws Exception {
        when(servicio.crearEnvio(any(Envio.class))).thenReturn(envioEjemplo);

        mockMvc.perform(post("/envios/crear-envio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(envioEjemplo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreCliente").value("Carlos García"));
    }

    @Test
    @DisplayName("DELETE /envios/eliminar-envio/{id} - elimina correctamente")
    void eliminarEnvio_idExiste_retorna200() throws Exception {
        doNothing().when(servicio).eliminarEnvio(1L);

        mockMvc.perform(delete("/envios/eliminar-envio/1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT /envios/actualiza-envio - actualiza estado correctamente")
    void actualizaEnvio_retorna200() throws Exception {
        when(servicio.actualizEnvio(eq(1L), eq("en transito"))).thenReturn(envioEjemplo);

        mockMvc.perform(put("/envios/actualiza-envio/1/en transito")
                .param("estadoEnvio", "en transito"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("PUT /envios/actualiza-ubicacion - actualiza ubicacion correctamente")
    void actualizarUbicacion_retorna200() throws Exception {
        when(servicio.actualizarUbicacion(eq(1), eq("Sucursal Norte"))).thenReturn(envioEjemplo);

        mockMvc.perform(put("/envios/actualiza-ubicacion/1/Sucursal Norte"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /envio/obtener-ubicacion/{id} - retorna ubicacion del envio")
    void obtenerUbicacion_retorna200() throws Exception {
        when(servicio.obtenerUbicacion(1L)).thenReturn(envioEjemplo);

        mockMvc.perform(get("/envio/obtener-ubicacion/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ubicacion").value("Bodega central, Santiago"));
    }

}
