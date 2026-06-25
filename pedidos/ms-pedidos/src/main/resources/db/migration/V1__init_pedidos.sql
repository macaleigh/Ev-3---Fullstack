CREATE TABLE pedido (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        cliente_id BIGINT NOT NULL,
                        fecha DATE NOT NULL,
                        estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
                        total DOUBLE NOT NULL DEFAULT 0
);

INSERT INTO pedido (cliente_id, fecha, estado, total) VALUES
                                                          (1, '2025-01-15', 'PENDIENTE', 24990),
                                                          (1, '2025-01-20', 'PAGADO', 129990);