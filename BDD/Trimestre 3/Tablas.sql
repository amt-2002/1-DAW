DECLARE 
    TYPE tipoTabla IS TABLE OF VARCHAR2(50) INDEX BY BINARY_INTEGER;
    DATOS tipoTabla; 
BEGIN 
    DATOS(1) := 'CASA';
    DATOS(2) := 'PERRO';
    DBMS_OUTPUT.PUT_LINE('DATOS(1): ' || DATOS(1));
    DBMS_OUTPUT.PUT_LINE('DATOS(2): ' || DATOS(2));
END;
/


-- EJERCICIO 7 

DECLARE 
    TYPE NUMEROS IS TABLE OF INTEGER INDEX BY BINARY_INTEGER;
    DATOS NUMEROS;
BEGIN
    FOR I IN 1..10 LOOP
        DATOS(I) := I;
        DBMS_OUTPUT.PUT_LINE('DATOS(' || I || '): ' || DATOS(I));
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('DATOS.COUNT: ' || DATOS.COUNT);

    FOR I IN DATOS.FIRST .. DATOS.LAST LOOP
        DBMS_OUTPUT.PUT_LINE('DATOS(' || I || '): ' || DATOS(I));
    END LOOP; 

    DATOS.DELETE(DATOS.LAST);
    
    DBMS_OUTPUT.PUT_LINE('DATOS.COUNT: ' || DATOS.COUNT);

    IF DATOS.EXISTS(10) THEN
        DBMS_OUTPUT.PUT_LINE('DATOS(10): ' || DATOS(10));
    ELSE
        DBMS_OUTPUT.PUT_LINE('DATOS(10) NO EXISTE');
    END IF;

END;
/

-- EJERCICIO 8 

DECLARE 
    TYPE PERSONA IS RECORD (
        NOMBRE VARCHAR2(50),
        APELLIDO1 VARCHAR2(50),
        APELLIDO2 VARCHAR2(50)
    );
    TYPE PERSONAS IS TABLE OF PERSONA INDEX BY BINARY_INTEGER;
    PERS PERSONAS;
BEGIN 
    PERS(1).NOMBRE := 'JUAN';
    PERS(1).APELLIDO1 := 'PEREZ';
    PERS(1).APELLIDO2 := 'GARCIA';
    DBMS_OUTPUT.PUT_LINE('PERS(1).NOMBRE: ' || PERS(1).NOMBRE);
    DBMS_OUTPUT.PUT_LINE('PERS(1).APELLIDO1: ' || PERS(1).APELLIDO1);
    DBMS_OUTPUT.PUT_LINE('PERS(1).APELLIDO2: ' || PERS(1).APELLIDO2);
END; 
/

-- EJERCICIO 10 

-- Se quiere mostrar por pantalla los datos de ciertos empleados (tabla
-- emp). 
--     Se pide:
--     ❑ Se pedirá al usuario por la entrada de plsql que introduzca dos
--     valores integer que coincidan con dos empnos de la tabla emp,
--     y se guardarán en una tabla de integers.
--     ❑ Se debe crear una tabla que contendrá como valores todos los
--     campos de las filas de emp cuyo empno coincida con los de la
--     tabla anterior. Puedes usar registros o %rowtype.
--     ❑ Recorre la tabla anterior mostrando por la salida los valores de
--     cada columna de los dos registros.


DECLARE
    EMPNO1 EMP.EMPNO%TYPE := '&EMPNO1RECIBIDO';
    EMPNO2 EMP.EMPNO%TYPE := '&EMPNO2RECIBIDO';

    TYPE EMPNOS IS TABLE OF INTEGER INDEX BY BINARY_INTEGER;
    MIS_EMPNOS EMPNOS;

    CONTADOR1 INT;
    CONTADOR2 INT;

    TYPE EMPLEADO IS RECORD (
        EMPNO EMP.EMPNO%TYPE,
        ENAME EMP.ENAME%TYPE,
        JOB EMP.JOB%TYPE,
        MGR EMP.MGR%TYPE,
        HIREDATE EMP.HIREDATE%TYPE,
        SAL EMP.SAL%TYPE,
        COMM EMP.COMM%TYPE,
        DEPTNO EMP.DEPTNO%TYPE
    );

    TYPE EMPLEADOS IS TABLE OF EMPLEADO INDEX BY BINARY_INTEGER;
    EMPLE EMPLEADOS;

BEGIN 

    MIS_EMPNOS(1) := EMPNO1;
    MIS_EMPNOS(2) := EMPNO2;

    SELECT COUNT(*) INTO CONTADOR1 FROM EMP WHERE EMPNO = MIS_EMPNOS(1);
    SELECT COUNT(*) INTO CONTADOR2 FROM EMP WHERE EMPNO = MIS_EMPNOS(2);

    IF CONTADOR1 > 0 AND CONTADOR2 > 0 THEN

        FOR I IN 1..2 LOOP
            SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO INTO EMPLE(I).EMPNO, EMPLE(I).ENAME, EMPLE(I).JOB, EMPLE(I).MGR, EMPLE(I).HIREDATE, EMPLE(I).SAL, EMPLE(I).COMM, EMPLE(I).DEPTNO FROM EMP WHERE EMPNO = MIS_EMPNOS(I);
        END LOOP;

        FOR I IN 1..2 LOOP
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').EMPNO: ' || EMPLE(I).EMPNO);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').ENAME: ' || EMPLE(I).ENAME);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').JOB: ' || EMPLE(I).JOB);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').MGR: ' || EMPLE(I).MGR);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').HIREDATE: ' || EMPLE(I).HIREDATE);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').SAL: ' || EMPLE(I).SAL);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').COMM: ' || EMPLE(I).COMM);
            DBMS_OUTPUT.PUT_LINE('EMPLE(' || I || ').DEPTNO: ' || EMPLE(I).DEPTNO);
        END LOOP;
        
    ELSE
        DBMS_OUTPUT.PUT_LINE('NO EXISTEN EMPLEADOS CON LOS EMPNOS INTRODUCIDOS');
    END IF;
END; 
/

SELECT * FROM EMP;