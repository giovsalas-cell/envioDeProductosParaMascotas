package com.envioproductomascota.exepciones;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Excepcion {

    // Este método atrapa el "botón de pánico" que apretamos arriba
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> manejarErrores(RuntimeException ex) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", ex.getMessage());
        respuesta.put("codigo", 400);

        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}