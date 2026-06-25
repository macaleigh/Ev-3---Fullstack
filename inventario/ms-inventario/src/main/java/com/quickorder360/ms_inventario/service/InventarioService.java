package com.quickorder360.ms_inventario.service;

import com.quickorder360.ms_inventario.model.Inventario;
import com.quickorder360.ms_inventario.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class InventarioService {

    private static final Logger log = LoggerFactory.getLogger(InventarioService.class);

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> findAll() {
        log.info("Obteniendo todo el inventario");
        return inventarioRepository.findAll();
    }

    public Inventario findById(Long id) {
        log.info("Buscando inventario con id: {}", id);
        return inventarioRepository.findById(id).orElse(null);
    }

    public Inventario save(Inventario inventario) {
        log.info("Guardando inventario para producto: {}", inventario.getProductoId());
        return inventarioRepository.save(inventario);
    }

    public void delete(Long id) {
        log.info("Eliminando inventario con id: {}", id);
        inventarioRepository.deleteById(id);
    }
}