--31. Calcular el último dia del mes (fecha) del mes actual.

SELECT LAST_DAY(SYSDATE) FROM DUAL;

--32. Calcular el último dia del mes (fecha) del mes actual, con horas, minutos y segundos.

SELECT LAST_DAY(SYSDATE) || ' - ' || TO_CHAR(LAST_DAY(SYSDATE),'"("HH24")"') || ' ' || TO_CHAR(LAST_DAY(SYSDATE),'MI') || ' ' || TO_CHAR(LAST_DAY(SYSDATE),'SS') "HORAS" FROM DUAL;

--33. Calcular en qué MES (cifras) se ha contratado cada empleado.

SELECT ENAME "Nombre", TO_CHAR(HIREDATE, 'MM') || ' - ' || TO_CHAR(HIREDATE,'MONTH') "MES" FROM EMP;

--34. Calcular cuánto debería haber cobrado cada empleado en su primer año de trabajo (desde la fecha de contrato hasta el 31 de diciembre de ese año).

SELECT ENAME, TO_CHAR(CEIL(((TO_DATE(SYSDATE) - TO_DATE(HIREDATE))/7)/4) * SAL, '9999999L') "Salario" FROM EMP;

--35. Cuántos oficios distintos hay en la tabla de empleados.

SELECT DISTINCT(JOB)"Oficios" FROM EMP;

--36. Calcular el IRPF de cada empleado, teniendo en cuenta que para los 'CLERK' se les retiene un 15%, y a los 'ANALYST" un 20%. Al resto se les retiene un 19%.

SELECT ENAME, DECODE(JOB, 'CLERK', SAL*0.15, 'ANALYST',SAL*0.20,SAL*0.19) "IRPF" FROM EMP;

--37. Efectuar una propuesta de aumento salarial: Para los empleados del Dept. 10 un 5%, Dept. 20 un 7%, Dept 30 un 8% y al resto un 3% del salario.

SELECT ENAME,DECODE(EMP.DEPTNO,10,EMP.SAL * 0.05, 20,EMP.SAL*0.08, EMP.SAL*0.3) "Aumento" ,(DECODE(EMP.DEPTNO,10,EMP.SAL * 0.05, 20,EMP.SAL*0.08, EMP.SAL*0.3)) + SAL "Salario completo" FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO;

--38. Listar los nombres de los empleados, identificando como 'Vendedor' si cobra comisión, y 'No vendedor' si no la cobra.

SELECT ENAME, DECODE(COMM,NULL,'NO VENDEDOR','VENDEDOR') FROM EMP;

--39. Calcular cuánto se paga mensualmente a todos los empleados.

SELECT SUM(SAL) "Suma Salarios" FROM EMP;

--40. Calcular cuántos empleados hay.

SELECT COUNT(*) "Empleados" FROM EMP;

--41. Calcular el sueldo medio de todos los empleados.

SELECT ROUND(AVG(SAL),2) "Sueldo medio" FROM EMP;

--42. Calcular la comisión media de todos los empleados (teniendo en cuenta aquellos que no tienen comisión).

SELECT AVG(COMM) FROM EMP;

--43. Calcular la comisión media de los empleados que sí tienen comisión.

SELECT AVG(COMM) FROM EMP WHERE COMM IS NOT NULL OR COMM != 0;

--44. Calcular la suma de los sueldos de los empleados del Departamento 20.

SELECT SUM(SAL) "Suma Salarios" FROM EMP WHERE DEPTNO = 20;


--45. Calcular el sueldo medio de los empleados que pertenezcan al Dept 10 o 30.

SELECT ROUND(AVG(SAL),2)"Sueldo Medio" FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

--46. Calcular la suma de sueldos que se pagan en cada uno de los departamentos 10 y 30 (por separado).

SELECT DEPTNO"Departamento",SUM(SAL)"Salario" FROM EMP  GROUP BY DEPTNO WHERE DEPTNO = 10 OR DEPTNO = 30;

--47. Calcular cuántos empleados se han contratado cada año.

SELECT DISTINCT(TO_CHAR(HIREDATE,'YYYY'))"Años",COUNT(*)"Contador" FROM EMP GROUP BY TO_CHAR(HIREDATE,'YYYY') ORDER BY TO_CHAR(HIREDATE,'YYYY') ASC;

--48. Calcular el sueldo máximo y mínimo de cada departamento.

SELECT DEPT.DNAME,  TRIM(TO_CHAR(MAX(SAL),'99999L')) || ' | ' ||TRIM(TO_CHAR(MIN(SAL),'99999L')) "Max -  Min" FROM EMP JOIN DEPT ON EMP.DEPTNO = DEPT.DEPTNO GROUP BY EMP.DEPTNO,DEPT.DNAME;

--49. Calcular cuánto se gana de media por cada oficio. Redondear a 2 decimales.

SELECT JOB, TO_CHAR(ROUND(AVG(SAL),2),'99999L')"MEDIA" FROM EMP GROUP BY JOB;

--50. Cuántos días de vacaciones correspondieron a cada empleado el primer año de trabajo (contando 1 día por semana entera trabajada).

SELECT ENAME, FLOOR((SYSDATE - HIREDATE) / 7) "Días de Vacaciones" FROM EMP;
