--DROP TABLE loader IF EXISTS;

CREATE TABLE loader (
  id      BIGINT PRIMARY KEY,
  contrasena VARCHAR(30),
  kind VARCHAR(50),
  nombreUsuario  VARCHAR(50),
  dni VARCHAR(50),
  nombre VARCHAR(50),
  apellidos VARCHAR(50),
  fechaNacimiento DATE,
  email VARCHAR(50),
  direccionPostal VARCHAR(50),
  nacionalidad VARCHAR(50)
);
