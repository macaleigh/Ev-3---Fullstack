CREATE TABLE reclamo (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         pedido_id BIGINT NOT NULL,
                         cliente_id BIGINT NOT NULL,
                         descripcion VARCHAR(500) NOT NULL,
                         estado VARCHAR(50) NOT NULL DEFAULT 'ABIERTO',
                         fecha DATE NOT NULL
);

INSERT INTO reclamo (pedido_id, cliente_id, descripcion, estado, fecha) VALUES
                                                                            (1, 1, 'Producto llegó dañado', 'ABIERTO', '2025-01-17'),
                                                                            (2, 1, 'Demora en la entrega', 'CERRADO', '2025-01-22');