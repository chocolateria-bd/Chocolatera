INSERT INTO BD.Cliente VALUES (24569609, 'persona');
INSERT INTO BD.Cliente VALUES (21456202, 'empresa');
INSERT INTO BD.Cliente VALUES (1, 'persona');
INSERT INTO BD.Cliente VALUES (2, 'persona');
INSERT INTO BD.Cliente VALUES (3, 'persona');
INSERT INTO BD.Cliente VALUES (4, 'persona');
INSERT INTO BD.Cliente VALUES (50, 'persona');
INSERT INTO BD.Cliente VALUES (46, 'persona');
INSERT INTO BD.Cliente VALUES (5, 'persona');
INSERT INTO BD.Cliente VALUES (54, 'persona');
INSERT INTO BD.Cliente VALUES (7, 'persona');
INSERT INTO BD.Cliente VALUES (8, 'persona');
INSERT INTO BD.Cliente VALUES (9, 'persona');
INSERT INTO BD.Cliente VALUES (19, 'persona');
INSERT INTO BD.Cliente VALUES (11, 'empresa');

INSERT INTO BD.Producto VALUES(1, 'Chocolate', 'miligramos', 10.5);
INSERT INTO BD.Producto VALUES(2, 'Postre Gazorpazorfield', 'litros', 3.14);
INSERT INTO BD.Producto VALUES(3, 'Galletas Chocolate', 'litros', 14.0);
INSERT INTO BD.Producto VALUES(4, 'Chocolate especial 42', 'gramos', 2.3);
INSERT INTO BD.Producto VALUES(5, 'Torta Numero 4', 'kilogramos', 0.5);
INSERT INTO BD.Producto VALUES(6, 'Especial Choco', 'gramos', 6.6);
INSERT INTO BD.Producto VALUES(7, 'Samba', 'mililitros', 80.56);
INSERT INTO BD.Producto VALUES(8, 'Torta Chocolatosa', 'gramos', 8.9);
INSERT INTO BD.Producto VALUES(9, 'ChocoChocolate', 'gramos', 44.5);
INSERT INTO BD.Producto VALUES(10, 'ChocoPlus', 'mililitros', 13.37);
INSERT INTO BD.Producto VALUES(11, 'Galletas Especiales', 'litros', 10.5);
INSERT INTO BD.Producto VALUES(12, 'Postre Numero 6', 'kilogramos', 10.5);

INSERT INTO BD.empresa VALUES(11, 'Chocolatera Cimarron', 'Av Bolivar');
INSERT INTO BD.empresa VALUES(21456202, 'Chocolatera Oderi', 'Av universidad');

INSERT INTO BD.maquina VALUES('A549-54', 'maquina1', FALSE);
INSERT INTO BD.maquina VALUES('CD26-54', 'maquina1', TRUE);
INSERT INTO BD.maquina VALUES('CE26-74', 'maquina1', TRUE);

INSERT INTO BD.curso VALUES('ChocoPreparacion', 'martes', '18-07-2016', '19-07-2016');
INSERT INTO BD.curso VALUES('Tortas especiales', 'lunes', '17-07-2016', '19-07-2016');

INSERT INTO BD.empleado VALUES(245, '02-11-1980', 21456202, 1600.54, '18-09-2005');
INSERT INTO BD.empleado VALUES(6234, '02-11-1985', 21456202, 30000.54, '18-09-2005');
INSERT INTO BD.empleado VALUES(6756, '05-11-1980', 11, 1600.54, '18-09-2010');

INSERT INTO BD.vende VALUES(21456202, 2, 'persona', 12, '02-05-2016', 6, 67.0);
INSERT INTO BD.vende VALUES(11, 3, 'persona', 11, '02-05-2016', 6, 80.0);
	
INSERT INTO BD.persona VALUES(2, 'Juan perez');
INSERT INTO BD.persona VALUES(3, 'Pedro');
INSERT INTO BD.persona VALUES(54, 'Mario');

INSERT INTO BD.procesa VALUES(245, 7, 'A549-54', '02-05-2016', 'etapa1', 5, 0.8);
INSERT INTO BD.procesa VALUES(6234, 7, 'A549-54', '02-05-2016', 'etapa1', 5, 0.8);
