package com.envioproductomascota.demo.Servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.envioproductomascota.demo.modelos.Envio;
import com.envioproductomascota.demo.modelos.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
