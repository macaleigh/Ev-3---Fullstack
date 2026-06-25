package com.quickorder360.ms_notificaciones.service;

import com.quickorder360.ms_notificaciones.model.Notificacion;
import com.quickorder360.ms_notificaciones.repository.NotificacionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NotificacionService {

    private static final Logger log = LoggerFactory.getLogger(NotificacionService.class);

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> findAll() {
        log.info("Obteniendo todas las notificaciones");
        return notificacionRepository.findAll();
    }

    public Notificacion findById(Long id) {
        log.info("Buscando notificacion con id: {}", id);
        return notificacionRepository.findById(id).orElse(null);
    }

    public Notificacion save(Notificacion notificacion) {
        log.info("Guardando notificacion para usuario: {}", notificacion.getUsuarioId());
        return notificacionRepository.save(notificacion);
    }

    public void delete(Long id) {
        log.info("Eliminando notificacion con id: {}", id);
        notificacionRepository.deleteById(id);
    }
}