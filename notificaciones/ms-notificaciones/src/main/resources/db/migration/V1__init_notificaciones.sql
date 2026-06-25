CREATE TABLE notificacion (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              usuario_id BIGINT NOT NULL,
                              mensaje VARCHAR(500) NOT NULL,
                              tipo VARCHAR(50) NOT NULL DEFAULT 'INFO',
                              leido BOOLEAN NOT NULL DEFAULT FALSE,
                              fecha DATE NOT NULL
);

INSERT INTO notificacion (usuario_id, mensaje, tipo, leido, fecha) VALUES
                                                                       (1, 'Su pedido ha sido confirmado', 'INFO', FALSE, '2025-01-15'),
                                                                       (1, 'Su pago fue aprobado', 'INFO', TRUE, '2025-01-20');