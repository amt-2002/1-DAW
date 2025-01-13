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

 