package com.quickorder360.ms_detalle_pedido.controller;

import com.quickorder360.ms_detalle_pedido.model.DetallePedido;
import com.quickorder360.ms_detalle_pedido.service.DetallePedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/detalle-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> listar() {
        List<DetallePedido> detalles = detallePedidoService.findAll();
        if (detalles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> buscar(@PathVariable Long id) {
        try {
            DetallePedido detalle = detallePedidoService.findById(id);
            return ResponseEntity.ok(detalle);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DetallePedido> guardar(@Valid @RequestBody DetallePedido detallePedido) {
        DetallePedido nuevo = detallePedidoService.save(detallePedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> actualizar(@PathVariable Long id,
                                                    @Valid @RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido existente = detallePedidoService.findById(id);
            existente.setPedidoId(detallePedido.getPedidoId());
            existente.setProductoId(detallePedido.getProductoId());
            existente.setCantidad(detallePedido.getCantidad());
            existente.setPrecioUnitario(detallePedido.getPrecioUnitario());
            detallePedidoService.save(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            detallePedidoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}