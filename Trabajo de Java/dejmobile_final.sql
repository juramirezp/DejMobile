CREATE DATABASE dejm;

USE dejm;

CREATE TABLE comunas(
	id int NOT NULL AUTO_INCREMENT,
	nombre varchar(30) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE clientes(
	rut	varchar(10)	NOT NULL,
	nombre 	varchar(40) NOT NULL,
	apellidoPat varchar(30) NOT NULL,
	apellidoMat varchar(30) NOT NULL,
	direccion varchar(100) NOT NULL,
	numeracion int NOT NULL,
	comuna int NOT NULL,
	telefono int NOT NULL,
	clave varchar(100) NOT NULL,
	PRIMARY KEY(rut),
	FOREIGN KEY(comuna) REFERENCES comunas(id)
);

CREATE TABLE gigas(
	id int NOT NULL AUTO_INCREMENT,
	cantidad int NOT NULL,
	precio int NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE minutos(
	id int NOT NULL AUTO_INCREMENT,
	cantidad int NOT NULL,
	precio int NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE planes(
	id int NOT NULL AUTO_INCREMENT,
	rut varchar(10) NOT NULL,
	gigas int NOT NULL,
	minutos int NOT NULL,
	entrega varchar(200) NOT NULL,
	total int NOT NULL,
	fecha varchar(50) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(rut) REFERENCES clientes(rut),
	FOREIGN KEY(minutos) REFERENCES minutos(id),
	FOREIGN KEY(gigas) REFERENCES gigas(id)
);

INSERT INTO `minutos` (`id`, `cantidad`, `precio`) VALUES
(1, 800, 1000),
(2, 2000, 3000),
(3, 3000, 5000);

INSERT INTO `gigas` (`id`, `cantidad`, `precio`) VALUES
(1, 5, 4000),
(2, 7, 6000),
(3, 10, 8000);

INSERT INTO `comunas` (`id`, `nombre`) VALUES
(1, 'Maipu'),
(2, 'Santiago'),
(3, 'Providencia'),
(4, 'San Bernardo'),
(5, 'Ñuñoa'),
(6, 'Las Condes'),
(7, 'Estación Central'),
(8, 'Quinta Normal'),
(9, 'Renca'),
(10, 'Indendencia');

INSERT INTO `clientes` (`rut`, `nombre`, `apellidoPat`, `apellidoMat`, `direccion`, `numeracion`, `comuna`, `telefono`, `clave`) VALUES
('16912591-0', 'Cristian', 'Zamora', 'Quinones', 'Psje. Chumalco', 6904, 6, 87364977, '1bbd886460827015e5d605ed44252251'),
('17563572-6', 'Juan', 'Ramirez', 'Peralta', '10 de Julio', 1244, 2, 7365298, '30a8aaae81bafce5d9471e5042196d47'),
('18621906-6', 'Moises', 'Munoz', 'Diaz', 'Alameda', 12, 6, 62004592, '96e79218965eb72c92a549dd5a330112');

INSERT INTO `planes` (`id`, `rut`, `gigas`, `minutos`, `entrega`, `total`, `fecha`) VALUES
(4, '17563572-6', 1, 2, '10 de Julio #1244', 7000, '03-42-2016 18:42:25'),
(11, '16912591-0', 3, 1, 'Psje. Chumalco #6904', 9000, '03-44-2016 19:44:11'),
(12, '16912591-0', 1, 2, 'Retiro en Sucursal', 7000, '03-45-2016 19:45:08'),
(13, '16912591-0', 1, 2, 'Retiro en Sucursal', 7000, '03-45-2016 19:45:44'),
(14, '16912591-0', 3, 3, 'Retiro en Sucursal', 13000, '03-46-2016 19:46:34'),
(15, '16912591-0', 1, 1, 'Psje. Chumalco #6904', 5000, '03-46-2016 19:46:50'),
(16, '17563572-6', 2, 1, '10 de Julio #1244', 7000, '03-47-2016 19:47:49'),
(17, '17563572-6', 3, 3, 'Retiro en Sucursal', 13000, '03-48-2016 19:48:14'),
(18, '17563572-6', 1, 2, 'Retiro en Sucursal', 7000, '03-48-2016 19:48:42'),
(19, '18621906-6', 2, 1, 'Retiro en Sucursal', 7000, '03-49-2016 19:49:35'),
(20, '18621906-6', 1, 1, 'Alameda #12', 5000, '03-49-2016 19:49:45'),
(21, '18621906-6', 3, 2, 'Retiro en Sucursal', 11000, '03-50-2016 19:50:12');