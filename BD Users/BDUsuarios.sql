CREATE Database IF NOT EXISTS Trabajo;
Use Trabajo;
CREATE Table Usuarios (
	id_usuario INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(20), 
	apellidos VARCHAR(30), 
	metodo VARCHAR(5)
);