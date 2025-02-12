--101. Listar las diferentes ciudades de la tabla sin repetición explícitamente (aunque no haya datos que se repitan).

SELECT DISTINCT LOC FROM DEPT;

--102. Listar el nombre de departamento y nombre de ciudad para los departamentos ubicados en New York y Dallas.

SELECT DNAME, LOC FROM DEPT WHERE LOC IN ('NEW YORK', 'DALLAS');

--103. Seleccionar el nombre de los empleados y el nombre de la ciudad donde está el departamento al que pertenecen.

SELECT E.ENAME, D.LOC FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO;

--104. Listar el nombre de los trabajadores, puesto, nombre del departamento y ciudad del departamento de aquellos que no son MANAGER.

SELECT E.ENAME, E.JOB, D.DNAME, D.LOC FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.JOB != 'MANAGER';

--105. Listar el nombre de los trabajadores, puesto, nombre del departamento y ciudad del departamento de aquellos que no son ni ANALYST ni CLERK.

SELECT E.ENAME, E.JOB, D.DNAME, D.LOC FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.JOB NOT IN ('ANALYST', 'CLERK');

--106. Seleccionar el nombre del empleado, código y nombre del departamento al que pertenecen los empleados.

SELECT E.ENAME, E.DEPTNO, D.DNAME FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO;

--107. Seleccionar el nombre de los empleados que trabajan en el departamento cuyo código es el más bajo de todos los existentes (utiliza subconsultas).

SELECT E.ENAME FROM EMP E WHERE E.DEPTNO = (SELECT MIN(DEPTNO) FROM DEPT);

--108. Seleccionar nombre de empleado, nombre de departamento y ubicación del departamento para los empleados que tienen comisión.

SELECT E.ENAME, D.DNAME, D.LOC FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.COMM IS NOT NULL;

--109. Seleccionar nombre de empleado, nombre de departamento y localización, para los empleados que no tienen comisión (o esta vale cero).

SELECT E.ENAME, D.DNAME, D.LOC FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.COMM IS NULL OR E.COMM = 0;

--110. Seleccionar nombre de empleado y nombre de departamento para los empleados que tengan una 'A' en su nombre.

SELECT E.ENAME, D.DNAME FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.ENAME LIKE '%A%';

--111. Seleccionar nombre de empleado y nombre departamento para los empleados que tengan una vocal al menos (A, E, I, O, U) en su nombre.

SELECT E.ENAME, D.DNAME FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE E.ENAME LIKE '%A%' OR E.ENAME LIKE '%E%' OR E.ENAME LIKE '%I%' OR E.ENAME LIKE '%O%' OR E.ENAME LIKE '%U%';

--112. Seleccionar nombre y puesto de empleado, código de departamento y nombre de departamento de los empleados cuyo departamento está ubicado en 'Chicago'. Todos los valores deben devolverse en minúsculas.

SELECT LOWER(E.ENAME), LOWER(E.JOB), E.DEPTNO, LOWER(D.DNAME) FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE D.LOC = 'CHICAGO';

--113. Seleccionar nombre, código de empleado, nombre de su jefe y código de empleado de su jefe para todos los empleados (no se deben mostrar los que no tienen jefe).

SELECT E.ENAME, E.EMPNO, E2.ENAME, E2.EMPNO FROM EMP E JOIN EMP E2 ON E.MGR = E2.EMPNO;

--114. Seleccionar nombre, código de empleado, nombre de su jefe y código de empleado de su jefe para todos los empleados (se deben mostrar TODOS, incluso los que no tienen jefe).

SELECT E.ENAME, E.EMPNO, E2.ENAME, E2.EMPNO FROM EMP E LEFT JOIN EMP E2 ON E.MGR = E2.EMPNO;

--115. Seleccionar código departamento, nombre de empleado y nombre de jefe de cada empleado del departamento que está en BOSTON.

SELECT DEPT.DEPTNO, EMP.ENAME, E2.ENAME FROM EMP LEFT JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO LEFT JOIN EMP E2 ON E2.DEPTNO = DEPT.DEPTNO WHERE DEPT.LOC = 'BOSTON' AND EMP.MGR = E2.EMPNO;

--116. Seleccionar nombre y fecha contrato de los empleados contratados posteriormente al empleado 'WARD'.

SELECT ENAME, HIREDATE FROM EMP WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'WARD');

--117. Seleccionar nombre y fecha de contrato de los empleados, además del nombre y fecha de contrato de su jefe, siempre y cuando la fecha del contrato del empleado fuera anterior a la fecha de contrato de su jefe.

SELECT E.ENAME, E.HIREDATE, E2.ENAME, E2.HIREDATE FROM EMP E JOIN EMP E2 ON E.MGR = E2.EMPNO WHERE E.HIREDATE < E2.HIREDATE;

--118. Listar todos los nombres cuya longitud sea menor que la media de todas las longitudes de nombres de empleados redondeado al entero superior.

SELECT ENAME FROM EMP WHERE LENGTH(ENAME) < (SELECT CEIL(AVG(LENGTH(ENAME))) FROM EMP);

--119. Seleccionar el nombre de los empleados y el nombre del departamento al que pertenecen, siempre y cuando el nombre del departamento comience por la letra 'S'.

SELECT E.ENAME, D.DNAME FROM EMP E LEFT JOIN DEPT D ON E.DEPTNO = D.DEPTNO WHERE D.DNAME LIKE 'S%';
