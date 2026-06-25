package com.quickorder360.ms_pedidos.service;

import com.quickorder360.ms_pedidos.model.Pedido;
import com.quickorder360.ms_pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
public class PedidoService {

    private static final Logger log = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    private final WebClient webClient = WebClient.builder().build();

    public List<Pedido> findAll() {
        log.info("Obteniendo todos los pedidos");
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        log.info("Buscando pedido con id: {}", id);
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido save(Pedido pedido) {
        log.info("Verificando cliente con id: {}", pedido.getClienteId());
        try {
            Object cliente = webClient.get()
                    .uri("http://localhost:8081/api/v1/clientes/" + pedido.getClienteId())
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError(),
                            response -> reactor.core.publisher.Mono.error(
                                    new RuntimeException("Cliente no encontrado")))
                    .bodyToMono(Object.class)
                    .block();

            if (cliente == null) {
                throw new RuntimeException("El cliente no existe");
            }
        } catch (Exception e) {
            log.error("Cliente no encontrado con id: {}", pedido.getClienteId());
            throw new RuntimeException("El cliente no existe");
        }
        log.info("Guardando pedido para cliente: {}", pedido.getClienteId());
        return pedidoRepository.save(pedido);
    }

    public void delete(Long id) {
        log.info("Eliminando pedido con id: {}", id);
        pedidoRepository.deleteById(id);
    }
}