DECLARE 
    NUMERO INT := 7; -- DECLARAR E INICIALIZAR  
    NUMERO2 INT;

BEGIN 
    NUMERO2 := 4;
    DBMS_OUTPUT.PUT_LINE(NUMERO);
    NUMERO := 12;
    DBMS_OUTPUT.PUT_LINE(NUMERO); 
    DBMS_OUTPUT.PUT_LINE(NUMERO || ' - ' || NUMERO2);  
END; 
/

--EJERCICIO 3

SET SERVEROUTPUT ON;

DECLARE
    VARIABLE1 EMP.ENAME%TYPE; --VARIABLE1 VARCHAR2(10)
    VARIABLE2 EMP%ROWTYPE; --VARIABLE2.EMPNO, VARIABLE2.ENAME, ETC.
BEGIN
    SELECT ENAME INTO VARIABLE1 FROM EMP WHERE EMPNO = 7839;
    DBMS_OUTPUT.PUT_LINE('PRIMER CASO' || VARIABLE1);
    SELECT * INTO VARIABLE2 FROM EMP WHERE EMPNO = 7698;   
    DBMS_OUTPUT.PUT_LINE('SEGUNDO CASO' || VARIABLE2.ENAME);
END;
/


DECLARE
    ALTURA INT := &ALTURA; 
    BASE INT := &BASE; 
BEGIN
    DBMS_OUTPUT.PUT_LINE('EL AREA DEL TRIANGULO ES ' || (ALTURA*BASE)/2);
END;
/
UNDEFINE BASE; -- NECESARIO PARA BORRAR CACHE
UNDEFINE ALTURA; -- NECESARIO PARA BORRAR CACHE

--SELECT ENAME FROM EMP WHERE EMPNO = 7839;
-- SELECT * FROM EMP WHERE EMPNO = 7698;

DECLARE
    NUMERO INT := &INTRODUZCA_NUMERO;
BEGIN
    CASE NUMERO
    WHEN 1 THEN
        DBMS_OUTPUT.PUT_LINE('HA METIDO EL 1');
    WHEN 2 THEN
        DBMS_OUTPUT.PUT_LINE('HA METIDO EL 2');
    ELSE
        DBMS_OUTPUT.PUT_LINE('HA METIDO UN NÚMERO DISTINTO DE 1 Y 2');
    END CASE;
END;
/
UNDEFINE INTRODUZCA_NUMERO; 

DECLARE
    NUMERO INT := &INTRODUZCA_NUMERO;
BEGIN
    CASE 
    WHEN NUMERO = 1 THEN
        DBMS_OUTPUT.PUT_LINE('HA METIDO EL 1');
    WHEN NUMERO = 2 OR NUMERO BETWEEN 3 AND 4 THEN
        DBMS_OUTPUT.PUT_LINE('HA METIDO EL 2,3,4');
    ELSE
        DBMS_OUTPUT.PUT_LINE('HA METIDO UN NÚMERO DISTINTO DE 1 Y 2');
    END CASE;
END;
/
UNDEFINE INTRODUZCA_NUMERO;

--PESTAÑA TEMA6
--01. CONSTRUCCIÓN DE GUIONES
DECLARE
    NUMERO1 INT := 2;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(NUMERO1);
        IF NUMERO1 = 0 THEN --PRIMERA FORMA
            EXIT;
        END IF;
        EXIT WHEN NUMERO1 = 1; --SEGUNDA OPCIÓN
        --NUMERO1--
        --NUMERO1++
        NUMERO1 := NUMERO1 - 2;
    END LOOP;
END;
/
 
--EJERCICIO 13
DECLARE
    VAR1 INT := 0;
    CADENA VARCHAR2(150);
BEGIN
    LOOP
        IF VAR1 = 0 THEN
            CADENA := VAR1;
        ELSE
            CADENA := CADENA || ', ' || VAR1;
        END IF;
        VAR1 := VAR1 + 1;
        EXIT WHEN VAR1 > 20;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(CADENA);
END;
/
 
--EJERCICIO 14
DECLARE
    VAR1 INT := 0;
BEGIN   
    LOOP
        DBMS_OUTPUT.PUT_LINE(VAR1);
        VAR1 := VAR1 + 1;
        IF VAR1 > 20 THEN EXIT;
        END IF;
    END LOOP;
END;
/
 
DECLARE
    VAR1 INT := 0;
BEGIN   
    WHILE VAR1 >= 0 LOOP
        DBMS_OUTPUT.PUT_LINE(VAR1);
        VAR1 := VAR1 + 1;
        IF VAR1 > 20 THEN EXIT;
        END IF;
        --VAR1 := -5;
    END LOOP;
END;
/
 
--EJERCICIO 15
DECLARE
    VAR1 INT := 0;
BEGIN   
    WHILE VAR1 <= 20 LOOP
        DBMS_OUTPUT.PUT_LINE(VAR1);
        VAR1 := VAR1 + 1;
    END LOOP;
END;
/

--EJERCICIO 18 
-- DECLARE 
--     NUMEROPAR INT;
BEGIN
    FOR NUMEROPAR IN 1..40 LOOP
        IF MOD(NUMEROPAR, 2) = 0 THEN
            DBMS_OUTPUT.PUT_LINE(NUMEROPAR);
        END IF;
    END LOOP;
END;
/

BEGIN 
    FOR U IN 1..10 LOOP 
        DBMS_OUTPUT.PUT_LINE('TABLA DEL ' || U);
        FOR V IN 1..10 LOOP 
            DBMS_OUTPUT.PUT_LINE(U || ' * ' || V || ' = ' || U * V);
        END LOOP;
    END LOOP;
END;
/

DECLARE

    VARIABLE1 DEPT.DEPTNO%TYPE;
    FILA1 DEPT%ROWTYPE; --FILA1.DEPTNO, FILA1.DNAME, FILA1.LOC
    TYPE DEPARTAMENrTOSINLOC IS RECORD(
        CODIGODEPARTAMENTO DEPT.DEPTNO%TYPE,
        DNAME DEPT.DNAME%TYPE
    );
    FILADEPARTAMENTO DEPARTAMENTOSINLOC;

    --CREAR REGISTRO DIRECCION
    TYPE DIRECCION IS RECORD(
        CALLE VARCHAR2(50),
        NUMERO INT,
        PISO INT(4), 
        PUERTA VARCHAR2(2),
        PROVINCIA VARCHAR2(20),
        PAIS VARCHAR2(20) := 'ESPAÑA'
    );
    CASA DIRECCION;

BEGIN
    FILADEPARTAMENTO.CODIGODEPARTAMENTO := 1;
    FILADEPARTAMENTO.DNAME := 'TIC';
    DBMS_OUTPUT.PUT_LINE(FILADEPARTAMENTO.DNAME);


    CASA.CALLE := 'CALLE DE LA PRUEBA';
    CASA.NUMERO := 5;
    CASA.PISO := 2;
    CASA.PUERTA := 'A';
    CASA.PROVINCIA := 'MADRID';
    DBMS_OUTPUT.PUT_LINE(CASA.CALLE || ' ' || CASA.NUMERO || ' ' || CASA.PISO || ' ' || CASA.PUERTA || ' ' || CASA.PROVINCIA || ' ' || CASA.PAIS);

END;
/


--Ejercicio2
DECLARE
    TYPE TPERSONA IS RECORD(
        CODIGO NUMBER(2),
        NOMBRE VARCHAR2(100),
        EDAD INTEGER
    );
    TYPE ALUMNO IS RECORD(
        NOMBRE VARCHAR(100),
        PROFESOR TPERSONA
    );
    ALUMNO1 ALUMNO;
    ALUMNO2 ALUMNO;
BEGIN
    ALUMNO1.NOMBRE := 'PEDRO';
    ALUMNO1.PROFESOR.CODIGO := 1;
    ALUMNO1.PROFESOR.NOMBRE := 'INDALECIO';
    ALUMNO1.PROFESOR.EDAD := 33;
    DBMS_OUTPUT.PUT_LINE(
        ALUMNO1.NOMBRE || '-' ||
        ALUMNO1.PROFESOR.CODIGO || '-' ||
        ALUMNO1.PROFESOR.NOMBRE || '-' ||
        ALUMNO1.PROFESOR.EDAD
    );
    ALUMNO2.NOMBRE := 'MARCOS';
    ALUMNO2.PROFESOR.CODIGO := 2;
    DBMS_OUTPUT.PUT_LINE(
        ALUMNO2.NOMBRE || '-' ||
        ALUMNO2.PROFESOR.CODIGO || '-' ||
        ALUMNO2.PROFESOR.NOMBRE || '-' ||
        ALUMNO2.PROFESOR.EDAD
    );
END;
/
