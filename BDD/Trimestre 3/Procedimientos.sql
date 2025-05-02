CREATE OR REPLACE PROCEDURE miProcedimiento(miNumero in int)
IS 
    contador int := 0;
BEGIN 
    DBMS_OUTPUT.PUT_LINE('Número total de estudiantes: ' || contador + miNumero);
END;
/

CREATE OR REPLACE PROCEDURE MIPROCEDIMIENTO(miNumero in int, resta out int)
IS 
    contador int := 10;
BEGIN 
    DBMS_OUTPUT.PUT_LINE(contador + miNumero);
    resta := miNumero - contador;
END;
/


CREATE OR REPLACE PROCEDURE MIPROCEDIMIENTO(miNumero in int, resta in out int)
IS 
    contador int := 10;
BEGIN 
    DBMS_OUTPUT.PUT_LINE(contador + miNumero);
    resta := resta + miNumero - contador;
END;
/

CREATE OR REPLACE PROCEDURE MIPROCEDIMIENTO(resta out int)
IS 
    contador int := 10;
BEGIN 
    resta := contador * 2;
END;
/


DECLARE 
    resultado int := 4;
BEGIN 
    MIPROCEDIMIENTO(resultado);
    DBMS_OUTPUT.PUT_LINE('El resultado de la resta es: ' || resultado);
END;
/


-- Crea un procedimiento que se llame
-- consultarEmpleado. Debe tomar una variable de
-- entrada v_empno con el tipo de dato del campo
-- empno de la tabla emp. Debe tomar como
-- variables de salida v_ename y v_job, cuyos tipos
-- de datos deben coincidir con los de los campos
-- ename y job de la tabla emp.
-- Controla con una excepción que no se encuentre
-- ningún dato con el valor de v_empno de entrada,
-- mostrando el mensaje “No se encontraron datos”.

-- Invoca al procedimiento consultarEmpleado
-- pasando tres variables (id, nombre y puesto). La
-- variable id debe obtener su valor pidiéndola por
-- pantalla al usuario.
-- Se debe mostrar por pantalla el resultado devuelto
-- del procedimiento anterior en las variables de
-- salida nombre y puesto.


CREATE OR REPLACE PROCEDURE consultarEmpleado(v_empno IN emp.empno%TYPE, v_ename OUT emp.ename%TYPE, v_job OUT emp.job%TYPE)

IS 
    v_count int;
    noDatos EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO v_count FROM EMP WHERE EMPNO = v_empno;
    
    IF v_count = 0 THEN
        RAISE noDatos;
    ELSE
        SELECT ENAME, JOB INTO v_ename, v_job FROM EMP WHERE EMPNO = v_empno;
    END IF;
EXCEPTION
    WHEN noDatos THEN
      DBMS_OUTPUT.PUT_LINE('No se encontraron datos.'); 
END;
/

SELECT * FROM EMP;

DECLARE 
    nEmpleado EMP.EMPNO%TYPE := &numeroRec; 
    nNombre EMP.ENAME%TYPE;
    nTrabajo EMP.JOB%TYPE;
BEGIN 
    consultarEmpleado(nEmpleado, nNombre, nTrabajo);
    IF nNombre IS NOT NULL AND nTrabajo IS NOT NULL  THEN 
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || nNombre || ', Trabajo: ' || nTrabajo);
    END IF;
END; 
/

UNDEFINE numeroRec;


-- Escribe un procedimiento denominado is_today
-- que muestre por pantalla la fecha de hoy, y luego
-- llámalo desde un bloque anónimo.


CREATE OR REPLACE PROCEDURE is_today
IS 
    v_fecha DATE := SYSDATE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('La fecha de hoy es: ' || TO_CHAR(v_fecha, 'DD/MM/YYYY'));
END;
/

BEGIN 
    is_today;
END;
/

CREATE OR REPLACE PROCEDURE is_today2
IS
BEGIN
    IS_TODAY;
END;
/

SELECT * FROM DEPT;
SELECT * FROM EMP;

CREATE OR REPLACE PROCEDURE MostrarBecarios 
IS
    CONTADOR INT := 0;
BEGIN
    FOR i IN (SELECT * FROM DEPT) LOOP 
     FOR x IN (SELECT * FROM EMP WHERE DEPTNO = i.DEPTNO ORDER BY HIREDATE DESC) LOOP 
        CONTADOR := CONTADOR + 1;
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || x.ENAME || ', Departamento: ' || i.DNAME);
        IF CONTADOR = 2 THEN
            CONTADOR := 0;
           EXIT;
        END IF;
     END LOOP; 
    END LOOP;    
END;
/



BEGIN 
    MostrarBecarios;
END;
/