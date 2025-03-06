-- **Los dos siguientes apartados puntúan solo 0.1 puntos**
 
-- 1. Inserta el siguiente registro en la tabla platos:
 
-- - id: 6
 
-- - nombre: Solomillo a la carbonara
 
-- - precio: 6.50
 
-- - cantidad: 12
 
SELECT * FROM PLATOS;

INSERT INTO PLATOS VALUES (6, 'Solomillo a la carbonara', 6.50, 12);


-- 2. Actualiza el registro anterior de la tabla platos con los siguientes datos:
 
-- - nuevo valor de precio: 6.75

UPDATE PLATOS SET PRECIO = 6.75 WHERE ID = 6;
 
-- **Todos los apartados siguientes (28 en total) puntúan sobre 0.35 puntos**
 
-- 3. Borra el registro que creaste en el apartado 1.

DELETE FROM PLATOS WHERE ID = 6;
 
-- 4. Crea un nuevo registro en la tabla clientes con los siguientes datos:
 
-- - id: 4
 
-- - nombre: 'Luis Miguel'
 
-- - localidad: 'Gines'

SELECT * FROM CLIENTES;

ALTER TABLE CLIENTES ADD LOCALIDAD VARCHAR2(50);

INSERT INTO CLIENTES (ID, NOMBRE, LOCALIDAD) VALUES (4, 'Luis Miguel', 'Gines');
 
-- 5. Modifica el registro anterior (apartado 4) incluyendo el siguiente valor:
 
ALTER TABLE CLIENTES ADD TELEFONO CHAR(9);

UPDATE CLIENTES SET TELEFONO = '288333444' WHERE ID = 4;

-- - telefono: 288333444

COMMIT;


/*
6. Se quiere modificar el nombre de un plato (tabla platos). Se quiere cambiar el nombre del plato cuya longitud 
de caracteres es la mayor de toda la tabla, añadiendo al final del nombre '- cocina de autor'. Ej.: Entrante Crema 
de zanahorias - cocina de autor.
*/
 SELECT * FROM PLATOS;
 UPDATE PLATOS SET NOMBRE = NOMBRE || ' - cocina de autor' WHERE LENGTH(NOMBRE) = (SELECT MAX(LENGTH(NOMBRE)) FROM PLATOS);
/*
7. Se detecta una errata en la hora de la última comanda guardada el día 02-03-2021 a las 21:55. En realidad fue 
a las 22:05, cambia dicho valor de hora solo en ese registro.
*/
 SELECT * FROM COMANDAS;
 UPDATE COMANDAS SET HORA = '22:05' WHERE FECHA = '02/03/2021' AND HORA = '21:55';
 /* 
8. Indica qué modificarías de la tabla comandas si se quiere que, al borrar un cliente (registro de la tabla clientes), 
se ponga a null el campo id_cliente de todos los registros de la tabla comandas que tengan dicho id de cliente. 
No hace falta que lo hagas sobre tu sql, solo indica cómo sería tu alter table comandas.
*/
 ALTER TABLE COMANDAS DROP CONSTRAINT SYS_C008392;
 ALTER TABLE COMANDAS ADD FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTES (ID) ON DELETE SET NULL;
/*
9. Se quiere una lista con el nombre de todos los ingredientes que sean PESCADO. Debes devolver el nombre con todas 
las letras en minúsculas.
*/
 SELECT LOWER(NOMBRE) FROM INGREDIENTES WHERE CATEGORIA = 'PESCADO';
/*
10. Se quiere saber todos los estados de comandas que haya, sin repetir el valor en el resultado y ordenados en orden 
inverso al alfabético (z-a).
*/

SELECT DISTINCT ESTADO FROM COMANDAS ORDER BY ESTADO DESC;


/*
11. Se quiere saber cuántas comandas se realizaron entre las 21:10 y las 21:50 horas (ambas inclusive) el día 
01/03/21 por el id_cliente = 2.
*/
 
/*
12. Realiza la misma SQL del apartado 11 pero en lugar de usar id_cliente = 2, se quiere usar que el nombre del 
cliente sea Pedro Juan.
*/
 
/*
13. Muestra el nombre y la localidad de los clientes que vivan en Gines. Debes usar alias para nombrar las columnas, 
la primera será "Cli" y la segunda "LOC". También usa alias de tabla, llamándola datoscompletos, y úsalo para seleccionar 
las columnas nombre y localidad.
*/
 
/*
14. Muestra todos los datos de la tabla ingredientes en mayúsculas y que se encuentren en estado SOLIDO.
*/
 
/*
15. ¿Cuál es el cliente cuyo nombre tiene menos caracteres? Pon en una única columna el nombre del cliente: número 
de cara */



--Boletín de ejercicios GROUP BY
--BBDD EMP-DEPT.SQL

--1. Muestra la cantidad de empleados en cada departamento.

SELECT * FROM EMP;

SELECT DEPT.DNAME, COUNT(*) FROM EMP 
    JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO
    GROUP BY DEPT.DNAME; 

--2. Calcula el salario promedio de los empleados en cada departamento.

SELECT DEPT.DNAME, ROUND(AVG(SAL), 2) FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME;

--3. Encuentra el salario más alto y más bajo en cada departamento.

SELECT DEPT.DNAME, MAX(SAL), MIN(SAL) FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME; 

--4. Suma los salarios de todos los empleados por departamento.

SELECT DEPT.DNAME, SUM(SAL) FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME; 

--5. Cuenta cuántos empleados hay en cada tipo de cargo (JOB).

SELECT * FROM EMP;

SELECT EMP.JOB, COUNT(*) FROM EMP GROUP BY EMP.JOB;

--6. Calcula el salario promedio por cargo.

SELECT ROUND(AVG(SAL), 2), EMP.JOB FROM EMP GROUP BY EMP.JOB;

--7. Muestra solo los departamentos que tienen más de 5 empleados.

SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT DEPT.DNAME FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME HAVING COUNT(*) > 5; 

--8. Calcula el salario promedio de cada cargo y ordénalo de mayor a menor.

SELECT ROUND(AVG(SAL), 2) FROM EMP GROUP BY EMP.JOB ORDER BY AVG(SAL) DESC;

--9. Suma la comisión total otorgada en cada departamento.

SELECT * FROM EMP;

SELECT DEPT.DNAME, DECODE(SUM(EMP.COMM), NULL, 0,  SUM(EMP.COMM)) FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME;

--10. Cuenta cuántos empleados tienen comisión (COMM IS NOT NULL) y cuántos no (COMM IS NULL).

SELECT COUNT(*) || ' CON COMISION' FROM EMP WHERE COMM IS NOT NULL UNION SELECT COUNT(*) || ' SIN COMISION' FROM EMP WHERE COMM IS NULL;

--11. Cuenta cuántos empleados fueron contratados cada año.

SELECT COUNT(*), TO_CHAR(HIREDATE, 'YYYY') FROM EMP GROUP BY TO_CHAR(HIREDATE, 'YYYY');

--12. Cuenta cuántos empleados fueron contratados en cada mes.

SELECT COUNT(*), TO_CHAR(HIREDATE, 'MM') FROM EMP GROUP BY TO_CHAR(HIREDATE, 'MM');

--13. Encuentra el departamento con el mayor total de salarios.

SELECT DEPT.DNAME, SUM(EMP.SAL) FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME HAVING SUM(EMP.SAL) = ((SELECT MAX(SUM(EMP.SAL)) FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME));

--14. Encuentra el cargo con el menor salario promedio.

SELECT EMP.JOB, ROUND(AVG(EMP.SAL), 2) FROM EMP GROUP BY EMP.JOB HAVING AVG(EMP.SAL) = ((SELECT MIN(AVG(EMP.SAL)) FROM EMP GROUP BY EMP.JOB));

--15. Lista los departamentos con al menos 3 empleados.

SELECT DEPT.DNAME, COUNT(*) FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME HAVING COUNT(*) >= 3;

--16. Calcula el salario promedio de empleados que tienen comisión y los que no.

SELECT AVG(SAL) || ' CON COMISION' FROM EMP WHERE COMM IS NOT NULL UNION SELECT AVG(SAL) || ' SIN COMISION' FROM EMP WHERE COMM IS NULL;


--17. Cuenta cuántos empleados hay por combinación de cargo y departamento.



--18. Suma los salarios de los empleados por combinación de cargo y departamento.



--19. Lista los departamentos con un salario promedio mayor a 2000.

SELECT * FROM DEPT;

SELECT DEPT.DNAME FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME HAVING AVG(SAL) > 2000;

--20. Lista los departamentos donde hay al menos un empleado que gana más de 2900.

SELECT DEPT.DNAME FROM EMP JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE SAL > 2900 GROUP BY DEPT.DNAME;

-- PLSQL 

set serveroutput on;
declare
    type jefe is record(
        nombre emp.ename%type,
        codigo emp.empno%type,
        salario emp.sal%type
    );
    type empleado is record(
        nombre emp.ename%type,
        codigo emp.empno%type,
        salario emp.sal%type,
        sujefe jefe
    );
    empleado1 empleado;
    empleado2 empleado;
    jefe1 jefe;
begin
    jefe1.nombre := 'Alejandro';
    empleado1.nombre := 'Inda';
    empleado1.sujefe := jefe1;


    dbms_output.put_line(empleado1.nombre);
    dbms_output.put_line(empleado1.sujefe.nombre);

    --Empleado2, su nombre, codigo y salario sean los del empleado que haya sido contratado el primero

    SELECT EMP.ENAME, EMP.EMPNO, EMP.SAL, EMP.MGR INTO EMPLEADO2.NOMBRE, EMPLEADO2.CODIGO, EMPLEADO2.SALARIO, EMPLEADO2.SUJEFE.CODIGO FROM EMP  WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);

    DBMS_OUTPUT.PUT_LINE(EMPLEADO2.NOMBRE ||' | ' || EMPLEADO2.CODIGO || ' | ' || EMPLEADO2.SALARIO );
 
    -- EMPLEADO 2 TIENE SU JEFE, RELLENALO CON SU JEFE DE VERDAD; 

    SELECT EMP.ENAME, EMP.SAL INTO EMPLEADO2.SUJEFE.NOMBRE, EMPLEADO2.SUJEFE.SALARIO FROM EMP WHERE EMP.EMPNO = EMPLEADO2.SUJEFE.CODIGO;

    DBMS_OUTPUT.PUT_LINE(EMPLEADO2.SUJEFE.NOMBRE ||' | ' || EMPLEADO2.SUJEFE.CODIGO || ' | ' || EMPLEADO2.SUJEFE.SALARIO );


end;
/

SELECT * FROM EMP;