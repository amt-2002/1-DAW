SELECT * FROM EQUIPOS;
SELECT DECODE(PRESUPUESTO, 1000000, 1000 || 'k', 2000000, 2000 || 'k', 3000000, 3000 || 'k') "SALARIOS" FROM EQUIPOS;