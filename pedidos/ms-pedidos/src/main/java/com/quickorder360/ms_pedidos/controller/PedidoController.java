package com.quickorder360.ms_pedidos.controller;

import com.quickorder360.ms_pedidos.model.Pedido;
import com.quickorder360.ms_pedidos.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(name = "Pedidos", description = "Operaciones CRUD sobre pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    @Operation(summary = "Listar todos los pedidos", description = "Retorna la lista completa de pedidos")
    @ApiResponse(responseCode = "200", description = "Lista retornada exitosamente")
    public ResponseEntity<List<Pedido>> listar() {
        List<Pedido> pedidos = pedidoService.findAll();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedido por ID", description = "Retorna un pedido según su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        try {
            Pedido pedido = pedidoService.findById(id);
            return ResponseEntity.ok(pedido);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Crear nuevo pedido", description = "Crea un nuevo pedido en el sistema")
    @ApiResponse(responseCode = "201", description = "Pedido creado exitosamente")
    public ResponseEntity<Pedido> guardar(@Valid @RequestBody Pedido pedido) {
        try {
            Pedido nuevo = pedidoService.save(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar pedido", description = "Actualiza los datos de un pedido existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
    })
    public ResponseEntity<Pedido> actualizar(@PathVariable Long id,
                                             @Valid @RequestBody Pedido pedido) {
        try {
            Pedido existente = pedidoService.findById(id);
            existente.setClienteId(pedido.getClienteId());
            existente.setFecha(pedido.getFecha());
            existente.setEstado(pedido.getEstado());
            existente.setTotal(pedido.getTotal());
            pedidoService.save(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar pedido", description = "Elimina un pedido por su ID")
    @ApiResponse(responseCode = "204", description = "Pedido eliminado exitosamente")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            pedidoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}