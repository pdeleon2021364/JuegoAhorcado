DROP DATABASE IF EXISTS DB_JuegoAhorcado;
CREATE DATABASE DB_JuegoAhorcado;
USE DB_JuegoAhorcado;

CREATE TABLE palabras (
    codigoPalabra INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    pista1 VARCHAR(255) NOT NULL,
    pista2 VARCHAR(255) NOT NULL,
    pista3 VARCHAR(255) NOT NULL,
    PRIMARY KEY PK_codigoPalabra(codigoPalabra)
);

CREATE TABLE usuarios(
    codigoUsuario INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR (50) NOT NULL,
    apellido VARCHAR (50) NOT NULL,
    correo VARCHAR (50) NOT NULL,
    contrasena VARCHAR (50) NOT NULL,
    PRIMARY KEY PK_codigoUsuario(codigoUsuario)
);


select * from usuarios;

INSERT INTO usuarios (nombre, apellido, correo, contrasena) 
VALUES
('juanperez', 'Perez', 'juanperez@email.com', '9090'),
('pdeleon', 'De Leon', 'pdeleon@email.com', '1234');

select * from usuarios;

INSERT INTO palabras (nombre, pista1, pista2, pista3) VALUES
('Reloj', 'Mide el tiempo', 'Tiene manecillas', 'Puede ser digital o analógico'),
('Cactus', 'Crece en el desierto', 'Tiene espinas', 'Almacena agua'),
('Piano', 'Instrumento musical', 'Tiene teclas blancas y negras', 'Se toca con las manos'),
('Nube', 'Flota en el cielo', 'Hecha de vapor de agua', 'Forma la lluvia'),
('Espejo', 'Refleja la luz', 'Superficie de cristal', 'Muestra tu imagen'),
('Alumno', 'Compañerito de clase', 'Superficie de cristal', 'Muestra tu imagen');
select  * from palabras;
DELIMITER $$
CREATE PROCEDURE sp_listarPalabras()
BEGIN
    SELECT
        codigoPalabra,
        nombre,
        pista1,
        pista2,
        pista3
    FROM palabras;
END $$
DELIMITER ;



