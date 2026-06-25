package com.quickorder360.ms_despachos.controller;

import com.quickorder360.ms_despachos.model.Despacho;
import com.quickorder360.ms_despachos.service.DespachoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/despachos")
public class DespachoController {

    @Autowired
    private DespachoService despachoService;

    @GetMapping
    public ResponseEntity<List<Despacho>> listar() {
        List<Despacho> despachos = despachoService.findAll();
        if (despachos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(despachos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despacho> buscar(@PathVariable Long id) {
        try {
            Despacho despacho = despachoService.findById(id);
            return ResponseEntity.ok(despacho);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Despacho> guardar(@Valid @RequestBody Despacho despacho) {
        Despacho nuevo = despachoService.save(despacho);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despacho> actualizar(@PathVariable Long id,
                                               @Valid @RequestBody Despacho despacho) {
        try {
            Despacho existente = despachoService.findById(id);
            existente.setPedidoId(despacho.getPedidoId());
            existente.setDireccion(despacho.getDireccion());
            existente.setEstado(despacho.getEstado());
            existente.setFechaDespacho(despacho.getFechaDespacho());
            despachoService.save(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            despachoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}