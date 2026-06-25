CREATE TABLE producto (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          nombre VARCHAR(100) NOT NULL,
                          descripcion VARCHAR(255),
                          precio DOUBLE NOT NULL,
                          stock INT DEFAULT 0
);

INSERT INTO producto (nombre, descripcion, precio, stock) VALUES
                                                              ('Teclado Gamer', 'Teclado mecánico RGB', 24990, 15),
                                                              ('Monitor Samsung 24', 'Monitor Full HD', 129990, 8),
                                                              ('Mouse Inalámbrico', 'Mouse ergonómico', 14990, 20);