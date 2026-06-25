CREATE TABLE cliente (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         nombre VARCHAR(100) NOT NULL,
                         apellido VARCHAR(100) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         telefono VARCHAR(20),
                         direccion VARCHAR(255)
);

INSERT INTO cliente (nombre, apellido, email, telefono, direccion) VALUES
                                                                       ('Ana', 'González', 'ana.gonzalez@email.com', '+56912345678', 'Av. Providencia 123'),
                                                                       ('Luis', 'Martínez', 'luis.martinez@email.com', '+56987654321', 'Calle OHiggins 456');