package com.quickorder360.ms_pedidos;

import com.quickorder360.ms_pedidos.model.Pedido;
import com.quickorder360.ms_pedidos.repository.PedidoRepository;
import com.quickorder360.ms_pedidos.service.PedidoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PedidoServiceTest {

    @Autowired
    private PedidoService pedidoService;

    @MockBean
    private PedidoRepository pedidoRepository;

    private Pedido crearPedido(Long id) {
        Pedido p = new Pedido();
        p.setId(id);
        p.setClienteId(1L);
        p.setFecha(LocalDate.now());
        p.setEstado("PENDIENTE");
        p.setTotal(50000.0);
        return p;
    }

    @Test
    @DisplayName("findAll() debe retornar lista de pedidos")
    void testFindAll() {
        // Given
        when(pedidoRepository.findAll()).thenReturn(List.of(crearPedido(1L), crearPedido(2L)));

        // When
        List<Pedido> resultado = pedidoService.findAll();

        // Then
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }

    @Test
    @DisplayName("findById() debe retornar pedido cuando existe")
    void testFindById_existe() {
        // Given
        when(pedidoRepository.findById(1L)).thenReturn(Optional.of(crearPedido(1L)));

        // When
        Pedido resultado = pedidoService.findById(1L);

        // Then
        assertNotNull(resultado);
        assertEquals("PENDIENTE", resultado.getEstado());
    }

    @Test
    @DisplayName("findById() debe retornar null cuando no existe")
    void testFindById_noExiste() {
        // Given
        when(pedidoRepository.findById(99L)).thenReturn(Optional.empty());

        // When
        Pedido resultado = pedidoService.findById(99L);

        // Then
        assertNull(resultado);
    }

    @Test
    @DisplayName("delete() debe invocar deleteById en el repositorio")
    void testDelete() {
        // Given
        doNothing().when(pedidoRepository).deleteById(1L);

        // When
        pedidoService.delete(1L);

        // Then
        verify(pedidoRepository, times(1)).deleteById(1L);
    }
}