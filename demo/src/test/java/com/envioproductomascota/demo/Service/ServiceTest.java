package com.envioproductomascota.demo.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.envioproductomascota.demo.Servicio.EnvioRepository;
import com.envioproductomascota.demo.Servicio.ProductoRepository;
import com.envioproductomascota.demo.Servicio.Servicio;
import com.envioproductomascota.demo.modelos.Envio;
import com.envioproductomascota.demo.modelos.Producto;

@ExtendWith(MockitoExtension.class) // Activa Mockito sin levantar Spring
public class ServiceTest {
    @Mock
    private EnvioRepository envioRepository;

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private Servicio servicio;

    // datos de prueba reutilizables en todos los tests
    private Envio envioEjemplo;
    private Producto productoEjemplo;

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
    void crearEnvio_guardaYretornaEnvio() {
        when(envioRepository.save(any(Envio.class))).thenReturn(envioEjemplo);

        Envio resultado = servicio.crearEnvio(envioEjemplo);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdEnvio());
        assertEquals("Carlos García", resultado.getNombreCliente());
    }

    @Test
    void buscarEnvio_idExiste_retornaEnvio() {
        // arrange
        when(envioRepository.findById(1L)).thenReturn(java.util.Optional.of(envioEjemplo));

        // act
        Envio resultado = servicio.buscarEnvio(1L);

        // assert
        assertNotNull(resultado);
        assertEquals("Carlos García", resultado.getNombreCliente());
        assertEquals("preparando", resultado.getEstadoEnvio());
    }

    @Test
    void eliminarEnvio_idExiste_eliminaSinError() {
        when(envioRepository.existsById(1L)).thenReturn(true);
        doNothing().when(envioRepository).deleteById(1L);

        assertDoesNotThrow(() -> servicio.eliminarEnvio(1L));
        verify(envioRepository, times(1)).deleteById(1L);
    }

    @Test
    void actualizEnvio_idExiste_actualizaEstado() {
        when(envioRepository.findById(1L)).thenReturn(java.util.Optional.of(envioEjemplo));
        when(envioRepository.save(any(Envio.class))).thenReturn(envioEjemplo);
        Envio resultado = servicio.actualizEnvio(1L, "en transito");

        assertEquals("en transito", resultado.getEstadoEnvio());
        verify(envioRepository).save(envioEjemplo);
    }

    @Test
    void eliminarEnvio_idNoExiste_lanzaExcepcion() {
        when(envioRepository.existsById(99L)).thenReturn(false);

        RuntimeException excepcion = assertThrows(RuntimeException.class,
                () -> servicio.eliminarEnvio(99L));

        assertTrue(excepcion.getMessage().contains("99"));
    }

    @Test
    @DisplayName("actualizarUbicacion - actualiza la ubicacion correctamente")
    void actualizarUbicacion_idExiste_actualizaUbicacion() {
        // Arrange
        when(envioRepository.findById(1L)).thenReturn(java.util.Optional.of(envioEjemplo));
        when(envioRepository.save(any(Envio.class))).thenReturn(envioEjemplo);

        // Act
        Envio resultado = servicio.actualizarUbicacion(1, "Sucursal Norte, Antofagasta");

        // Assert
        envioEjemplo.setUbicacion("Sucursal Norte, Antofagasta");
        assertEquals("Sucursal Norte, Antofagasta", resultado.getUbicacion());
        verify(envioRepository).save(envioEjemplo);
    }
}
