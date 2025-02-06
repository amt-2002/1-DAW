-- Ejercicio 12 

DECLARE 
    GOLES_CASA INT :=  &INPUT_GOLES_CASA; 
    GOLES_FUERA INT := &INPUT_GOLES_FUERA; 

BEGIN

    CASE 

    WHEN GOLES_CASA > GOLES_FUERA THEN 
        DBMS_OUTPUT.PUT_LINE('HA GANADO EL EQUIPO DE CASA');
    WHEN GOLES_FUERA > GOLES_CASA THEN 
        DBMS_OUTPUT.PUT_LINE('HA GANADO EL EQUIPO DE FUERA');
    ELSE
        DBMS_OUTPUT.PUT_LINE('HAN QUEDADO EMPATE');

    END CASE;

END;
/

UNDEFINE INPUT_GOLES_FUERA;
UNDEFINE INPUT_GOLES_CASA;

--Ejercicio 12 | AMPLIACIÓN
--A partir del campo RESULTADO de la tabla PARTIDOS
--para el día/fecha 08/01/2020, indica quién ha ganado
 
declare
    goles_casa int;
    goles_fuera int;
begin
    select to_number(substr(resultado,1,2)) into goles_casa from partidos where fecha = '08/01/2020';
    select to_number(substr(resultado,4,2)) into goles_fuera from partidos where fecha = '08/01/2020';
    case
    when goles_casa > goles_fuera then
        dbms_output.put_line('El equipo de casa ha ganado');
    when goles_casa < goles_fuera then
        dbms_output.put_line('El equipo visitante ha ganado');
    else
        dbms_output.put_line('El resultado del partido ha sido empate');
    end case;
end;
/