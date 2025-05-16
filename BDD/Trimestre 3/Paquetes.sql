begin
    paquete1.reset_cont(20);
    reset_cont(20);
end;
/
 
create or replace package paquete1
IS
    procedure reset_cont(v_nuevo number);
    type miregistro is record(
        id int,
        nombre varchar2(50)
    );
    function otroProcedimiento return miregistro;
end;
/
 
create or replace package body paquete1
IS
    procedure reset_cont(v_nuevo number)
    IS
        mivariable miregistro;
    BEGIN
        mivariable.id := 1;
        dbms_output.put_line(v_nuevo || '-' || mivariable.id);
    end;
   
    function otroProcedimiento return miregistro
    IS
        resultado miregistro;
    BEGIN
        return resultado;
    end;
 
end;
/
 
--ejercicio 1


CREATE OR REPLACE PACKAGE operaciones 
IS
    function sumar(num1 int, num2 int) return int; 
    function restar(num1 int, num2 int) return int; 
    function positivo(num1 int) return boolean;

END; 
/

CREATE OR REPLACE PACKAGE BODY operaciones 
IS 
    function sumar(num1 int, num2 int) return int 
    IS 
    BEGIN 
        return num1+num2;
    END;

    function restar(num1 int, num2 int) return int 
    IS
    BEGIN
        return num1-num2;
    END;

    function positivo(num1 int) return boolean 
    IS 
        isPositivo boolean := false; 
    BEGIN
        IF NUM1 >= 0 THEN 
            isPositivo := true;
        END IF;
        return isPositivo;  
    END;
end; 
/

DECLARE
    estado varchar2(40) := 'Negativo'; 
    numResta int; 
BEGIN 
    numResta := operaciones.restar(10, 50);
    if OPERACIONES.POSITIVO(numResta) then 
        estado := 'Positivo'; 
    end IF;
    DBMS_OUTPUT.PUT_LINE('El resultado es ' || numResta || ' y es ' || estado);
END; 
/

select * from EMP;

create or replace package gestionEMP 
IS 
    PROCEDURE nuevoEmpleado(empleadoRec emp%rowtype); 
end; 
/ 

create or replace package body gestionEMP 
IS 
    PROCEDURE nuevoEmpleado(empleadoRec emp%rowtype) 
    IS 
    BEGIN 
        INSERT INTO EMP VALUES empleadoRec;
        COMMIT; 
        DBMS_OUTPUT.PUT_LINE('Registro creado correctamente'); 
    END; 
END; 
/

DELETE FROM EMP WHERE EMPNO = 8000;

DECLARE 
    v_empleado emp%rowtype;
BEGIN
    v_empleado.empno := 8000;
    v_empleado.ename := 'JUAN';
    v_empleado.job := 'CLERK';
    v_empleado.mgr := 7902;
    v_empleado.hiredate := '01/05/2022';
    v_empleado.sal := 1500;
    v_empleado.comm := null;
    v_empleado.deptno := 20;

    gestionEMP.nuevoEmpleado(v_empleado);
END;
/

--1. Crea un paquete llamado misFunciones que contenga una función llamada cuentaVocales que reciba como parámetro una palabra y devuelva el número de vocales que tenga (independientemente de que estén en mayúsculas o minúsculas).
--2. Ahora crea un procedimiento mostrarEmpMas1Vocal dentro del paquete misFunciones que muestre el nombre de todos los empleados (ename de la tabla emp) que tengan más de una vocal en su nombre. NOTA: utiliza la función cuentaVocales del paquete misFunciones.

create or replace package misFunciones 
IS
    function cuentaVocales(palabra varchar2) return int;
    procedure mostrarEmpMas1Vocal;
end misFunciones;
/
create or replace package body misFunciones
IS
    function cuentaVocales(palabra varchar2) return int
    IS
        v_vocales int := 0;
    BEGIN
        for i in 1..length(palabra) loop
            if substr(lower(palabra), i, 1) in ('a', 'e', 'i', 'o', 'u') then
                v_vocales := v_vocales + 1;
            end if;
        end loop;
        return v_vocales;
    END;

    procedure mostrarEmpMas1Vocal
    IS 
    BEGIN 
        FOR EMPS IN (SELECT ENAME FROM EMP) LOOP
            IF MISFUNCIONES.CUENTAVOCALES(EMPS.ENAME) > 1 THEN 
                DBMS_OUTPUT.PUT_LINE(EMPS.ENAME || ' TIENE MAS DE UNA VOCAL');
            END IF; 
        END LOOP;
    END; 

END misFunciones;
/
BEGIN 
    DBMS_OUTPUT.PUT_LINE(misFunciones.cuentaVocales('Juan'));
    MISFUNCIONES.MOSTRAREMPMAS1VOCAL;
END; 
/

--3. Crea un crud con distintas funciones dentro de un nuevo paquete denominado miCrud para insertar departamentos, borrarlos o modificarlos. Ten en cuenta que será necesario pasar como parámetro al menos la PK, comprobar que existe o no y actuar en consecuencia (utiliza las excepciones que creas convenie

SELECT * FROM DEPT;

CREATE OR REPLACE PACKAGE miCrud 
IS 
    FUNCTION INSERTDEPT(DEPTR DEPT%ROWTYPE) RETURN VARCHAR2;  
    FUNCTION DELETEDEPT(DANT DEPT.DEPTNO%TYPE) RETURN VARCHAR2;  
    FUNCTION UPDATEDEPT(DANT DEPT.DEPTNO%TYPE, DEPTR DEPT%ROWTYPE) RETURN VARCHAR2;
END;
/

CREATE OR REPLACE PACKAGE BODY miCrud 
IS 

    FUNCTION INSERTDEPT(DEPTR DEPT%ROWTYPE) RETURN VARCHAR2
    IS 
        CONTADOR INT := 0;
        YA_EXISTE EXCEPTION; 
    BEGIN 
        SELECT COUNT(DEPTNO) INTO CONTADOR FROM DEPT WHERE DEPTNO = DEPTR.DEPTNO; 
        IF CONTADOR > 0 THEN 
            RAISE YA_EXISTE; 
        END IF; 
        INSERT INTO DEPT VALUES DEPTR; 
        RETURN 'EL DEPARTAMENTO SE HA INGRESADO CORRECTAMENTE';
    EXCEPTION
        WHEN YA_EXISTE THEN 
            RETURN 'EL DEPTNO YA EXISTE EN LA BDD';
    END; 

    FUNCTION DELETEDEPT(DANT DEPT.DEPTNO%TYPE) RETURN VARCHAR2
    IS 
        EXISTE DEPT.DEPTNO%TYPE; 
    BEGIN
        SELECT DEPTNO INTO EXISTE FROM DEPT WHERE DEPTNO = DANT; 
        DELETE FROM DEPT WHERE DEPTNO = DANT;
        RETURN 'EL DEPARTAMENTO HA SIDO BORRADO CORRECTAMENTE';
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            RETURN 'EL DEPTNO YA NO EXISTE EN LA BDD';
    END; 

    FUNCTION UPDATEDEPT(DANT DEPT.DEPTNO%TYPE, DEPTR DEPT%ROWTYPE) RETURN VARCHAR2     
    IS
        EXISTE DEPT.DEPTNO%TYPE; 
    BEGIN  
        SELECT DEPTNO INTO EXISTE FROM DEPT WHERE DEPTNO = DANT; 
        UPDATE DEPT SET DEPTNO = DEPTR.DEPTNO, DNAME = DEPTR.DNAME, LOC = DEPTR.LOC WHERE DEPTNO = DEPTR.DEPTNO;
        RETURN 'EL DEPARTAMENTO HA SIDO ACTUALIZADO CORRECTAMENTE';
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
            RETURN 'EL DEPTNO NO EXISTE EN LA BDD';
    END; 
END; 
/

SELECT * FROM DEPT; 
DECLARE 
    NUEVODEPT DEPT%ROWTYPE; 
BEGIN 
    NUEVODEPT.DEPTNO := 11; 
    NUEVODEPT.DNAME := 'VENTAS'; 
    NUEVODEPT.LOC := 'ESPAÑA'; 
    DBMS_OUTPUT.PUT_LINE(miCrud.INSERTDEPT(NUEVODEPT));
    DBMS_OUTPUT.PUT_LINE(miCrud.UPDATEDEPT(NUEVODEPT.DEPTNO, NUEVODEPT));
END; 