CREATE OR REPLACE FUNCTION dameDeptno(v_name dept.dname%type) return dept.deptno%type
IS 
    v_deptno dept.deptno%type;
BEGIN
    SELECT deptno INTO v_deptno FROM dept WHERE dname = v_name;
    return v_deptno;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontró el departamento: ' || v_name);
        RETURN -1;
END;
/

DECLARE 
    nameDept dept.dname%type := 'SALES';
BEGIN 
    DBMS_OUTPUT.PUT_LINE(dameDeptno(nameDept));
END;
/



--Funciones con parámetros
--Queremos una función datoFecha a la que le pasaremos dos parámetros (siempre son de entrada). El primer parámetro es una fecha y el segundo puede ser 'DIA' o 'MES', de forma que la función devuelva el nombre del mes o el nombre del día de la semana de esa fecha. Ej. sysdate,'DIA' > JUEVES. sysdate,'MES' > ABRIL

create or replace function datoFecha(fecha date, datoAMostrar varchar2) return varchar2
IS 
    v_dia varchar2(50);
    v_mes varchar2(50);
BEGIN
    v_dia := to_char(fecha, 'DAY');
    v_mes := to_char(fecha, 'MONTH');

    IF datoAMostrar = 'DIA' THEN
        RETURN TRIM(v_dia);
    ELSIF datoAMostrar = 'MES' THEN
        RETURN TRIM(v_mes);
    ELSE
        RETURN 'Error: El segundo parámetro debe ser "DIA" o "MES"';
    END IF;
END; 
/ 

begin
    dbms_output.put_line(datoFecha(sysdate,'DIA'));
    dbms_output.put_line(datoFecha('01/01/2025', 'MES'));
    dbms_output.put_line(datoFecha('31/12/2025', 'DIA'));
end;
/

ALTER SESSION SET NLS_DATE_LANGUAGE = 'SPANISH';

COMMIT; 


-- EJERCICIO 6 

SELECT * FROM ESTUDIANTES;

CREATE OR REPLACE FUNCTION nombreEstudiante( v_codigo estudiantes.codigo%type) return varchar
IS 
    v_nombre_completo varchar(250);
BEGIN 
    SELECT NOMBRE || ' ' || APELLIDOS "NOMBRE_COMPLETO" INTO v_nombre_completo FROM ESTUDIANTES WHERE CODIGO = v_codigo ;
    RETURN v_nombre_completo;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se encontró el estudiante con código: ' || v_codigo);
        RETURN NULL;
END;
/

DECLARE 
    v_codigo estudiantes.codigo%type := 1; 
    v_nombre varchar(250);
BEGIN 
    v_nombre := nombreEstudiante(v_codigo);
    IF v_nombre IS NOT NULL THEN
        DBMS_OUTPUT.PUT_LINE('Nombre completo del estudiante: ' || v_nombre);
    END IF;
END;
/

-- EJERCICIO 7

CREATE OR REPLACE FUNCTION totalEstudiantes return number 
IS 
    total number; 
BEGIN 
    SELECT COUNT(*) INTO total FROM ESTUDIANTES;
    RETURN total;
END;
/

BEGIN 
    DBMS_OUTPUT.PUT_LINE('Total de estudiantes: ' || totalEstudiantes());
END;
/