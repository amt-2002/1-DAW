--51. ¿Qué día de la semana se contrató a cada empleado?

SELECT ENAME, TO_CHAR(HIREDATE, 'DAY') AS "Día de la semana" FROM EMP;

--52. Calcular la paga de beneficios que corresponde a cada empleado (3 salarios mensuales incrementados un: 10% para PRESIDENT, 20% para los MANAGER, 30% para el resto).

SELECT * FROM EMP;

SELECT DECODE(JOB, 'PRESIDENT', SAL + (SAL * 0.10), 'MANAGER', SAL + (SAL * 0.20), SAL + (SAL * 0.30)) "BENEFICIOS" FROM EMP;

--53. Cuantos días han pasado desde el 25 julio de 1992.

SELECT CEIL(SYSDATE - TO_DATE('25-07-1992')) FROM DUAL;

--54. Seleccionar el nombre de cada empleado junto al nombre del departamento en el que está.

SELECT * FROM DEPT;

SELECT EMP.ENAME, DEPT.DNAME FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO;

--55. Seleccionar el nombre y puesto de cada empleado junto al nombre del departamento al que pertenece y la localización del departamento.

SELECT * FROM DEPT;
SELECT EMP.ENAME, EMP.JOB, DEPT.DNAME, DEPT.LOC FROM EMP 
    LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO;

--56. Seleccionar el nombre de cada empleado, el nombre de! departamento al que pertenece, y el código de departamento del empleado.

SELECT EMP.ENAME, DEPT.DNAME, EMP.DEPTNO FROM EMP 
    LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO;

--57. Listar el nombre del empleado y el nombre de su jefe.

SELECT * FROM EMP;
SELECT E.ENAME, E2.ENAME FROM EMP E, EMP E2 WHERE E2.EMPNO = E.MGR;

--58. Listar el nombre del empleado y el nombre de su jefe. Incluir empleados que no tengan jefe.

SELECT E.ENAME, E2.ENAME FROM EMP E, EMP E2 WHERE E2.EMPNO = E.MGR OR E.MGR IS NULL;

--59. Seleccionar nombre del empleado, nombre del jefe, fechas contrato del trabajador y del jefe, de forma que la fecha de contrato del empleado sea anterior a la de su jefe.

SELECT E.ENAME, E2.ENAME, E.HIREDATE, E2.HIREDATE FROM EMP E, EMP E2 WHERE E2.EMPNO = E.MGR AND E.HIREDATE < E2.HIREDATE;

--60. Seleccionar nombre del empleado, nombre del jefe, salarios del trabajador y del jefe, de forma que el sueldo del empleado sea inferior a la mitad del salario de su jefe.

SELECT E.ENAME, E2.ENAME, E.SAL, E2.SAL FROM EMP E, EMP E2 WHERE E2.EMPNO = E.MGR AND E.SAL < E2.SAL / 2;

--61. Seleccionar las distintas ubicaciones de los departamentos.

SELECT DISTINCT LOC FROM DEPT;

--62. Seleccionar la ubicación y el nombre empleado. Incluir también las ubicaciones de departamentos sin empleados.

SELECT LOC, ENAME FROM DEPT LEFT JOIN EMP ON DEPT.DEPTNO = EMP.DEPTNO;

--63. Seleccionar el nombre de los empleados, y el departamento al que pertenecen, para los empleados que ganan menos de 1000$.

SELECT EMP.ENAME, DEPT.DNAME FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE EMP.SAL < 1000;

--64. Seleccionar el nombre del empleado, y el departamento al que pertenecen, para los empleados que ganan más de 1000$.

SELECT EMP.ENAME, DEPT.DNAME FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE EMP.SAL > 1000;

--65. Consultar todos los valores de la tabla emp.

SELECT * FROM EMP;

--66. Listar el nombre, el oficio y sueldo de los empleados.

SELECT ENAME, JOB, SAL FROM EMP;

--67. Calcular el sueldo anual que percibe cada empleado.

SELECT ENAME, SAL * 12 FROM EMP;

--68. Consultar los datos de la tabla DEPT.

SELECT * FROM DEPT;

--69. Listar los diferentes puestos de los empleados sin repetir.

SELECT DISTINCT JOB FROM EMP;

--70. Listar en una sola columna el nombre y el puesto de cada empleado.

SELECT ENAME || ' - ' || JOB FROM EMP;

--71. Listar todas las columnas de la tabla EMP en una única columna, separando cada campo por comas.

SELECT ENAME || ', ' || JOB || ', ' || MGR || ', ' || HIREDATE || ', ' || SAL || ', ' || COMM || ', ' || DEPTNO FROM EMP;

--72. Listar el nombre y sueldo de los empleados que ganan más de 2000$.

SELECT ENAME, SAL FROM EMP WHERE SAL > 2000;

--73. Listar el nombre y código de de departamento del empleado con id=30.

SELECT EMP.ENAME, DEPT.DEPTNO FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE DEPT.DEPTNO = 30;

--74. Listar el nombre y sueldo de los empleados que NO ganan entre 5000 y 12000 dólares. Muestra el sueldo con el símbolo de $ delante de la cifra.

SELECT ENAME, TO_CHAR(SAL, '$9999') FROM EMP WHERE SAL NOT BETWEEN 5000 AND 12000;

--75. Listar el nombre, puesto y fecha contrato de los empleados contratados entre el 20 febrero 1981 y el 1 de mayo de 1981. Ordenar por fecha descendente.

SELECT ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE BETWEEN TO_DATE('20-02-1981', 'DD-MM-YYYY') AND TO_DATE('01-05-1981', 'DD-MM-YYYY') ORDER BY HIREDATE DESC;

--76. Listar el nombre y el cod departamento de los empleados pertenecientes a los departamentos 20 o 40.

SELECT EMP.ENAME, DEPT.DEPTNO FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE DEPT.DEPTNO IN (20, 40);

--77. Listar el nombre (alias: Empleado) y sueldo (alias: Salario mensual) de los empleados pertenecientes a los departamentos 20 o 40, que ganen entre 2000 y 4000 dólares.

SELECT EMP.ENAME "Empleado", EMP.SAL "Salario mensual" FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE DEPT.DEPTNO IN (20, 40) AND EMP.SAL BETWEEN 2000 AND 4000;

--78. Listar el nombre y fecha contrato de empleados contratados el año 1984.

SELECT ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = '84';

--79. Listar el nombre y el puesto de los empleados que no tengan jefe asignado.

SELECT ENAME, JOB FROM EMP WHERE MGR IS NULL;

--80. Listar el nombre, sueldo y % comisión de los empleados que cobran comisión. Ordenar por salario y comisión, de forma que los más altos salgan primero.

SELECT ENAME, SAL, COMM FROM EMP WHERE COMM IS NOT NULL ORDER BY SAL DESC, COMM DESC;

--81. Listar el nombre de los empleados que tengan una 'A' en la tercera letra del nombre.

SELECT ENAME FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'A';

--82. Listar el nombre de los empleados que tengan una 'A' y una 'E' en el nombre.

SELECT ENAME FROM EMP WHERE ENAME LIKE '%A%' AND ENAME LIKE '%E%';

--83. Listar el nombre, puesto y sueldo de los empleados 'CLERK' o 'SALESMAN', y con salario distinto de: 2500, 3500 y 7000.

SELECT ENAME, JOB, SAL FROM EMP WHERE JOB IN ('CLERK', 'SALESMAN') AND SAL NOT IN (2500, 3500, 7000);

--84. Listar el nombre (alias: Empleado), sueldo (alias: Salario mensual) y nombre del departamento de todos los empleados cuya comisión sea mayor de 400.

SELECT EMP.ENAME "Empleado", EMP.SAL "Salario mensual", DEPT.DNAME FROM EMP LEFT JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO WHERE EMP.COMM > 400;

--85. Listar el nombre y salario de los empleados, de forma que estén separados por una línea de puntos, y que de extremo a extremo haya 30 caracteres (por ejemplo: "KING......................5000").

SELECT (RPAD(ENAME, 30 - LENGTH(SAL), '.') || SAL) FROM EMP;

--86. Listar los nombres de los empleados, reemplazando la letra 'A' por un '1'.

SELECT REPLACE(ENAME, 'A', '1') FROM EMP;

--87. Obtener la fecha del sistema (hoy) con alias: Fecha en el formato por defecto (sin tocar nada).

SELECT SYSDATE AS "Fecha" FROM DUAL;

--88. Listar el id, nombre, salario de los empleados, y además otra columna con el salario incrementado un 15% su valor y redondeado (alias: Nuevo salario).

SELECT EMPNO, ENAME, SAL, ROUND(SAL + (SAL * 0.15)) "Nuevo salario" FROM EMP;

--89. Listar el id, nombre, salario de los empleados, el salario incrementado un 15% redondeado (alias: Nuevo salario) y además otra columna con la cuantía del incremento (alias: Incremento).

SELECT EMPNO, ENAME, SAL, ROUND(SAL + (SAL * 0.15)) "Nuevo salario", ROUND(SAL * 0.15) "Incremento" FROM EMP;

--90. Listar el nombre y longitud del nombre de los empleados que empiecen por A, o M. (Los nombres tendrán la inicial en mayúscula y el resto en minúsculas).

SELECT INITCAP(ENAME), LENGTH(ENAME) FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'M%';

--91. Listar el nombre y número de meses trabajados, redondeando al entero superior. Ordenar por número de meses trabajados, de menor a mayor.

SELECT ENAME, CEIL(MONTHS_BETWEEN(SYSDATE, HIREDATE)) FROM EMP ORDER BY CEIL(MONTHS_BETWEEN(SYSDATE, HIREDATE));

--92. Componer una frase con el nombre, salario actual y el triple del salario de los empleados. Por ejemplo: "KING gana 5000 mensuales, pero querría ganar 15000" (alias: Sueldos soñados).

SELECT ENAME || ' gana ' || SAL || ' mensuales, pero querría ganar ' || SAL * 3 AS "Sueldos soñados" FROM EMP;

--93. Listar el nombre y salario de los empleados, rellenando por la izquierda hasta 15 caracteres con el s�mbolo "$".

SELECT LPAD(ENAME, 15, '$') FROM EMP;

--94. Listar nombre, fecha contrato y fecha revisión contrato de los empleados, sabiendo que la revisión será el lunes siguiente a la fecha que cumple 6 meses de trabajo en la empresa.
--Formatear esta fecha de acuerdo con el ejemplo: 'Lunes, 12th de noviembre de 2005'.

SELECT ENAME, 
    HIREDATE, 
    TRIM(TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 6), 'MONDAY'), 'Day')) || ', ' || 
    TRIM(TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 6), 'MONDAY'), 'ddth')) || ' de ' || 
    TRIM(TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 6), 'MONDAY'), 'Month')) || ' de ' || 
    TRIM(TO_CHAR(NEXT_DAY(ADD_MONTHS(HIREDATE, 6), 'MONDAY'), 'YYYY')) "Fecha revisión contrato"
FROM EMP;

--95. Listar nombre, fecha contrato y día de la semana en que fueron contratados los empleados, ordenando por día de la semana, de forma que queden ordenados por lunes, martes, miércoles, jueves, viernes, sábado y domingo.

SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'DAY') AS "Día de la semana" FROM EMP ORDER BY TO_CHAR(HIREDATE, 'D');

--96. Listar nombre y comisión de los empleados. En el caso de que no gane comisión, sacar la frase "Sin comisión".

SELECT ENAME, NVL(TO_CHAR(COMM), 'Sin comisión') FROM EMP;

--97. Listar nombre de los empleados, y una tira de asteriscos, de forma que haya un asterisco por cada 1000$ (redondeada) que gana el empleado. Titula la columna 'Empleado y su salario'. Ordenar esta
--columna de forma que los que m�s ganan aparezcan primero. Los nombres deben quedar ajustados a la longitud del nombre más largo. Ej.: "KING..:  ****"

SELECT ENAME || RPAD('.', LENGTH((SELECT MAX(ENAME) FROM EMP)), '.') || ':' || RPAD('*', ROUND(SAL / 1000), '*') "Empleado y su salario" FROM EMP ORDER BY SAL DESC;

--98. Listar los distintos nombres de puestos de los empleados, de forma que : PRESIDENT se traduzca por A, MANAGER por B, ANALYST por C, CLERK por D y el resto por E.

SELECT DECODE(JOB, 'PRESIDENT', 'A', 'MANAGER', 'B', 'ANALYST', 'C', 'CLERK', 'D', 'E') FROM EMP;

--99. Listar todos los campos de la tabla DEPT.

SELECT * FROM DEPT;

--100. Seleccionar el nombre de departamento, y el nombre de la ciudad donde está.

SELECT DNAME, LOC FROM DEPT;