package com.quickorder360.ms_reclamos.controller;

import com.quickorder360.ms_reclamos.model.Reclamo;
import com.quickorder360.ms_reclamos.service.ReclamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @GetMapping
    public ResponseEntity<List<Reclamo>> listar() {
        List<Reclamo> reclamos = reclamoService.findAll();
        if (reclamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reclamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> buscar(@PathVariable Long id) {
        try {
            Reclamo reclamo = reclamoService.findById(id);
            return ResponseEntity.ok(reclamo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Reclamo> guardar(@Valid @RequestBody Reclamo reclamo) {
        Reclamo nuevo = reclamoService.save(reclamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reclamo> actualizar(@PathVariable Long id,
                                              @Valid @RequestBody Reclamo reclamo) {
        try {
            Reclamo existente = reclamoService.findById(id);
            existente.setPedidoId(reclamo.getPedidoId());
            existente.setClienteId(reclamo.getClienteId());
            existente.setDescripcion(reclamo.getDescripcion());
            existente.setEstado(reclamo.getEstado());
            existente.setFecha(reclamo.getFecha());
            reclamoService.save(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            reclamoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}