CREATE TABLE despacho (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          pedido_id BIGINT NOT NULL,
                          direccion VARCHAR(255) NOT NULL,
                          estado VARCHAR(50) NOT NULL DEFAULT 'PENDIENTE',
                          fecha_despacho DATE NOT NULL
);

INSERT INTO despacho (pedido_id, direccion, estado, fecha_despacho) VALUES
                                                                        (1, 'Av. Providencia 123', 'ENVIADO', '2025-01-16'),
                                                                        (2, 'Calle OHiggins 456', 'ENTREGADO', '2025-01-21');