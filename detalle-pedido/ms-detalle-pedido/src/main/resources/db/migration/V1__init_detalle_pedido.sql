CREATE TABLE detalle_pedido (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                pedido_id BIGINT NOT NULL,
                                producto_id BIGINT NOT NULL,
                                cantidad INT NOT NULL DEFAULT 1,
                                precio_unitario DOUBLE NOT NULL
);

INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, precio_unitario) VALUES
                                                                                   (1, 1, 2, 24990),
                                                                                   (1, 3, 1, 14990),
                                                                                   (2, 2, 1, 129990);