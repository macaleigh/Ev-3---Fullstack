package com.quickorder360.ms_clientes.service;

import com.quickorder360.ms_clientes.model.Cliente;
import com.quickorder360.ms_clientes.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        log.info("Obteniendo todos los clientes");
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        log.info("Buscando cliente con id: {}", id);
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        log.info("Guardando cliente: {}", cliente.getEmail());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        log.info("Eliminando cliente con id: {}", id);
        clienteRepository.deleteById(id);
    }
}
