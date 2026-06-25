package com.quickorder360.ms_detalle_pedido.service;

import com.quickorder360.ms_detalle_pedido.model.DetallePedido;
import com.quickorder360.ms_detalle_pedido.repository.DetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DetallePedidoService {

    private static final Logger log = LoggerFactory.getLogger(DetallePedidoService.class);

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> findAll() {
        log.info("Obteniendo todos los detalles de pedido");
        return detallePedidoRepository.findAll();
    }

    public DetallePedido findById(Long id) {
        log.info("Buscando detalle de pedido con id: {}", id);
        return detallePedidoRepository.findById(id).orElse(null);
    }

    public DetallePedido save(DetallePedido detallePedido) {
        log.info("Guardando detalle de pedido para pedido: {}", detallePedido.getPedidoId());
        return detallePedidoRepository.save(detallePedido);
    }

    public void delete(Long id) {
        log.info("Eliminando detalle de pedido con id: {}", id);
        detallePedidoRepository.deleteById(id);
    }
}