package com.quickorder360.ms_productos.service;

import com.quickorder360.ms_productos.model.Producto;
import com.quickorder360.ms_productos.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    private static final Logger log = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        log.info("Obteniendo todos los productos");
        return productoRepository.findAll();
    }

    public Producto findById(Long id) {
        log.info("Buscando producto con id: {}", id);
        return productoRepository.findById(id).orElse(null);
    }

    public Producto save(Producto producto) {
        log.info("Guardando producto: {}", producto.getNombre());
        return productoRepository.save(producto);
    }

    public void delete(Long id) {
        log.info("Eliminando producto con id: {}", id);
        productoRepository.deleteById(id);
    }
}