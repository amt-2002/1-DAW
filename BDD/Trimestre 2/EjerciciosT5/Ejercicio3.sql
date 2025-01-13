select *
    from futbolistas
    where posicion = 'DEFENSA' and nombre like 'M%'
    order by nombre desc;

--Sustituir la letra O por * en los nombres anteriores
select id, replace(replace(nombre,'o','*'),'O','*') "NOMBRE", apellidos, fecha_nacimiento, posicion, salario, id_equipo
    from futbolistas
    where posicion = 'DEFENSA' and nombre like 'P%'
    order by nombre desc;

--Quiero que la query anterior sea insensible a mayúsculas y minúsculas



/*Primero inserta un nuevo futbolista con los siguientes datos:
    ID: F00111
    NOMBRE: MIGUEL
    APELLIDOS: GARCIA
    FECHA_NACIMIENTO: 22/02/1980
    POSICION: DEFENSA
    SALARIO: 350000
    ID_EQUIPO: 1
*/

INSERT INTO futbolistas values ('F80120', 'MIGUEL', 'GARCIA', '22/02/1980', 'DEFENSA', 350000, 1);

-- Quiero mostrar solo el primer nombre de los futbolistas

SELECT NOMBRE, ID FROM FUTBOLISTAS;
SELECT SUBSTR(NOMBRE, 2) FROM FUTBOLISTAS;
UPDATE FUTBOLISTAS SET NOMBRE = 'MIGUEL   ' WHERE ID = 'F80120';
SELECT NOMBRE, LENGTH(NOMBRE), TRIM(NOMBRE), LENGTH(TRIM(NOMBRE)) FROM FUTBOLISTAS;
SELECT NOMBRE, REPLACE (NOMBRE, ' ', '') FROM FUTBOLISTAS;
SELECT TRIM(NOMBRE) FROM FUTBOLISTAS;
SELECT NOMBRE, INSTR(NOMBRE, ' ') FROM FUTBOLISTAS;

SELECT NOMBRE, TRIM(SUBSTR(NOMBRE, 1, (INSTR(CONCAT(NOMBRE, ' '), ' ')))) "PRIMER NOMBRE" FROM FUTBOLISTAS;

SELECT SYSDATE FROM DUAL;
SELECT NEXT_DAY(SYSDATE, 'THURSDAY') FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MONTH') FROM DUAL;
SELECT TO_CHAR(TO_DATE('25/12/2024'), 'MONTH') FROM DUAL; 

COMMIT; 