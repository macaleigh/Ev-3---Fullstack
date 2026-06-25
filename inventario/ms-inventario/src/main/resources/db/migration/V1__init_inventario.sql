CREATE TABLE inventario (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            producto_id BIGINT NOT NULL,
                            cantidad INT NOT NULL DEFAULT 0,
                            stock_minimo INT NOT NULL DEFAULT 5
);

INSERT INTO inventario (producto_id, cantidad, stock_minimo) VALUES
                                                                 (1, 15, 5),
                                                                 (2, 8, 3),
                                                                 (3, 20, 5);