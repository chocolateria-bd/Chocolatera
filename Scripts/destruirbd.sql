WITH RECURSIVE cte AS (
   SELECT oid FROM pg_roles WHERE rolname = 'administrador'

   UNION ALL
   SELECT m.roleid
   FROM   cte
   JOIN   pg_auth_members m ON m.member = cte.oid
)
SELECT oid FROM cte;
SELECT a.oid FROM pg_authid a WHERE pg_has_role('usuario', a.oid, 'member');
DROP USER chocoadmin;
DROP USER chocousuario;

REVOKE ALL PRIVILEGES ON DATABASE proyectobd FROM administrador;
REVOKE ALL PRIVILEGES ON SCHEMA bd FROM administrador;
REVOKE ALL PRIVILEGES ON
BD.producto
FROM administrador;
DROP ROLE administrador;

REVOKE ALL PRIVILEGES ON DATABASE proyectobd FROM usuario;
REVOKE ALL PRIVILEGES ON SCHEMA bd FROM usuario;
REVOKE ALL PRIVILEGES ON
BD.producto
FROM usuario;
DROP ROLE usuario;

DROP TABLE BD.Pais_evento CASCADE;
DROP TABLE BD.Premio CASCADE;
DROP TABLE BD.Vende CASCADE;
DROP TABLE BD.Distribuye CASCADE;
DROP TABLE BD.Procesa CASCADE;
DROP TABLE BD.Maquina CASCADE;
DROP TABLE BD.Concursa CASCADE;
DROP TABLE BD.Evento CASCADE;
DROP TABLE BD.Dicta CASCADE;
DROP TABLE BD.Escuela CASCADE;
DROP TABLE BD.Cursa CASCADE;
DROP TABLE BD.Curso CASCADE;
DROP TABLE BD.Empleado CASCADE;
DROP TABLE BD.Receta CASCADE;
DROP TABLE BD.Producto CASCADE;
DROP TABLE BD.Persona CASCADE;
DROP TABLE BD.Empresa CASCADE;
DROP TABLE BD.Cliente CASCADE;


DROP DOMAIN BD.T_etapa;
DROP DOMAIN BD.T_maquina;
DROP DOMAIN BD.T_unidades;
DROP DOMAIN BD.T_cliente;
DROP DOMAIN BD.T_time;
-- DROP DOMAIN BD.T_sueldo;
DROP DOMAIN BD.T_moneda;
DROP DOMAIN BD.T_fecha;
DROP DOMAIN BD.T_string;
DROP DOMAIN BD.T_codigo;
DROP DOMAIN BD.T_daysOfTheWeek;
DROP DOMAIN BD.T_identificador;



DROP TYPE tcliente CASCADE;
DROP TYPE tunidades CASCADE;
DROP TYPE tmaquina CASCADE;
DROP TYPE tetapa CASCADE;
DROP TYPE daysOfTheWeek CASCADE;

DROP SCHEMA BD CASCADE;

\c postgres

DROP DATABASE proyectobd;
