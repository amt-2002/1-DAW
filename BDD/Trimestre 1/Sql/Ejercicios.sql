drop table usuarios; 
CREATE TABLE usuarios ( -- Crear tabla
        dni int, 
        username varchar2(50), 
        clave varchar2(100)
);

alter table usuarios add localidad varchar2(50);  -- Alternar tabla (añadir)
alter table usuarios drop column clave;  -- Alternar tabla (borrar)
alter table usuarios rename column username to nombre; -- Alternar tabla (renombrar) 

-- Ejercicio 1 hasta 5
drop table alumnos1; 
CREATE TABLE alumnos1 (
        dni char(9) primary key, 
        nombre varchar2(15),
        apellido varchar2(200)
);

alter table alumnos1 add cod_postal number(5); 

alter table alumnos1 add fecha_nacimiento date; 

alter table alumnos1 drop column cod_postal; 
alter table alumnos1 rename column fecha_nacimiento to f_nacimiento; 

-- Ejercicio 5 segunda parte

drop table alumnos2; 
create table alumnos2 (
        dni char(9), 
        nombre varchar2(15), 
        apellido varchar2(200) 
); 

alter table alumnos2 add primary key (dni); 

-- Ejercicio 5 tercera parte 

drop table alumnos3; 
create table alumnos3 (
         dni char(9), 
        nombre varchar2(15), 
        apellido varchar2(200) 
); 

alter table alumnos3 add constraint pkdni primary key (dni); 

-- Ejercicio 5 cuarta parte 

drop table alumnos4; 
create table alumnos4 (
        dni char(9), 
        nombre varchar2(15), 
        apellido varchar2(200),
        primary key (dni)
); 




        