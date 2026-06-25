package com.quickorder360.ms_despachos.service;

import com.quickorder360.ms_despachos.model.Despacho;
import com.quickorder360.ms_despachos.repository.DespachoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DespachoService {

    private static final Logger log = LoggerFactory.getLogger(DespachoService.class);

    @Autowired
    private DespachoRepository despachoRepository;

    public List<Despacho> findAll() {
        log.info("Obteniendo todos los despachos");
        return despachoRepository.findAll();
    }

    public Despacho findById(Long id) {
        log.info("Buscando despacho con id: {}", id);
        return despachoRepository.findById(id).orElse(null);
    }

    public Despacho save(Despacho despacho) {
        log.info("Guardando despacho para pedido: {}", despacho.getPedidoId());
        return despachoRepository.save(despacho);
    }

    public void delete(Long id) {
        log.info("Eliminando despacho con id: {}", id);
        despachoRepository.deleteById(id);
    }
}