/*falta verificar unos atributos que son no obligatorios y con respecto a los tipos, ruta, ingredientes,cantidad no se como lo modelamos no recuerdo
 su tipo ni el domino de los tipos, faltaria ver los incidentes y otras cosas, los atributos que estan en blanco son lo que tengo duda de como lo modelamos
 revisen y luego corran esto que yo no tengo linux y lo hice en windows y no probe nada */

create database proyectobd template template1;

\c proyectobd

CREATE SCHEMA BD;

CREATE TYPE tcliente AS ENUM ('persona', 'empresa');
CREATE TYPE tunidades AS ENUM('miligramos', 'gramos', 'kilogramos', 'mililitros', 'litros');
CREATE TYPE tmaquina AS ENUM('maquina1');
CREATE TYPE tetapa AS ENUM('etapa1');
CREATE TYPE daysOfTheWeek AS ENUM('lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo');

CREATE DOMAIN BD.T_identificador varchar(9);
CREATE DOMAIN BD.T_codigo smallint
		CHECK (value >0);            /* domino para los codigos asumimos que son de 5 digitos! */
CREATE DOMAIN BD.T_string varchar(60);	/*dominio de string para los nombres y todo lo que tenga que ver con string tamaño 60*/
CREATE DOMAIN BD.T_fecha timestamp
		CHECK (VALUE >= '1900-01-01');/*dominio de tipo fecha para todas las fechas 0000-00-00 empieza en 1900-01-01 */
CREATE DOMAIN BD.T_moneda float
		CHECK (value >= 0.0);/* dominio para el sueldo y los precios*/
CREATE DOMAIN BD.T_cliente tcliente; /* dominio para la hora (solo hora no fecha) */
CREATE DOMAIN BD.T_unidades tunidades; /*dominio para la hora (solo hora no fecha) */
CREATE DOMAIN BD.T_maquina tmaquina;
CREATE DOMAIN BD.T_etapa tetapa;
CREATE DOMAIN BD.T_daysOfTheWeek daysOfTheWeek;


CREATE TABLE BD.Cliente(
	codigo BD.T_identificador,  /*rif o cedula*/
	tipo BD.T_cliente,
	primary key(codigo)
);

CREATE TABLE BD.Empresa(
	rif BD.T_identificador,
	nombre BD.T_string unique,
	direccion BD.T_string,
	primary key(rif),
	FOREIGN KEY (rif) REFERENCES BD.Cliente ON DELETE CASCADE
);

CREATE TABLE BD.Persona(
	ci BD.T_identificador,
	nombre BD.T_string,
	primary key (ci),
	foreign key(ci) references BD.Cliente on delete cascade
);

CREATE TABLE BD.Producto(
	codigo BD.T_codigo,
	nombre BD.T_string,
	tipo BD.T_unidades,
	valor BD.T_moneda,
	primary key (codigo)
);

CREATE TABLE BD.Receta(
	codigo_ingrediente BD.T_codigo,
	codigo_resultado BD.T_codigo,
	cantidad int CHECK (cantidad >= 1),
	primary key (codigo_ingrediente,codigo_resultado),
	FOREIGN KEY (codigo_ingrediente) REFERENCES BD.Producto ON DELETE CASCADE,
	FOREIGN KEY (codigo_resultado) REFERENCES BD.Producto ON DELETE CASCADE
);

CREATE TABLE BD.Empleado(
	ci BD.T_identificador,
	fecha_nac BD.T_fecha,
	rif BD.T_identificador,
	sueldo BD.T_moneda,
	fecha_de_contrato BD.T_fecha,
	fecha_fin_contrato BD.T_fecha,
	primary key (ci),
	FOREIGN KEY (rif) REFERENCES BD.Empresa ON DELETE CASCADE
);

CREATE TABLE BD.Curso(
	nombre BD.T_string,
	dia BD.T_daysOfTheWeek,
	inicio BD.T_fecha,
	fin BD.T_fecha,
	primary key (nombre)
);

CREATE TABLE BD.Cursa(
	ci BD.T_identificador,
	nombre_curso BD.T_string,
	primary key (ci,nombre_curso),
	FOREIGN KEY (ci) REFERENCES BD.Empleado ON DELETE CASCADE,
	FOREIGN KEY (nombre_curso) REFERENCES BD.Curso ON DELETE CASCADE
);

CREATE TABLE BD.Escuela(
	nombre BD.T_string,
	direccion BD.T_string,
	primary key (nombre,direccion)
);

CREATE TABLE BD.Dicta(
	ci BD.T_identificador,
	nombre_curso BD.T_string,
	nombre_escuela BD.T_string,
	direccion BD.T_string,
	primary key (ci,nombre_curso,nombre_escuela,direccion),
	FOREIGN KEY (ci) REFERENCES BD.Empleado ON DELETE CASCADE,
	FOREIGN KEY (nombre_curso) REFERENCES BD.Curso ON DELETE CASCADE,
	FOREIGN KEY (nombre_escuela,direccion) REFERENCES BD.Escuela ON DELETE CASCADe
);



CREATE TABLE BD.Evento(
	nombre BD.T_string,
	fecha BD.T_fecha,
	primary key (nombre,fecha)
);

CREATE TABLE BD.Concursa(
	codigo BD.T_codigo,
	nombre_evento BD.T_string,
	fecha BD.T_fecha,
	ganador BD.T_string,
	primary key (codigo,nombre_evento,fecha),
	FOREIGN KEY (codigo) REFERENCES BD.Producto ON DELETE CASCADE,
	FOREIGN KEY (nombre_evento,fecha) REFERENCES BD.Evento ON DELETE CASCADE
);

CREATE TABLE BD.Maquina(
	placa BD.T_string,
	tipo BD.T_maquina,
	importado boolean,
	primary key (placa)
);

CREATE TABLE BD.Procesa(
	ci BD.T_identificador,
	codigo BD.T_codigo,
	placa BD.T_string,
	fecha BD.T_fecha,
	etapa BD.T_etapa,
	cantidad int CHECK  (cantidad >= 0),
	calidad	real CHECK (calidad >= 0 AND calidad <= 1),
	primary key (ci,codigo,placa,fecha),
	FOREIGN KEY (ci) REFERENCES BD.Empleado ON DELETE CASCADE,
	FOREIGN KEY (codigo) REFERENCES BD.Producto ON DELETE CASCADE
);

CREATE TABLE BD.Distribuye(
	ci BD.T_identificador,
	codigo BD.T_codigo,
	rif BD.T_identificador,
	ruta varchar(100),
	cantidad	int CHECK (cantidad >= 0),
	fecha_envio BD.T_fecha,
	incidentes text,
	fecha_recepcion BD.T_fecha,
	primary key (ci,codigo,rif),
	FOREIGN KEY (ci) REFERENCES BD.Empleado ON DELETE CASCADE,
	FOREIGN KEY (codigo) REFERENCES BD.Producto ON DELETE CASCADE,
	FOREIGN KEY (rif) REFERENCES BD.Empresa ON DELETE CASCADE

);

CREATE TABLE BD.Vende(
	rif BD.T_identificador,
	codigo_cliente BD.T_identificador,
	tipo BD.T_cliente,
	codigo_producto BD.T_codigo,
	fecha BD.T_fecha,
	cantidad int,
	precio BD.T_moneda,
	primary key (rif,codigo_cliente,codigo_producto,fecha),
	FOREIGN KEY (codigo_producto) REFERENCES BD.Producto ON DELETE CASCADE,
	FOREIGN KEY (codigo_cliente) REFERENCES BD.Cliente ON DELETE CASCADE,
	FOREIGN KEY (rif) REFERENCES BD.Empresa ON DELETE CASCADE
);

CREATE TABLE BD.Premio(
	nombre BD.T_string,
	nombre_evento BD.T_string,
	fecha_evento BD.T_fecha,
	primary key (nombre,nombre_evento,fecha_evento),
	FOREIGN KEY (nombre_evento,fecha_evento) REFERENCES BD.Evento ON DELETE CASCADE
);

CREATE TABLE BD.Pais_evento(
	nombre_pais BD.T_string,
	nombre_evento BD.T_string,
	fecha_evento BD.T_fecha,
	primary key (nombre_pais,nombre_evento,fecha_evento),
	FOREIGN KEY (nombre_evento,fecha_evento) REFERENCES BD.Evento ON DELETE CASCADE
);

CREATE ROLE administrador;
GRANT ALL ON DATABASE proyectobd TO administrador;
GRANT ALL ON SCHEMA bd TO administrador;
GRANT ALL ON TABLE
BD.producto, BD.cliente, BD.empresa, BD.maquina, BD.curso, BD.empleado, BD.vende, BD.persona, BD.procesa
to administrador;

CREATE ROLE usuario;
GRANT ALL ON DATABASE proyectobd TO usuario;
GRANT ALL ON SCHEMA bd TO usuario;
GRANT SELECT ON TABLE
BD.producto, BD.cliente, BD.empresa, BD.maquina, BD.curso, BD.empleado, BD.vende, BD.persona, BD.procesa
to usuario;

CREATE USER chocoadmin IN ROLE administrador PASSWORD '123';
-- ALTER ROLE chodoAdmin with SUPERUSER;

CREATE USER chocousuario IN ROLE usuario PASSWORD '1234';
