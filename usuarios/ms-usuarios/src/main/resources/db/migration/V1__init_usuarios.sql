CREATE TABLE usuario (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         rol VARCHAR(50) NOT NULL DEFAULT 'USER'
);

INSERT INTO usuario (nombre, email, password, rol) VALUES
                                                       ('Admin', 'admin@quickorder.com', '1234', 'ADMIN'),
                                                       ('Usuario1', 'usuario1@quickorder.com', '1234', 'USER');