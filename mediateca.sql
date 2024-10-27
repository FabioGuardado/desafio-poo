create database mediateca;

use mediateca;

create table `rol`(
  `id` int not null auto_increment,
  `nombre` varchar(100) not null,
   PRIMARY KEY (`id` )
);

create table `usuario`(
  `id` int not null auto_increment,
  `rol_id` int not null,
  `nombre` varchar(100) not null,
  `apellido` varchar(100) not null,
  `correo` varchar(50) not null,
   PRIMARY KEY (`id` ),
   FOREIGN KEY (`rol_id`) REFERENCES `rol`(`id`)
);

create table `material`(
  `codigo_identificacion_interna` varchar(10) not null,
  `titulo` varchar(100) not null,
   `estado` boolean not null default true,
   `usuario_id` int not null,
   PRIMARY KEY (`codigo_identificacion_interna` ),
   FOREIGN KEY (`usuario_id`) REFERENCES `usuario`(`id`)
);

create table `material_escrito`(
  `codigo_identificacion_interna` varchar(10) not null,
  `editorial` varchar(100) not null,
  `unidades_disponibles` int(11) not null,
  PRIMARY KEY (`codigo_identificacion_interna`),
  FOREIGN KEY (`codigo_identificacion_interna`) REFERENCES `material`(`codigo_identificacion_interna`)
);
create table `libro`(
  `codigo_identificacion_interna` varchar(10) not null,
  `autor` varchar(100) not null,
  `numero_de_paginas` int(11) not null,
  `isbn` varchar(13) not null,
  `anio_publicacion` year(4) not null,
  PRIMARY KEY (`codigo_identificacion_interna` ),
  FOREIGN KEY (`codigo_identificacion_interna`) REFERENCES `material_escrito`(`codigo_identificacion_interna`)
);

create table `revista`(
  `codigo_identificacion_interna` varchar(10) not null,
  `fecha_publicacion` date not null,
   `periodicidad` varchar(50) not null,
  PRIMARY KEY (`codigo_identificacion_interna` ),
  FOREIGN KEY (`codigo_identificacion_interna`) REFERENCES `material_escrito`(`codigo_identificacion_interna`)
);

create table `material_audiovisual`(
  `codigo_identificacion_interna` varchar(10) not null,
  `genero` varchar(100) not null,
  `duracion` time not null,
  PRIMARY KEY (`codigo_identificacion_interna`),
  FOREIGN KEY (`codigo_identificacion_interna`) REFERENCES `material`(`codigo_identificacion_interna`)
);

create table `cd`( 
  `codigo_identificacion_interna` varchar(10) not null,
  `artista` varchar(100) not null,
  `numero_canciones` int(13) not null,
  `unidades_disponibles` int(11) not null,
  PRIMARY KEY (`codigo_identificacion_interna` ),
  FOREIGN KEY (`codigo_identificacion_interna`) REFERENCES `material_audiovisual`(`codigo_identificacion_interna`)
);

create table `dvd`(
  `codigo_identificacion_interna` varchar(10) not null,
  `director` varchar(100) not null,
  PRIMARY KEY (`codigo_identificacion_interna` ),
  FOREIGN KEY (`codigo_identificacion_interna`) REFERENCES `material_audiovisual`(`codigo_identificacion_interna`)
);