
-- Se quiere un programa en plsql que pida al usuario que introduzca el job que quiera, y si existe, muestre por la salida el número de trabajadores que tienen ese puesto/job. En caso de que no haya ninguno, que muestre el mensaje 'No hay empleados de ese puesto'.

DECLARE
    trabajo VARCHAR2(50) := '&trabajo_escrito';
    contador NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('El trabajo escrito es: ' || trabajo);
    SELECT COUNT(*) INTO contador FROM EMP WHERE JOB = trabajo;
    IF contador > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Hay ' || contador || ' empleados con el trabajo escrito ' || trabajo);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No hay empleados de ese puesto');
    END IF;
END;
/

UNDEFINE trabajo_escrito;


-- Crea un programa plsql que haga lo siguiente. Utiliza una constante MIFECHA del tipo date con el valor '17-09-1981'. A continuación, muestra el nombre de cada departamento, junto con el nombre de cada empleado de ese departamento cuya fecha de contratación/hiredate sea menor a la constante MIFECHA. Debes mostrar el nombre del departamento y luego todos los nombres de empleados de ese departamento. Después el siguiente nombre de departamento y todos los empleados de ese departamento, y así sucesivamente hasta terminar con todos los departamentos. NOTA: se sabe que el deptno se incrementa en 10 unidades cada vez para cada registro.

DECLARE 
    MIFECHA DATE := '17-09-1981';
    CONTADOR NUMBER;
    CONTADORMAX NUMBER;
    NOMBRE VARCHAR2(50);
    JOB VARCHAR2(50);
    COINCIDENCIA NUMBER;
    CONTADOREMPMIN NUMBER;
    CONTADOREMPMAX NUMBER;
    COINCIDENCIA2 NUMBER;
BEGIN 
    SELECT MIN(DEPTNO) INTO CONTADOR FROM DEPT; 
    SELECT MAX(DEPTNO) INTO CONTADORMAX FROM DEPT; 
    SELECT MIN(EMPNO) INTO CONTADOREMPMIN FROM EMP;
    SELECT MAX(EMPNO) INTO CONTADOREMPMAX FROM EMP;

    FOR I IN CONTADOR .. CONTADORMAX LOOP
        SELECT COUNT(*) INTO COINCIDENCIA FROM EMP WHERE DEPTNO = I AND HIREDATE < MIFECHA;

        IF COINCIDENCIA > 0 THEN
            SELECT DNAME INTO NOMBRE FROM DEPT WHERE DEPTNO = I;
            DBMS_OUTPUT.PUT_LINE('DEPARTAMENTO: ' || NOMBRE);

            FOR J IN CONTADOREMPMIN .. CONTADOREMPMAX LOOP
                SELECT COUNT(*) INTO COINCIDENCIA2 FROM EMP WHERE DEPTNO = I AND EMPNO = J AND HIREDATE < MIFECHA;
                IF COINCIDENCIA2 > 0 THEN
                    SELECT ENAME, JOB INTO NOMBRE, JOB FROM EMP WHERE DEPTNO = I AND EMPNO = J AND HIREDATE < MIFECHA;
                    DBMS_OUTPUT.PUT_LINE('EMPLEADO: ' || NOMBRE || ' - ' || JOB);
                END IF;
            END LOOP;
        END IF;
    END LOOP;
END; 
/

-- Se quiere un plsql que pregunte dos fechas y compruebe:

-- Que la segunda fecha es más reciente que la primera.
-- Que no son iguales en ningún caso.
-- Que hay empleados que se contrataron (tienen ese hiredate) en ese intervalo. Si se cumplen todas las condiciones anteriores, mostrar por la salida el número total de empleados que lo cumplen. En caso contrario, mostrar el mensaje "No se cumplen las condiciones".


DECLARE 
    FECHA1 DATE := '&FECHA1_ESCRITA';
    FECHA2 DATE := '&FECHA2_ESCRITA';
    NUMEMPLEADOS NUMBER; 
BEGIN 
    DBMS_OUTPUT.PUT_LINE('La fecha 1 escrita es: ' || FECHA1);
    DBMS_OUTPUT.PUT_LINE('La fecha 2 escrita es: ' || FECHA2);

    SELECT COUNT(*) INTO NUMEMPLEADOS FROM EMP WHERE HIREDATE BETWEEN FECHA1 AND FECHA2;
    IF FECHA1 < FECHA2 AND NUMEMPLEADOS > 0 THEN
        DBMS_OUTPUT.PUT_LINE('Hay ' || NUMEMPLEADOS || ' empleados');
    ELSE
        DBMS_OUTPUT.PUT_LINE('No se cumplen las condiciones');
    END IF; 
END;
/

UNDEFINE FECHA1_ESCRITA;
UNDEFINE FECHA2_ESCRITA;


-- Se quiere crear con plsql un script que tenga un registro llamado empleado con los campos empno, ename y job, pertenecientes a la tabla emp. Además, deberá tener un campo departamento que sea a su vez un registro departamentos con deptno y dname de la tabla dept. Crea una variable empleadoMasNovel que sea del tipo empleado y que tenga todos los datos de emp y dept correspondientes al empleado cuyo hiredate sea el más reciente a día de hoy.

DECLARE
    TYPE DEPARTAMENTO IS RECORD(
        CODIGO DEPT.DEPTNO%TYPE,
        NOMBRE DEPT.DNAME%TYPE
    );
    TYPE EMPLEADO IS RECORD(
        CODIGO EMP.EMPNO%TYPE,
        NOMBRE EMP.ENAME%TYPE,
        PUESTO EMP.JOB%TYPE,
        DEPARTAMENTOV DEPARTAMENTO
    );
    EMPLEADOMASNOVEL EMPLEADO;
BEGIN
    SELECT EMPNO,ENAME,JOB,DEPT.DEPTNO,DNAME
    INTO EMPLEADOMASNOVEL.CODIGO,EMPLEADOMASNOVEL.NOMBRE,EMPLEADOMASNOVEL.PUESTO,EMPLEADOMASNOVEL.DEPARTAMENTOV.CODIGO,EMPLEADOMASNOVEL.DEPARTAMENTOV.NOMBRE
        FROM EMP
        JOIN DEPT ON DEPT.DEPTNO = EMP.DEPTNO
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    DBMS_OUTPUT.PUT_LINE(EMPLEADOMASNOVEL.CODIGO);
    DBMS_OUTPUT.PUT_LINE(EMPLEADOMASNOVEL.NOMBRE);
    DBMS_OUTPUT.PUT_LINE(EMPLEADOMASNOVEL.PUESTO);
    DBMS_OUTPUT.PUT_LINE(EMPLEADOMASNOVEL.DEPARTAMENTOV.CODIGO);
    DBMS_OUTPUT.PUT_LINE(EMPLEADOMASNOVEL.DEPARTAMENTOV.NOMBRE);
END;
/