package com.quickorder360.ms_reclamos.service;

import com.quickorder360.ms_reclamos.model.Reclamo;
import com.quickorder360.ms_reclamos.repository.ReclamoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReclamoService {

    private static final Logger log = LoggerFactory.getLogger(ReclamoService.class);

    @Autowired
    private ReclamoRepository reclamoRepository;

    public List<Reclamo> findAll() {
        log.info("Obteniendo todos los reclamos");
        return reclamoRepository.findAll();
    }

    public Reclamo findById(Long id) {
        log.info("Buscando reclamo con id: {}", id);
        return reclamoRepository.findById(id).orElse(null);
    }

    public Reclamo save(Reclamo reclamo) {
        log.info("Guardando reclamo para pedido: {}", reclamo.getPedidoId());
        return reclamoRepository.save(reclamo);
    }

    public void delete(Long id) {
        log.info("Eliminando reclamo con id: {}", id);
        reclamoRepository.deleteById(id);
    }
}