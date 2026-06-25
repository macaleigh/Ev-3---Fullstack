CREATE TABLE pago (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      pedido_id BIGINT NOT NULL,
                      monto DOUBLE NOT NULL,
                      estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
                      fecha_pago DATE NOT NULL
);

INSERT INTO pago (pedido_id, monto, estado, fecha_pago) VALUES
                                                            (1, 24990, 'APROBADO', '2025-01-15'),
                                                            (2, 129990, 'APROBADO', '2025-01-20');