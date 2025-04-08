set serveroutput on;
--Cursores:
DECLARE
    DATOS ESTUDIANTES%ROWTYPE;
BEGIN
    SELECT * INTO DATOS FROM ESTUDIANTES WHERE CODIGO = 6;
    dbms_output.put_line('OK');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    dbms_output.put_line('NO HAY DATOS');
    WHEN TOO_MANY_ROWS THEN
    dbms_output.put_line('HAY MÁS DE UN DATO');
END;
/
/*
Ejercicio 1.
1. Definir un cursor implícito para obtener por
pantalla el nombre y los apellidos del estudiante
con DNI=’00000000T’ de la tabla ESTUDIANTES
(fichero estudiantes.sql).
NOTA: tener en cuenta que el DNI puede no
existir en la tabla.
2. Prueba ahora con el DNI 97898989T.
*/
DECLARE
    NOMBRE1 ESTUDIANTES.NOMBRE%TYPE;
    APELLIDOS1 ESTUDIANTES.APELLIDOS%TYPE;
BEGIN
    SELECT NOMBRE,APELLIDOS INTO NOMBRE1,APELLIDOS1 FROM ESTUDIANTES WHERE DNI = '00000000T';
    dbms_output.put_line(NOMBRE || ' ' || APELLIDOS);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    dbms_output.put_line('NO EXISTE ESTE ALUMNO');
END;
/
/*
Ejercicio 2.
1. Definir un cursor implícito para obtener por
pantalla el dni y los apellidos del estudiante cuyo
nombre sea Marta en la tabla ESTUDIANTES
(fichero estudiantes.sql).
NOTA: tener en cuenta tanto que puede no existir
ningún estudiante que se llame así o que pueda
haber varios con el mismo nombre.
2. Prueba ahora con el nombre Blanca.
*/
DECLARE
    DNI1 ESTUDIANTES.DNI%TYPE;
    APELLIDOS ESTUDIANTES.APELLIDOS%TYPE;
BEGIN
    SELECT DNI,APELLIDOS INTO DNI1,APELLIDOS FROM ESTUDIANTES WHERE NOMBRE = 'Marta';
    dbms_output.put_line(DNI1 || ' ' || APELLIDOS);
EXCEPTION
    WHEN TOO_MANY_ROWS THEN
    dbms_output.put_line('HAY MÁS DE UN DATO');
END;
/
/*
Ejercicio 3.
Definir un cursor explícito que seleccione el
nombre, apellidos y DNI de la tabla
ESTUDIANTES. Abrir el cursor, extraer el primer
dato, mostrar cuántos registros se han procesado
(uno) y cerrarlo. Luego mostrar el nombre del
estudiante del registro procesado en el cursor.
¿Qué sucede si ponemos dos FETCH?
*/
DECLARE
    NOMBRE1 ESTUDIANTES.NOMBRE%TYPE;
    APELLIDOS ESTUDIANTES.APELLIDOS%TYPE;
    DNI1 ESTUDIANTES.DNI%TYPE;
    CURSOR C_NOMBRE IS SELECT NOMBRE,APELLIDOS,DNI INTO NOMBRE1,APELLIDOS,DNI1 FROM ESTUDIANTES;   
BEGIN
    OPEN C_NOMBRE;
    FETCH C_NOMBRE INTO NOMBRE1,APELLIDOS,DNI1;
    CLOSE C_NOMBRE;
        dbms_output.put_line(NOMBRE1 || ' - ' || APELLIDOS || ' - ' ||  DNI1);
END;
/
DECLARE
    ESTUDIANTE ESTUDIANTES%ROWTYPE;
    CURSOR C_NOMBRE IS SELECT * INTO ESTUDIANTE FROM ESTUDIANTES;   
BEGIN
    OPEN C_NOMBRE;
    FETCH C_NOMBRE INTO ESTUDIANTE;
    FETCH C_NOMBRE INTO ESTUDIANTE;
    dbms_output.put_line(ESTUDIANTE.NOMBRE || ' - ' || ESTUDIANTE.APELLIDOS || ' - ' ||  ESTUDIANTE.DNI);
    CLOSE C_NOMBRE;
END;
/
/*
Ejercicio 4.
Definir un cursor explícito que seleccione el
nombre, apellidos y DNI de la tabla
ESTUDIANTES. Recorrerlo y mostrar todos los
datos recuperados.
Escribir al final el número de filas recuperadas en
total.
*/
DECLARE
    ESTUDIANTE ESTUDIANTES%ROWTYPE;
    CONTADOR INT := 0;
    CURSOR C_NOMBRE IS SELECT * INTO ESTUDIANTE FROM ESTUDIANTES;   
BEGIN
    OPEN C_NOMBRE;
    LOOP
    FETCH C_NOMBRE INTO ESTUDIANTE;
    EXIT WHEN C_NOMBRE%NOTFOUND;
        dbms_output.put_line(ESTUDIANTE.NOMBRE || ' - ' || ESTUDIANTE.APELLIDOS || ' - ' ||  ESTUDIANTE.DNI);
        CONTADOR := CONTADOR+1;
    END LOOP;
    dbms_output.put_line('HEMOS SACADO: ' || CONTADOR || ' ESTUDIANTES' ||' - ' || C_NOMBRE%ROWCOUNT);
    CLOSE C_NOMBRE;
END;
/
/*
Ejercicio 5.
Definir un cursor explícito que seleccione el
nombre y la fecha de nacimiento de la tabla
ESTUDIANTES. Recorrerlo y mostrar todos los
datos recuperados con WHILE LOOP.
Escribir al final el número de filas recuperadas en
total.
*/
DECLARE
    ESTUDIANTE ESTUDIANTES%ROWTYPE;
    CURSOR C_NOMBRE IS SELECT * INTO ESTUDIANTE FROM ESTUDIANTES;   
BEGIN
    OPEN C_NOMBRE;
    FETCH C_NOMBRE INTO ESTUDIANTE;
    WHILE C_NOMBRE%FOUND LOOP
    FETCH C_NOMBRE INTO ESTUDIANTE;
            dbms_output.put_line(ESTUDIANTE.NOMBRE || ' - ' || ESTUDIANTE.FECHA_NACIMIENTO);
    END LOOP;
    CLOSE C_NOMBRE;
END;
/
/*
Ejercicio 6.
Definir un cursor explícito que seleccione el
nombre, apellidos y fecha de nacimiento de la
tabla ESTUDIANTES. Recorrerlo y mostrar todos
los datos recuperados con un bucle FOR.
Escribir el número de filas recuperadas en total.
*/
DECLARE
    ESTUDIANTE ESTUDIANTES%ROWTYPE;
    CURSOR C_NOMBRE IS SELECT * INTO ESTUDIANTE FROM ESTUDIANTES;   
BEGIN
    FOR ESTUDIANTE IN C_NOMBRE LOOP
         dbms_output.put_line(ESTUDIANTE.NOMBRE || ' - ' || ESTUDIANTE.APELLIDOS || ' - ' || ESTUDIANTE.FECHA_NACIMIENTO);   
    END LOOP;
END;
/
/*
Ejercicio 7.
Se quiere mostrar por pantalla el nombre y apellidos de los
estudiantes que se llamen de cierta forma. Para ello se
pedirá al usuario que introduzca el nombre a buscar.
El formato requerido para mostrar por pantalla es el
siguiente (todo en mayúsculas): “APELLIDOS, NOMBRE”.
Ej.: CARRASCO PEREZ, MARTA.
En el supuesto de que SELECT no se traiga ningún
registro, mostrar por pantalla “NO HAY DATOS”. Utiliza un
bucle WHILE.
Lanza la ejecución para el nombre “Marta” y después para
el nombre “Luis”.
*/
DECLARE
    NOMBRE1 ESTUDIANTES.NOMBRE%TYPE:= '&EscribeunNombre';
    ESTUDIANTE ESTUDIANTES%ROWTYPE;
    CURSOR C_NOMBRE IS SELECT * INTO ESTUDIANTE FROM ESTUDIANTES WHERE NOMBRE = NOMBRE1;   
BEGIN
    OPEN C_NOMBRE;
    FETCH C_NOMBRE INTO ESTUDIANTE;
    WHILE C_NOMBRE%FOUND LOOP
    FETCH C_NOMBRE INTO ESTUDIANTE;  
        IF C_NOMBRE%NOTFOUND THEN
        dbms_output.put_line('NO HAY DATOS');
        END IF;
        dbms_output.put_line(ESTUDIANTE.NOMBRE || ' - ' || ESTUDIANTE.FECHA_NACIMIENTO);
    END LOOP;
    CLOSE C_NOMBRE;
END;
/
select * from estudiantes;
select * from asignaturas;
select * from matriculas;


SELECT * FROM EMP;

--Boletín ejercicios con cursores
--1 Se quiere visualizar el nombre y la fecha de alta de todos los empleados, ordenados por el nombre de Z a A.

DECLARE 
    CURSOR C_NOMBRE IS SELECT * FROM EMP ORDER BY ENAME DESC; 
    EMPLEADOS EMP%ROWTYPE;
BEGIN 
    FOR EMPLEADOS IN C_NOMBRE LOOP
        dbms_output.put_line(EMPLEADOS.ENAME || ' - ' || EMPLEADOS.HIREDATE);
    END LOOP;
END;
/


--2 Encuentra el primer empleado con un sueldo mayor que 2000�. Muestra su nombre y su salario (solo del primero). NOTA: siempre puedes salir de un bucle con exit;

DECLARE 
    CURSOR C_NOMBRE IS SELECT * FROM EMP WHERE SAL > 2000; 
    EMPLEADOS EMP%ROWTYPE;
BEGIN
    OPEN C_NOMBRE;
    FETCH C_NOMBRE INTO EMPLEADOS;
    dbms_output.put_line(EMPLEADOS.ENAME || ' - ' || EMPLEADOS.SAL);
    CLOSE C_NOMBRE;
END;
/

--3 Pide al usuario que introduzca un empno y te muestre por la salida el empno, ename y la loc del departamento en el que trabaja

DECLARE 
    CURSOR C_NOMBRE IS SELECT EMP.EMPNO, EMP.ENAME, DEPT.LOC FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO AND EMP.EMPNO = '&EMPNO'; 
    EMPNO EMP.EMPNO%TYPE;
    ENAME EMP.ENAME%TYPE;
    LOC DEPT.LOC%TYPE;
BEGIN
    OPEN C_NOMBRE;
    FETCH C_NOMBRE INTO EMPNO, ENAME, LOC;
    dbms_output.put_line(EMPNO || ' - ' || ENAME || ' - ' || LOC);
    CLOSE C_NOMBRE;
END;
/

SELECT * FROM EMP;
SELECT * FROM DEPT;

--4 En la tabla EMP incrementar el salario el 10% a los empleados que tengan una comisi�n superior al 5% del salario. Para ello recorre cada uno de los empleados, y en caso de que se de esa condici�n del 5%, realiza el update y muestra un mensaje con el nombre del empleado con sal actualizado.


DECLARE 
    CURSOR C_NOMBRE IS SELECT * FROM EMP; 
    EMPLEADOS EMP%ROWTYPE;
BEGIN
    FOR EMPLEADOS IN C_NOMBRE LOOP
        IF EMPLEADOS.COMM > (EMPLEADOS.SAL * 0.05) THEN
            UPDATE EMP SET SAL = SAL + (SAL * 0.10) WHERE EMPNO = EMPLEADOS.EMPNO;
            dbms_output.put_line(EMPLEADOS.ENAME || ' - ' || EMPLEADOS.SAL);
        END IF;
    END LOOP;
END;
/


--5 Modifica el ejercicio anterior para, tras actualizar el salario, mostrar el nombre del empleado, la comisi�n, el salario antiguo y el salario nuevo. Adem�s, cuando no se actualice el salario, indicar un mensaje "El empleado XXX no ha tenido subida en su salario".


DECLARE 
    CURSOR C_NOMBRE IS SELECT * FROM EMP; 
    EMPLEADOS EMP%ROWTYPE;
BEGIN
    FOR EMPLEADOS IN C_NOMBRE LOOP
        IF EMPLEADOS.COMM > (EMPLEADOS.SAL * 0.05) THEN
            dbms_output.put_line(EMPLEADOS.ENAME || ' - ' || EMPLEADOS.COMM || ' - ' || EMPLEADOS.SAL || ' - ' || (EMPLEADOS.SAL + (EMPLEADOS.SAL * 0.10)));
            UPDATE EMP SET SAL = SAL + (SAL * 0.10) WHERE EMPNO = EMPLEADOS.EMPNO;
        ELSE
            dbms_output.put_line('El empleado ' || EMPLEADOS.ENAME || ' no ha tenido subida en su salario');
        END IF;
    END LOOP;
END;
/


--6 Pide que introduzca el usuario una cadena de caracteres por teclado. Muestra el empno y el ename de todos los empleados que tengan en su ename esa cadena introducida. Al finalizar, muestra un mensaje con el n�mero total de empleados que lo tienen.

DECLARE 
    EMPLEADOS EMP%ROWTYPE;
    CADENA VARCHAR2(20) := '&CADENA';
    CURSOR C_NOMBRE IS SELECT * FROM EMP WHERE ENAME LIKE '%' || CADENA || '%';
    CONTADOR INT := 0;
BEGIN 

    FOR EMPLEADOS IN C_NOMBRE LOOP
        CONTADOR := CONTADOR + 1;
    END LOOP;
    dbms_output.put_line('El número total de empleados que tienen la cadena ' || CADENA || ' es: ' || CONTADOR);
END;
/

UNDEFINE CADENA;

--7 Muestra el nombre de cada departamento junto al n�mero de empleados que tiene, incluso si no tiene empleados.

DECLARE 
    CURSOR C_NOMBRE IS SELECT DEPT.DNAME, COUNT(EMP.EMPNO) FROM DEPT LEFT JOIN EMP ON DEPT.DEPTNO = EMP.DEPTNO GROUP BY DEPT.DNAME; 
    DEPARTAMENTO DEPT%ROWTYPE;
BEGIN
    FOR I IN C_NOMBRE LOOP
        dbms_output.put_line(I.DNAME);
    END LOOP;
END;
/

--8 Busca todos los empleados que tienen salario + comisi�n mayor a 2000, y asignarles como salario esa suma. Solo puedes hacerlo si tienen comisi�n. Muestra por la salida el nombre de todos los empleados que modifiquen su salario, as� como el n�mero total de empleados que se han actualizados.

DECLARE 

    CURSOR C_NOMBRE IS SELECT * FROM EMP WHERE COMM IS NOT NULL; 
    EMPLEADOS EMP%ROWTYPE;
    CONTADOR INT := 0;
BEGIN
    FOR EMPLEADOS IN C_NOMBRE LOOP
        IF (EMPLEADOS.SAL + EMPLEADOS.COMM) > 2000 THEN
            UPDATE EMP SET SAL = SAL + COMM WHERE EMPNO = EMPLEADOS.EMPNO;
            CONTADOR := CONTADOR + 1;
            dbms_output.put_line(EMPLEADOS.ENAME || ' - ' || EMPLEADOS.SAL);
        END IF;
    END LOOP;
    dbms_output.put_line('El número total de empleados que se han actualizado es: ' || CONTADOR);
END;
/

--9 Muestra el ename y sal de los cinco empleados con el salario m�s alto.

DECLARE 
    CURSOR C_NOMBRE IS SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC; 
    EMPLEADOS EMP%ROWTYPE;
    CONTADOR INT := 0;
BEGIN
    FOR EMPLEADOS IN C_NOMBRE LOOP
        CONTADOR := CONTADOR + 1;
        IF CONTADOR <= 5 THEN
            dbms_output.put_line(EMPLEADOS.ENAME || ' - ' || EMPLEADOS.SAL);
        END IF;
    END LOOP;
END;
/

--10 Por cada puesto de trabajo (job), muestra el puesto y luego los dos empleados que tienen ese puesto y cobran menos. Si hay menos de dos empleados, muestra los que haya.

DECLARE 
    CURSOR C_NOMBRE IS SELECT JOB, ENAME, SAL FROM EMP ORDER BY JOB, SAL; 
    EMPLEADOS EMP%ROWTYPE;
    CONTADOR INT := 0;
BEGIN
    FOR EMPLEADOS IN C_NOMBRE LOOP
        CONTADOR := CONTADOR + 1;
        IF CONTADOR <= 2 THEN
            dbms_output.put_line(EMPLEADOS.JOB || ' - ' || EMPLEADOS.ENAME || ' - ' || EMPLEADOS.SAL);
        ELSE
            CONTADOR := 0;
        END IF;
    END LOOP;
END;
/