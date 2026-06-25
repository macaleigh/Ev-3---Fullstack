package com.quickorder360.ms_clientes;

import com.quickorder360.ms_clientes.model.Cliente;
import com.quickorder360.ms_clientes.repository.ClienteRepository;
import com.quickorder360.ms_clientes.service.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    private Cliente crearCliente(Long id) {
        Cliente c = new Cliente();
        c.setId(id);
        c.setNombre("Ana");
        c.setApellido("González");
        c.setEmail("ana@gmail.com");
        c.setTelefono("+56911111111");
        c.setDireccion("Calle 123");
        return c;
    }

    @Test
    @DisplayName("findAll() debe retornar lista de clientes")
    void testFindAll() {
        // Given
        when(clienteRepository.findAll()).thenReturn(List.of(crearCliente(1L)));

        // When
        List<Cliente> resultado = clienteService.findAll();

        // Then
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    @DisplayName("findById() debe retornar cliente cuando existe")
    void testFindById_existe() {
        // Given
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(crearCliente(1L)));

        // When
        Cliente resultado = clienteService.findById(1L);

        // Then
        assertNotNull(resultado);
        assertEquals("ana@gmail.com", resultado.getEmail());
    }

    @Test
    @DisplayName("findById() debe retornar null cuando no existe")
    void testFindById_noExiste() {
        // Given
        when(clienteRepository.findById(99L)).thenReturn(Optional.empty());

        // When
        Cliente resultado = clienteService.findById(99L);

        // Then
        assertNull(resultado);
    }

    @Test
    @DisplayName("save() debe guardar y retornar el cliente")
    void testSave() {
        // Given
        Cliente c = crearCliente(2L);
        when(clienteRepository.save(c)).thenReturn(c);

        // When
        Cliente resultado = clienteService.save(c);

        // Then
        assertNotNull(resultado);
        assertEquals("Ana", resultado.getNombre());
        verify(clienteRepository, times(1)).save(c);
    }

    @Test
    @DisplayName("delete() debe invocar deleteById en el repositorio")
    void testDelete() {
        // Given
        doNothing().when(clienteRepository).deleteById(1L);

        // When
        clienteService.delete(1L);

        // Then
        verify(clienteRepository, times(1)).deleteById(1L);
    }
}