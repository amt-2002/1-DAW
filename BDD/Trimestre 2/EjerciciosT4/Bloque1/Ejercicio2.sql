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
 