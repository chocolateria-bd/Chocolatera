SELECT pc.etapa, e.ci FROM BD.procesa pc
	INNER JOIN BD.producto p
	ON p.codigo = pc.codigo
	INNER JOIN BD.empleado e
	ON pc.ci = e.ci
	INNER JOIN BD.empresa empr
	ON empr.rif = e.rif	
WHERE p.valor = (SELECT MAX(valor) FROM BD.producto);