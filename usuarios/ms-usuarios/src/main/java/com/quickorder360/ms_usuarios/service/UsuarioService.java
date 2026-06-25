package com.quickorder360.ms_usuarios.service;

import com.quickorder360.ms_usuarios.model.Usuario;
import com.quickorder360.ms_usuarios.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        log.info("Obteniendo todos los usuarios");
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        log.info("Buscando usuario con id: {}", id);
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        log.info("Guardando usuario: {}", usuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        log.info("Eliminando usuario con id: {}", id);
        usuarioRepository.deleteById(id);
    }
}