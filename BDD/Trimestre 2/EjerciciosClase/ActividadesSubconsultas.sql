-- # Actividades subconsultas.

-- 1. Mostrar los nombres de los empleados tengan un salario mayor que el de JAMES.

SELECT ENAME FROM EMP WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'JAMES');

-- 2. Mostrar los nombres de los empleados que trabajan en el mismo departamento que SMITH. Ordena el resultado por nombre.

SELECT ENAME FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SMITH') ORDER BY ENAME;

-- 3. Mostrar los nombres de los empleados que trabajan en el mismo departamento que SMITH. Ordena el resultado.

SELECT ENAME FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SMITH') ORDER BY ENAME;

-- 4. Mostrar qué empleados fueron contratados antes que MILLER.

SELECT ENAME FROM EMP WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

-- 5. Mostrar qué empleados del departamento donde trabaja FORD, ganan más que lo que gana JAMES.

SELECT ENAME FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'FORD') AND SAL > (SELECT SAL FROM EMP WHERE ENAME = 'JAMES');

-- 6. Mostrar cómo se llama el departamento donde trabaja SCOTT.

SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');

-- 7. ¿Cuántos empleados ganan menos que MILLER?

SELECT COUNT(*) FROM EMP WHERE SAL < (SELECT SAL FROM EMP WHERE ENAME = 'MILLER');

-- 8. ¿En qué localidad trabaja KING?

SELECT LOC FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'KING');

-- 9. ¿Cómo se llaman los departamentos en los que hay algún CLERK?

SELECT DNAME FROM DEPT WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'CLERK');

-- 10. ¿Cómo se llaman los departamentos en los que no hay ningún ANALYST?

SELECT DNAME FROM DEPT WHERE DEPTNO NOT IN (SELECT DEPTNO FROM EMP WHERE JOB = 'ANALYST');