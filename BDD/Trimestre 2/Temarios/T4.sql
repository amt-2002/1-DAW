ALTER SESSION SET NLS_DATE_LANGUAGE = 'SPANISH';

drop table estudiantes cascade constraints;

create table estudiantes(

    id int primary key,

    nombre varchar(50),

    apellidos varchar(100),

    edad int

);

--Actividad 3

alter table estudiantes add ciclo varchar2(50) default 'DAMDAW';

insert into estudiantes values (1,'María','García',28,null);

insert into estudiantes (id, nombre, apellidos, edad) values (3,'Pedro','García',28);

insert into estudiantes (id,nombre) values (2,'Juan');

select * from estudiantes;

update estudiantes set apellidos = 'González' 

    where id = 1;

update estudiantes set nombre = 'Pedro Luis', edad=30 where id = 3;

update estudiantes set ciclo = 'DAW';

update estudiantes set nombre = 'Jua' where id = 2;

update estudiantes set nombre = 'Juan' where id = 2;

--'28/11/2024' '28-11-2024' '28/11/24'

update estudiantes set edad = 23 where id = 2 or id = 3;

update estudiantes set edad = 24 where id in (1,2,3);

--Actividad 4

insert into estudiantes (id,nombre) values (4,'Luis');

insert into estudiantes (id,nombre) values (5,'Pedro');

update estudiantes set edad = 23 where id = 4;

update estudiantes set edad = 19 where id = 5;

select * from estudiantes;

--Actividad 5

update estudiantes set edad = 19;

delete from estudiantes where id = 3;

drop table notas cascade constraints;

create table notas(

    id int primary key,

    valor number(3,1),

    id_estudiante int,

    foreign key(id_estudiante) references estudiantes(id) 

);

insert into notas values (1,7,1);

insert into notas values (2,4,2);

select * from notas;

delete from estudiantes where id = 2;

--Ejemplo modo on delete cascade

drop table notas cascade constraints;

create table notas(

    id int primary key,

    valor number(3,1),

    id_estudiante int,

    foreign key(id_estudiante) references estudiantes(id) on delete cascade

);

insert into notas values (1,7,1);

insert into notas values (2,4,2);

delete from estudiantes where id = 2;

select * from estudiantes;

select * from notas;


--Ejemplo modo on delete set null

insert into estudiantes (id,nombre) values (2,'Juan');

drop table notas cascade constraints;

create table notas(

    id int primary key,

    valor number(3,1),

    id_estudiante int,

    foreign key(id_estudiante) references estudiantes(id) on delete set null

);

insert into notas values (1,7,1);

insert into notas values (2,4,2);

select * from notas;

select * from estudiantes;

delete from estudiantes where id = 2;

select * from estudiantes;

select * from notas;
 

drop table socios cascade constraints;
create table socios(
    codigo_socio char(8) check(regexp_like(codigo_socio,'S[0-9]{5}24')) primary key,
    dni char(9) check(regexp_like(dni,'[0-9]{8}[A-Z]')),
    nombre varchar(100),
    apellidos varchar(200),
    direccion varchar(300),
    telefono number(9)
);
drop table libros cascade constraints;
create table libros(
    isbn char(17) check(regexp_like(isbn,'[0-9]{13}[A-Z]{4}')) primary key,
    titulo varchar(200),
    editorial varchar(50),
    ano_publicacion int,
    autores varchar(300),
    ano int,
    edicion int,
    deteriorado char(2) check(deteriorado in ('Si','No'))
    --otro ejemplo deteriorado char(2) check(deteriorado = 'Si' or deteriorado = 'No')
);
drop table prestamos cascade constraints;
create table prestamos(
    codigo_socio char(8) check(regexp_like(codigo_socio,'S[0-9]{5}24')),
    isbn char(17) check(regexp_like(isbn,'[0-9]{13}[A-Z]{4}')),
    fecha_prestamo date,
    fecha_devolucion date,
    fecha_real_devolucion date,
    primary key(codigo_socio,isbn),
    foreign key(codigo_socio) references socios(codigo_socio) on delete set null,
    foreign key(isbn) references libros(isbn) on delete set null,
    check(fecha_devolucion>fecha_prestamo+15),
    check(fecha_real_devolucion>=fecha_prestamo)
);
--2. Crea un par de socios
insert into socios values ('S0000024','12345678X','Nombre','Apellidos','Dirección',123456789);
insert into socios values ('S1111124','11145678X','Socio 2','Apellidos','Dirección',123456711);
select * from socios;
--3
insert into libros values ('0000000000000AAAA','Libro 1','Editorial',1995,'Autor 1',1998,4,'No');
insert into libros values ('0000000000011BBAA','Libro 2','Editorial',2015,'Autor 2',2015,1,'Si');
insert into libros values ('0000000000022CCAA','Libro 3','Editorial 3',2010,'Autor 1',2011,2,'No');
select * from libros;
--4
ALTER SESSION SET nls_date_format='DD/MM/YYYY';
insert into prestamos values ('S0000024','0000000000000AAAA','01/11/2024','17/11/2024','18/11/2024');
insert into prestamos values ('S0000024','0000000000011BBAA','01/12/2024','17/12/2024','16/12/2024');
--Otros ejercicios
--1
insert into prestamos values ('S1111124','0000000000011BBAA','17/12/2024','02/01/2025','02/01/2025');
--2
update socios set nombre='Socio 1', apellidos='AP1' where codigo_socio = 'S0000024';
update socios set nombre='Socio 2 new', apellidos='AP2' where codigo_socio = 'S1111124';
select * from socios;
--3
update libros set edicion = 2018;
select * from libros;
--no pongo where porque me dicen todos
--4
select * from libros;
update libros set deteriorado = 'Si' where isbn = '0000000000000AAAA';
 
select deteriorado from libros;
select distinct deteriorado from libros;
select * from libros;
select * from prestamos;
select * from libros,prestamos where libros.isbn = prestamos.isbn;
select * from libros where autores = 'Autor 1';
select * from libros where autores = 'Autor 1' and deteriorado = 'Si';
 
ALTER SESSION SET nls_date_format='DD-MM-YYYY HH24:MI:SS';
DROP TABLE FUTBOLISTAS CASCADE CONSTRAINTS;
DROP TABLE EQUIPOS CASCADE CONSTRAINTS;
DROP TABLE PARTIDOS CASCADE CONSTRAINTS;
 
CREATE TABLE FUTBOLISTAS(
ID CHAR(6) PRIMARY KEY CHECK( REGEXP_LIKE( ID, 'F[0-9][0-9][0-9]20' )),
NOMBRE VARCHAR(100),
APELLIDOS VARCHAR(300),
FECHA_NACIMIENTO DATE,
POSICION VARCHAR(50) CHECK( POSICION LIKE 'PORTERO' OR POSICION LIKE 'DEFENSA' OR POSICION LIKE 'MEDIOCENTRO' OR POSICION LIKE 'DELANTERO' ),
SALARIO NUMBER(12,2) CHECK( SALARIO > 50000),
ID_EQUIPO INT
);
 
CREATE TABLE EQUIPOS(
ID INT PRIMARY KEY,
NOMBRE VARCHAR(100),
ESTADIO VARCHAR(100),
PRESUPUESTO NUMBER(20,2)
);
 
CREATE TABLE PARTIDOS(
ID INT PRIMARY KEY,
ARBITRO VARCHAR(200),
RESULTADO VARCHAR(5) CHECK( REGEXP_LIKE( RESULTADO, '[0-9][0-9]-[0-9][0-9]' )),
ESTADIO VARCHAR(100),
FECHA DATE,
ID_EQUIPO_CASA INT,
ID_EQUIPO_FUERA INT
);
 
ALTER TABLE FUTBOLISTAS
ADD CHECK (FECHA_NACIMIENTO > '31/DEC/1974');
ALTER TABLE FUTBOLISTAS
ADD FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS(ID);
 
ALTER TABLE PARTIDOS
ADD FOREIGN KEY (ID_EQUIPO_CASA) REFERENCES EQUIPOS(ID);
ALTER TABLE PARTIDOS
ADD FOREIGN KEY (ID_EQUIPO_FUERA) REFERENCES EQUIPOS(ID);
 
DELETE FROM EQUIPOS;
INSERT INTO EQUIPOS VALUES (1,'EQUIPO A', 'ESTADIO A',1000000);
INSERT INTO EQUIPOS VALUES (2,'EQUIPO B', 'ESTADIO B',2000000);
INSERT INTO EQUIPOS VALUES (3,'EQUIPO C', 'ESTADIO C',3000000);
 
DELETE FROM FUTBOLISTAS;
INSERT INTO FUTBOLISTAS VALUES ('F00120','PEDRO','GOMEZ','22/01/1980','PORTERO',100000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00220','PEDRO LUIS','GOMEZ','20/04/1985','DEFENSA',110000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00320','LUIS','GALVEZ','12/01/1990','DELANTERO',80000,1);
INSERT INTO FUTBOLISTAS VALUES ('F00420','ANTONIO','DOMINGUEZ','25/06/1981','PORTERO',340000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00520','JESUS','FERNANDEZ','02/01/1995','MEDIOCENTRO',140000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00620','DIEGO','DIAZ','05/04/1987','PORTERO',160000,2);
INSERT INTO FUTBOLISTAS VALUES ('F00720','PABLO','CARO','27/01/1988','DEFENSA',200000,3);
INSERT INTO FUTBOLISTAS VALUES ('F00820','ESTEBAN','BENITEZ','29/09/2000','DEFENSA',300000,3);
INSERT INTO FUTBOLISTAS VALUES ('F00920','ENRIQUE','ALVAREZ','30/09/2001','MEDIOCENTRO',120000,3);
 
DELETE FROM PARTIDOS;
INSERT INTO PARTIDOS VALUES (1,'ARBITRO A','00-00','ESTADIO A','01/01/2020',1,2);
INSERT INTO PARTIDOS VALUES (2,'ARBITRO B','01-00','ESTADIO A','08/01/2020',1,3);
INSERT INTO PARTIDOS VALUES (3,'ARBITRO C','01-01','ESTADIO B','15/01/2020',2,3);
INSERT INTO PARTIDOS VALUES (4,'ARBITRO B','02-00','ESTADIO B','22/01/2020',2,1);
INSERT INTO PARTIDOS VALUES (5,'ARBITRO A','04-01','ESTADIO C','29/01/2020',3,1);
INSERT INTO PARTIDOS VALUES (6,'ARBITRO A','03-03','ESTADIO C','05/02/2020',3,2);
 
UPDATE FUTBOLISTAS SET ID_EQUIPO = 2 WHERE ID LIKE 'F00120';
UPDATE FUTBOLISTAS SET ID_EQUIPO = 3 WHERE ID LIKE 'F00420';
UPDATE FUTBOLISTAS SET ID_EQUIPO = 1 WHERE ID LIKE 'F00920';
 
DELETE FROM FUTBOLISTAS WHERE ID LIKE 'F00120' OR ID LIKE 'F00420';
SELECT * FROM FUTBOLISTAS;
--Ejercicio 1
select nombre from futbolistas;
select posicion from futbolistas;
select distinct posicion from futbolistas;
 
select * from partidos;
select estadio "Estadio", id_equipo_casa "ID local" from partidos;
select p.estadio, p.id_equipo_casa from partidos p;
 
--Ejercicio 2
select distinct posicion "Demarcaciones" from futbolistas;
select * from futbolistas;
 
--Ejercicio 3

SELECT FUTBOLISTAS.APELLIDOS "Futbolista" FROM FUTBOLISTAS WHERE POSICION = 'DEFENSA';

select F.apellidos "Futbolista" 
    from futbolistas F 
    where posicion = 'DEFENSA';
 
select * from futbolistas order by nombre;
select * from futbolistas order by 2;
 
--ejercicio 4
select apellidos 
    from futbolistas 
    where posicion = 'DEFENSA' 
    order by apellidos desc;
 
--ejercicio 5
select * from futbolistas order by posicion,apellidos;
 
select * from dual;
select 5*4 "resultado" from dual;
select * from futbolistas;
select nombre from futbolistas where nombre like 'P%';
select nombre from futbolistas where nombre like '_E%';
select nombre from futbolistas where nombre like '%E%';
select nombre from futbolistas where nombre like '%E';
 
--ejercicio 6
select nombre from futbolistas where salario > 150000;
select id from futbolistas where apellidos = 'GOMEZ';
select apellidos from futbolistas where apellidos like 'G%';
select * 
    from futbolistas 
    where posicion = 'DEFENSA' or posicion = 'DELANTERO';
select *
	from futbolistas
	where posicion in ('DEFENSA','POSICION');
select nombre from futbolistas 
	where salario between 100000 and 200000;
select nombre from futbolistas
	where salario > 100000 and salario < 200000;
select 4*5+2 from dual;

--SEGUIMOS POR LA TRANSPARENCIA 37

--Ejercicio 7
select nombre,apellidos "Apellidos",salario*1.10 "Nuevo salario"
    from futbolistas 
    where posicion = 'PORTERO'
    order by apellidos;
ALTER SESSION SET nls_date_format='DD/MM/YYYY';
select 'hola ' || sysdate from dual;
select 'La posición del futbolista ' || nombre || ' es ' || posicion "Descripción de los futbolistas"
	from futbolistas;
--Función concat(cad1,cad2) --> cad1cad2
select concat('hola ', sysdate) from dual;
--Ejercicio 8
select nombre || ' es ' || posicion "Posiciones"
	from futbolistas;
 
select futbolistas.nombre || ' juega en ' || equipos.nombre
	from futbolistas,equipos
	where id_equipo = equipos.id;
--multitabla
--join
--subconsultas
 
--Ejercicio 9
select * from futbolistas 
    where (salario > 150000) and (posicion = 'DEFENSA');
select * from futbolistas 
    where (posicion = 'DEFENSA') and (salario > 150000);
 
--Ejercicio 11

select * from futbolistas; 
select nombre, salario, salario*1.5 || ' euros' "Salario bruto"
    from futbolistas; 

select
	nombre,salario,salario*1.5 || ' euros' "Salario bruto"
from
	futbolistas;


select concat(concat(concat(concat(concat('1','.'),' '),'soy'),' '),'groot') from dual;
select upper(substr('hola',1,1))||'ola' from dual;
select initcap('hola') from dual;
--CONCAT() ||
select concat(concat(concat(concat(concat('1','.'),' '),'soy'),' '),'groot') from dual;
--1. Soy groot
select ceil(11) from dual;
select ceil(11.9) from dual;
select ceil(11.1) from dual;
select floor(11) from dual;
select floor(11.9) from dual;
select floor(11.1) from dual;
select mod(10,6) from dual; 
--10 / 6 = 1 _ 4
select power(10,2) from dual;

-- Ejercicio 12
select abs(-10) from dual;


--Ejemplos to_number()
select '1000€' - '20€' from dual;
-- ALTER SESSION SET NLS_CURRENCY='€'; PARA QUE VAYA EL EURO
--select to_number('1000€','9999L') from dual;
select to_number('$1000','$9999') from dual;
select to_number('1000€','9999L')-to_number('20€','99L') from dual;
select trim(to_char(sysdate,'MI DAY:MONTH')) from dual;
select 
    to_char(sysdate,'MI') || 
    ' ' ||
    trim(to_char(sysdate,'DAY')) || 
    ':' || 
    trim(to_char(sysdate,'MONTH'))
from
	dual;
select '09/01/2025' from dual;
select to_date('09/01/2025') from dual;

SELECT * FROM FUTBOLISTAS;

UPDATE FUTBOLISTAS SET POSICION = NULL WHERE ID = 'F00220';
UPDATE FUTBOLISTAS SET SALARIO = NULL WHERE NOMBRE = 'LUIS';


INSERT INTO FUTBOLISTAS (ID, NOMBRE, APELLIDOS, FECHA_NACIMIENTO, POSICION, SALARIO, ID_EQUIPO) VALUES ('F00420', 'DIEGO', 'GOMEZ', '11-11-1998', 'PORTERO', NULL, 1);
INSERT INTO FUTBOLISTAS VALUES ('F00420', 'DIEGO', 'GOMEZ', '11-11-1998', 'PORTERO', NULL, 1);
DELETE FROM FUTBOLISTAS WHERE ID = 'F00420';

-- NVL Y DECODE 
SELECT NVL(SALARIO,0) FROM FUTBOLISTAS; --SI ES NULL PONE 0

SELECT DECODE(SALARIO, NULL ,'NO TIENE', SALARIO) FROM FUTBOLISTAS; --SI ES NULL PONE 0
SELECT DECODE(SALARIO, NULL, 'NO TIENE', 110000, 'BUEN SUELDO', SALARIO) FROM FUTBOLISTAS; 


-- FUNCTIONES DE AGREGADO

SELECT COUNT(*) FROM FUTBOLISTAS; -- Devuelve el número de filas de la tabla   
SELECT * FROM FUTBOLISTAS; 
SELECT COUNT(SALARIO) FROM FUTBOLISTAS;

-- SUM ()
SELECT SUM(SALARIO) FROM FUTBOLISTAS; -- Devuelve la suma de los valores de la columna

-- MIN ()
SELECT MIN(SALARIO) FROM FUTBOLISTAS; -- Devuelve el valor mínimo de la columna

-- MAX ()
SELECT MAX(SALARIO) FROM FUTBOLISTAS; -- Devuelve el valor máximo de la columna

-- AVG ()
SELECT AVG(SALARIO) FROM FUTBOLISTAS; -- Devuelve el valor medio de la columna
SELECT ROUND(AVG(SALARIO),2) "SALARIO MEDIO" FROM FUTBOLISTAS; -- Devuelve el valor medio de la columna

-- GROUP BY
SELECT POSICION FROM FUTBOLISTAS GROUP BY POSICION; -- Devuelve el número de futbolistas por posición

-- HAVING
SELECT POSICION, COUNT(*) FROM FUTBOLISTAS GROUP BY POSICION HAVING POSICION = 'PORTERO'; -- Devuelve el número de futbolistas por posición
SELECT NOMBRE, POSICION, COUNT(*) FROM FUTBOLISTAS GROUP BY NOMBRE, POSICION HAVING POSICION IS NOT NULL; -- Devuelve el número de futbolistas por posición que no sean nulos


-- JOINS 

-- RECORDAMOS QUE NO SE PUEDEN LLAMAR A DOS TABLAS CON EL MISMO NOMBRE POR ESO SE HACE LO DE RENOMBRARLA A P2
SELECT * FROM FUTBOLISTAS 
    JOIN EQUIPOS ON EQUIPOS.ID = FUTBOLISTAS.ID_EQUIPO
    JOIN PARTIDOS ON PARTIDOS.ID_EQUIPO_CASA = EQUIPOS.ID
    JOIN PARTIDOS P2 ON P2.ID_EQUIPO_FUERA = EQUIPOS.ID;  

INSERT INTO EQUIPOS VALUES (4, 'EQUIPO D', NULL, NULL);

SELECT * FROM FUTBOLISTAS JOIN EQUIPOS ON EQUIPOS.ID = FUTBOLISTAS.ID_EQUIPO; -- TODO EL CONTENIDO DE FUTBOLISTAS Y EQUIPOS QUE SIGUEN LA RENSTRICCION
SELECT * FROM FUTBOLISTAS LEFT JOIN EQUIPOS ON EQUIPOS.ID = FUTBOLISTAS.ID_EQUIPO; -- TODO EL CONTENIDO DE FUBOLISTAS MAS EQUIPOS
SELECT * FROM FUTBOLISTAS RIGHT JOIN EQUIPOS ON EQUIPOS.ID = FUTBOLISTAS.ID_EQUIPO; -- TODO EL CONTENIDO DE EQUIPOS MAS FUTBOLISTAS
SELECT * FROM FUTBOLISTAS FULL OUTER JOIN EQUIPOS ON EQUIPOS.ID = FUTBOLISTAS.ID_EQUIPO; -- TODO EL CONTENIDO QUE HAY ENTRE LAS DOS TABLAS

COMMIT;
 