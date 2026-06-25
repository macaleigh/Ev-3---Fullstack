package com.quickorder360.ms_pagos.service;

import com.quickorder360.ms_pagos.model.Pago;
import com.quickorder360.ms_pagos.repository.PagoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PagoService {

    private static final Logger log = LoggerFactory.getLogger(PagoService.class);

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> findAll() {
        log.info("Obteniendo todos los pagos");
        return pagoRepository.findAll();
    }

    public Pago findById(Long id) {
        log.info("Buscando pago con id: {}", id);
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago save(Pago pago) {
        log.info("Guardando pago para pedido: {}", pago.getPedidoId());
        return pagoRepository.save(pago);
    }

    public void delete(Long id) {
        log.info("Eliminando pago con id: {}", id);
        pagoRepository.deleteById(id);
    }
}