INSERT INTO `mediateca`.`rol`
(`id`,
`nombre`)
VALUES
(1,
"administrador");
SELECT * FROM mediateca.rol;

INSERT INTO `mediateca`.`rol`
(`id`,
`nombre`)
VALUES
(2,
"socio");

SELECT * FROM mediateca.rol;

alter table mediateca.usuario add column password varchar(50) after correo;

INSERT INTO `mediateca`.`usuario`
(`id`,
`rol_id`,
`nombre`,
`apellido`,
`correo`,
`password`)
VALUES
(1,
1,
"Fabio",
"Guardado",
"fabio@mediateca.com",
"mediateca123");

select * from mediateca.usuario;
