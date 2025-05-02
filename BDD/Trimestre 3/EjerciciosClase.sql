-- Se quiere saber si un año es bisiesto o no. Para ello, se debe pedir por pantalla introducir un año, y luego se mostrará un mensaje por pantalla indicando "El año es bisiesto" o "El año no es bisiesto", según corresponda. Un año es bisiesto si el resto de dividir el año entre 4 es cero y además, el resto de dividir ese año entre 100 es distinto de cero o bien el resto de dividir ese año entre 400 es cero.

DECLARE 
    anoRec DATE := '&anoRec'; 
    converAno VARCHAR(50);
BEGIN 
    converAno := TO_CHAR(anoRec, 'YYYY');
    if (mod(converAno, 4) = 0 and (mod(converAno, 100) > 0 or (mod(converAno, 400) = 0))) then 
        DBMS_OUTPUT.PUT_LINE('El año ' || converAno || ' es bisiesto'); 
    else 
        DBMS_OUTPUT.PUT_LINE('El año ' || converAno || ' no es bisiesto'); 
    END IF;
END; 
/

UNDEFINE anoRec;


-- Realiza el ejercicio anterior pero usando la siguiente condición para saber si es bisiesto: "un año bisiesto tiene 366 días".

DECLARE
    v_year NUMBER := &Ano; -- El usuario ingresa solo el año (ej: 2020)
    start_date DATE;
    end_date DATE;
    total_dias NUMBER;
BEGIN
    -- Construye fechas válidas a partir del año ingresado
    start_date := TO_DATE(v_year || '-01-01', 'YYYY-MM-DD');
    end_date := TO_DATE(v_year || '-12-31', 'YYYY-MM-DD');
    
    -- Calcula la diferencia de días +1 para incluir ambos extremos
    total_dias := end_date - start_date + 1;
    
    IF total_dias = 366 THEN
        DBMS_OUTPUT.PUT_LINE('El año ' || v_year || ' es bisiesto.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('El año ' || v_year || ' no es bisiesto.');
    END IF;
END;
/