package com.quickorder360.ms_notificaciones.controller;

import com.quickorder360.ms_notificaciones.model.Notificacion;
import com.quickorder360.ms_notificaciones.service.NotificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<Notificacion>> listar() {
        List<Notificacion> notificaciones = notificacionService.findAll();
        if (notificaciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(notificaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> buscar(@PathVariable Long id) {
        try {
            Notificacion notificacion = notificacionService.findById(id);
            return ResponseEntity.ok(notificacion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Notificacion> guardar(@Valid @RequestBody Notificacion notificacion) {
        Notificacion nueva = notificacionService.save(notificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> actualizar(@PathVariable Long id,
                                                   @Valid @RequestBody Notificacion notificacion) {
        try {
            Notificacion existente = notificacionService.findById(id);
            existente.setUsuarioId(notificacion.getUsuarioId());
            existente.setMensaje(notificacion.getMensaje());
            existente.setTipo(notificacion.getTipo());
            existente.setLeido(notificacion.getLeido());
            existente.setFecha(notificacion.getFecha());
            notificacionService.save(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            notificacionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}