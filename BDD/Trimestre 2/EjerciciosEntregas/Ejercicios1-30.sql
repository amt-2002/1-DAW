--1. Obtener el nombre de todos los departamentos en minúsculas.

SELECT LOWER(DNAME) FROM DEPT;

--2. Seleccionar todos los datos de la tabla empleados (todas las columnas).

SELECT * FROM EMP;

--3. Devuelve ename, job, sal y comm de los empleando usando los siguientes alias de columnas: nombre, puesto, salario y comisión.

SELECT ENAME "NOMBRE", JOB "PUESTO", SAL "SALARIO", COMM "COMISÍON" FROM EMP;

--4. Calcula cuántas semanas completas (de lunes a domingo) ha trabajado cada empleado, y devuelve dicho valor y el nombre del empleado.

SELECT ENAME, ROUND(ABS(SYSDATE - HIREDATE) / 7) "SEMANAS TRABAJADAS" FROM EMP;

--5. Calcular el sueldo neto de cada empleado, y la retencion iRPF mensual, sabiendo que la retención es del 19% para el sueldo y de un 10% de la comisión, (redondear a 2 decimales). Si el empleado no tiene comisión, se debe mostrar el valor 0.

SELECT (SAL) "SUELDO NETO", ROUND(((SAL * 0.19) + (NVL(COMM, 0) * 0.10)), 2) "IRPF MENSUAL" FROM EMP;

--6. Hacer un listado de empleados (nombre y salario) con sueldo superior a 1000.

SELECT ENAME, SAL FROM EMP WHERE SAL > 1000; 

--7. Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan puesto igual a CLERK.

SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE JOB = 'CLERK'; 

--8. Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan puesto distinto a CLERK.

SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE JOB != 'CLERK'; 

--9. Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan puesto distinto a CLERK y sueldo superior a 1500.

SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE JOB != 'CLERK' AND SAL > 1500; 

--10. Hacer un listado de empleados (nombre, puesto, sueldo, comision) que tengan asignada comisión.

SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE COMM IS NOT NULL; 

--11. Hacer un listado de empleados (nombre, puesto, sueldo, comision) que NO tengan asignada comisión.

SELECT ENAME, JOB, SAL, COMM FROM EMP WHERE COMM IS NULL; 

--12. Seleccionar los empleados cuyo nombre empieza por 'A'.

SELECT ENAME FROM EMP WHERE ENAME LIKE 'A%'; 

--13. Seleccionar los empleados cuyo nombre tienen una A en cualquier posición.

SELECT ENAME FROM EMP WHERE ENAME LIKE '%A%';

--14. Seleccionar los empleados cuyo nombre no contiene ninguna 'A'.

SELECT ENAME FROM EMP WHERE ENAME NOT LIKE '%A%';

--15. Seleccionar los empleados cuyo nombre empieza por una vocal.

SELECT ENAME FROM EMP WHERE (SUBSTR(ENAME, 1, 1) IN ('A','E','I','O','U'));

--16. Seleccionar los empleados con sueldo entre 1000 y 2000 (ambos inclusive).

SELECT * FROM EMP WHERE SAL BETWEEN 1000 AND  2000;

--17. Seleccionar los empleados con sueldo igual a 1000, 2000, 3000, 4000 o 5000.

SELECT * FROM EMP WHERE (SAL IN (1000, 2000, 3000, 4000, 5000));

--18. Seleccionar los empleados cuyo nombre comienza por A,B,C,J,K,M.

SELECT * FROM EMP WHERE (SUBSTR(ENAME, 1, 1) IN ('A','B','C','J','K','M'));

--19. Seleccionar los empleados cuyo sueldo es la 5000/2 + 500 o 5000-1000.

SELECT * FROM EMP WHERE SAL = (5000/2 + 500) OR SAL = (5000-1000);

--20. Seleccionar los empleados cuyo sueldo es la 5000/2 + 500 ,5000-1000 o el salario máximo de todos los empleados.

SELECT * FROM EMP WHERE SAL = (5000/2 + 500) OR SAL = (5000-1000) OR SAL = (SELECT MAX(SAL) FROM EMP);


--21. Seleccionar nombre, sueldo y sueldo formateado (ej.: 1,000.00) de todos los empleados. Se puede usar las máscaras de to_number en to_char.

SELECT ENAME, SAL, TO_CHAR(SAL, '9,999.99') FROM EMP;

--22. Seleccionar nombre, sueldo y sueldo formateado con el simbolo 'Dólar' (ej.: $1,000.00) de todos los empleados. Se puede usar las máscaras de to_number en to_char.

SELECT ENAME, SAL, TO_CHAR(SAL, '$9,999.99') FROM EMP;

--23. Seleccionar nombre, sueldo y sueldo formateado con el simbolo 'Euro' (ej.: 1,000.00€ de todos los empleados. Se puede usar las máscaras de to_number en to_char.

ALTER SESSION SET NLS_CURRENCY = '€';
SELECT ENAME, SAL, TO_CHAR(SAL, '9,999.99L') FROM EMP;

--24. Seleccionar la fecha del sistema (día, mes, año, horas (24):minutos:segundos).

SELECT TO_CHAR(SYSDATE, 'DD, MM, YYYY, "("HH24")":MI:SS') FROM EMP;

--25. Seleccionar la fecha del sistema (nombre del día, día, nombre del mes, año, horas (24):minutos:segundos). No debe haber espacios sobrantes en el nombre del día o del mes.

-- SELECT TO_CHAR(SYSDATE, 'DAY, DD, MONTH, YYYY, "("HH24")":MI:SS') FROM EMP;

SELECT TO_CHAR(SYSDATE, 'DAY DD') || ', '|| TRIM(TO_CHAR(SYSDATE, 'MONTH')) || ', ' || TO_CHAR(SYSDATE, 'YYYY, "("HH24")":MI:SS') FROM EMP;

--26. Mostrar la fecha del día "1 de enero de 2005", usando una tira de caracteres y su máscara de formato (ej.: 01012021), convertirlo en fecha y empleado en el to_char. No deben aparecer espacios adicionales en el nombre del mes.

SELECT TO_CHAR(TO_DATE('01012005', 'DDMMYYYY'), 'DD "DE" MONTH "DE" YYYY') "FECHA" FROM DUAL;


--27. Calcular el número de días vividos hasta hoy por una persona nacida el día 3 de julio de 1970.

SELECT ROUND(ABS(TO_DATE('3/7/1970', 'DD/MM/YYYY') - SYSDATE)) || ' DIAS' "DIAS" FROM DUAL;

--28. Calcular el número de segundos transcurridos desde la última medianoche (máscara 'sssss' en to_char).

SELECT TO_CHAR(SYSDATE, 'SSSSS') FROM DUAL;

--29. Calcular el número horas completas transcurridas desde la última medianoche.

SELECT TO_CHAR(SYSDATE, 'HH24') FROM DUAL;

--30. Calcular el número de meses transcurridos entre la fecha de contratación de cada empleado y hoy.

SELECT ENAME, CEIL((((SYSDATE - HIREDATE) / 7) / 4)) || ' MESES' "MESES" FROM EMP;