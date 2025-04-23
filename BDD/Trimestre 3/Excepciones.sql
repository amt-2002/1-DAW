-- Configurar la sesión en español
ALTER SESSION SET NLS_LANGUAGE = 'SPANISH';
ALTER SESSION SET NLS_TERRITORY = 'SPAIN';

COMMIT;

select * from asignaturas;
set serveroutput on;
declare
    miDescripcion asignaturas.descripcion%type;
    num int := 5;
    miExcepcion exception;
    numMiError int := -20001;
begin
    --dbms_output.put_line(4/0);
    --Si num es menor de 5 no quiero que se siga ejecutando
    if num < 5 then
        raise miExcepcion;
    else
        raise_application_error(numMiError,'Este es un error personalizado');
    end if;
    --Primera excepción es no data found
    --select descripcion into miDescripcion from asignaturas where codigo = 11;
    --Segunda excepción es too many rows
    select descripcion into miDescripcion from asignaturas where curso = 1;
    dbms_output.put_line(miDescripcion);
exception
    when miExcepcion then
        dbms_output.put_line(SQLCODE);
        dbms_output.put_line('No se permite que valga menos de 5');
    when others then
        if sqlcode = -1422 then
            dbms_output.put_line('Hay demasiados valores');
        elsif sqlcode = -20001 then
            dbms_output.put_line('El mío');
        else 
            dbms_output.put_line(SQLCODE);
            dbms_output.put_line(SQLERRM);
            dbms_output.put_line('Error');
        end if;
end;
/



-- EJERCICIO 1

DECLARE 
    NUMERO int := 5;

BEGIN 
  NUMERO := NUMERO / 0;
EXCEPTION 
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('Se ha producido un error: ' || SQLERRM || ' - Código de error: ' || SQLCODE); 
        DBMS_OUTPUT.PUT_LINE('EL ERROR CON SOLO EL TEXTO ES : ' || TRIM(SUBSTR(SQLERRM, INSTR(SQLERRM, ':') + 1)));
END;
/


-- -- EJERCICIO 2 
-- Sobre la tabla Estudiantes. Escribir un bloque que muestre el
-- número total de estudiantes y lanzar una excepción
-- NO_ALUMNOS si el número es igual a 0, indicando con un
-- mensaje que no hay alumnos.

SELECT * FROM ESTUDIANTES;

DECLARE 
    NUMERO int := 0;
    NO_ALUMNOS EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO NUMERO FROM ESTUDIANTES;
    DBMS_OUTPUT.PUT_LINE('Número total de estudiantes: ' || NUMERO);
    
    IF NUMERO = 0 THEN
        RAISE NO_ALUMNOS;
    END IF;
EXCEPTION 
    WHEN NO_ALUMNOS THEN 
        DBMS_OUTPUT.PUT_LINE('No hay alumnos en la tabla Estudiantes.');
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('Se ha producido un error: ' || SQLERRM || ' - Código de error: ' || SQLCODE);
END; 
/

-- -- EJERCICIO 3

DECLARE 
    NUMERO int := 0; 
    MUCHOS_ALUMNOS EXCEPTION;
BEGIN
    SELECT COUNT(*) INTO NUMERO FROM ESTUDIANTES;
    DBMS_OUTPUT.PUT_LINE('Número total de estudiantes: ' || NUMERO);
    
    IF NUMERO >= 5 THEN
        RAISE MUCHOS_ALUMNOS;
    END IF;

EXCEPTION 
    WHEN MUCHOS_ALUMNOS THEN 
        DBMS_OUTPUT.PUT_LINE('Hay demasiados alumnos en la tabla Estudiantes.');
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('Se ha producido un error: ' || SQLERRM || ' - Código de error: ' || SQLCODE);
END;
/

-- EJERCICIO PRUEBA REAL 

SELECT CANDIDATE_ID FROM CANDIDATES WHERE SKILL = 'Python' or SKILL = 'Tableau' or SKILL = 'PostgreSQL' 
    GROUP BY CANDIDATE_ID HAVING COUNT(SKILL) = 3 ORDER BY CANDIDATE_ID ASC;


-- BOLETIN DE EJERCICIOS

--Boletín ejercicios con excepciones
--1 Pide al usuario que introduzca un código de asignatura y muestra el código junto al curso y descripción. Controla las siguiente excepciones mostrando un mensaje de error: no existe ese código en la tabla asignaturas.



--2 Se quiere pedir al usuario que introduzca un nivel de curso (primer curso o segundo), introduciendo 1 o 2 por teclado. Una vez se meta el nivel, muestra por la salida todas las descripciones de las asignaturas de ese nivel. Excepciones a tener en cuenta mostrando un mensaje de error: el nivel no es un número válido y el número no existe en la tabla asignaturas. NOTA: para saber si han introduciendo un número, puedes controlarlo con la excepción value_error a la que se accede cuando se produce un error en una conversión (por ejemplo al llamar a to_number() y no puede hacer la conversión).

SELECT * FROM ASIGNATURAS;

DECLARE 
    CURSO VARCHAR2(100) := '&CURSOREC';
    CURSO_NUM INT;
    CURSOR CURSOR_C1 IS SELECT CODIGO, CURSO, DESCRIPCION FROM ASIGNATURAS WHERE CURSO = CURSO_NUM;
BEGIN 
    CURSO_NUM := TO_NUMBER(CURSO);

    IF CURSO_NUM = 1 OR CURSO_NUM = 2 THEN 
        FOR I IN CURSOR_C1 LOOP 
            DBMS_OUTPUT.PUT_LINE('Código: ' || I.CODIGO || ', Curso: ' || I.CURSO || ', Descripción: ' || I.DESCRIPCION); 
        END LOOP;
    END IF; 


EXCEPTION 
    WHEN VALUE_ERROR THEN 
        DBMS_OUTPUT.PUT_LINE('El nivel no es un número válido.');
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('El número no existe en la tabla asignaturas.');
END;
/

UNDEFINE CURSOREC;

--3 Se quiere una lista donde se muestre el curso y cuántas asignaturas hay en ese curso (una línea por cada curso). Ejemplo: Curso 1: 4 asignaturas. Excepciones a tener en cuenta: crea una excepción personalizada llamada cursoConRedes de forma que si el curso tiene la asignatura con descripción "Redes" no debes mostrarlo por pantalla, terminando la ejecución de tu código y mostrando en tu excepción el siguiente mensaje: "No se puedes mostrar datos porque existe la asignatura de Redes".

SELECT * FROM ASIGNATURAS;

DECLARE 
    CURSO_PEDIDO VARCHAR2(100) := '&CURSO';
    cursoConRedes EXCEPTION; 
    tieneRedes INT;
    CURSOR CURSOINFO IS SELECT COUNT(CURSO) "CONT" FROM ASIGNATURAS WHERE CURSO = CURSO_PEDIDO GROUP BY CURSO ;

BEGIN 
    SELECT COUNT(*) INTO tieneRedes FROM ASIGNATURAS WHERE CURSO = CURSO_PEDIDO AND DESCRIPCION = 'Redes';
    if tieneRedes > 0 then 
        raise cursoConRedes;
    else 
        FOR I IN CURSOINFO LOOP 
            DBMS_OUTPUT.PUT_LINE('CURSO ' || CURSO_PEDIDO || ': ' || I.CONT || ' ASIGNATURAS');
        END LOOP;
    end if;

EXCEPTION 
    WHEN cursoConRedes THEN 
        DBMS_OUTPUT.PUT_LINE('No se puedes mostrar datos porque existe la asignatura de Redes');

END; 
/ 

UNDEFINE CURSO;


--4 Se quiere mostrar por la salida el nombre de cada asignatura y la nota media obtenida en las matrículas de esa asignatura por parte de los alumnos. Excepciones a tener en cuenta: crea una excepción personalizada menosDeCinco que, una vez mostradas todas las notas media, si alguna tiene un valor menor a cinco, llamar a esa excepción personalizada indicando el mensaje "Hay alguna asignatura con una media inferior a cinco", sustituyendo AAA por el valor concreto.

SELECT * FROM MATRICULAS;
SELECT * FROM ESTUDIANTES;
SELECT * FROM ASIGNATURAS;

SELECT ASG.DESCRIPCION, AVG(MAT.NOTA) FROM ASIGNATURAS "ASG" LEFT JOIN MATRICULAS "MAT" ON ASG.CODIGO = MAT.COD_ASIGNATURA GROUP BY ASG.DESCRIPCION;


DECLARE
    menosDeCinco EXCEPTION;
    CURSOR CURSOS IS SELECT ASG.DESCRIPCION "DESCP", AVG(MAT.NOTA) "NOTA" FROM ASIGNATURAS "ASG" LEFT JOIN MATRICULAS "MAT" 
        ON ASG.CODIGO = MAT.COD_ASIGNATURA GROUP BY ASG.DESCRIPCION;
    hayCinco BOOLEAN := false;
    cantidadAsigs INT := 0;
BEGIN 
    FOR I IN CURSOS LOOP 
      DBMS_OUTPUT.PUT_LINE('ASIGNATURA ' || I.DESCP || ' MEDIA ' || I.NOTA);
      IF I.NOTA < 5 THEN 
        hayCinco := true;
        cantidadAsigs := cantidadAsigs + 1;
      END IF; 
    END LOOP;

    IF hayCinco THEN 
        RAISE menosDeCinco;
    END IF; 

EXCEPTION 
    WHEN menosDeCinco THEN
        DBMS_OUTPUT.PUT_LINE('Hay ' || cantidadAsigs || ' asignaturas con una media inferior a cinco');
END; 
/

UNDEFINE CURSO;

--5 Modifica el ejercicio 4 para mostrar por la salida solo las asignaturas que tienen una media superior a 5. A continuación, si has mostrado una o más asignaturas con una media con decimales, llama a una excepción personalizada tienenDecimales que muestre todas esas asignaturas con decimales, separadas por coma. 

DECLARE
    tienenDecimales EXCEPTION;
    CURSOR CURSOS IS SELECT ASG.DESCRIPCION "DESCP", AVG(MAT.NOTA) "NOTA" FROM ASIGNATURAS "ASG" LEFT JOIN MATRICULAS "MAT" 
        ON ASG.CODIGO = MAT.COD_ASIGNATURA GROUP BY ASG.DESCRIPCION;
    hayDecimales BOOLEAN := false;
    asigsDecimales VARCHAR2(4000) := '';

BEGIN 
    FOR I IN CURSOS LOOP 
      IF I.NOTA > 5 THEN 
        DBMS_OUTPUT.PUT_LINE('ASIGNATURA ' || I.DESCP || ' MEDIA ' || I.NOTA);
        IF MOD(I.NOTA, 1) != 0 THEN 
            hayDecimales := true;
            IF asigsDecimales != '' THEN
                asigsDecimales := asigsDecimales || ', ';
            END IF;
            asigsDecimales := asigsDecimales || I.DESCP;
        END IF;  
      END IF; 
    END LOOP;

    IF hayDecimales THEN 
        RAISE tienenDecimales;
    END IF; 

EXCEPTION 
    WHEN tienenDecimales THEN
        DBMS_OUTPUT.PUT_LINE('ASIGNATURAS CON DECIMALES: ' || asigsDecimales);
END; 
/

--6 Se quiere pedir por teclado el código de una asignatura. Muestra una lista de todos los alumnos que están matriculados (dni y nombre de los almnos) y la nota que han sacado. Ten en cuenta las siguientes excepciones: el código de asignatura es un número, existe en la tabla asignaturas y además hay matrículas de alumnos en esa asignatura. Para esa última excepción, crea una excepción personalizada que se llame noMatriculas.

