-- Ejercicio1 

drop table categorias cascade constraints; 
create table categorias (
        codigo int, 
        descripcion varchar(100), 
        primary key (codigo)
);

drop table productos cascade constraints 
create table productos (
        id int, 
        nombre varchar(50),
        precio  number, 
        primary key (id) 
);

-- Ejercicio 2

drop table cuenta__bancarias cascade constraints; 
create table cuentas_bancarias (
        numero int, 
        saldo number,
        primary key (numero)
);

drop table transacciones cascade constraints; 
create table transacciones (
        codigo int, 
        tipo varchar(50), 
        cantidad number, 
        numero number, 
        primary key (codigo) 
);

alter table transacciones add constraint fk_numero foreign key (numero) references cuentas_bancarias(numero);


-- Ejercicio 3

drop table aulas cascade constraints; 
create  table  aulas (
        numero int, 
        planta int, 
        situacion varchar(50), 
        primary key(numero, planta) 
);

drop table estudiantes cascade constraints; 
create table estudiantes (
        numero_matricula int, 
        nombre varchar(50), 
        direccion varchar(50),
        primary key (numero_matricula)
);

drop table asignaturas cascade constraints; 
create table asignaturas (
    denominacion varchar2(50),
    ciclo varchar2(50), 
    primary key (denominacion, ciclo)
);

drop table estudios cascade constraints; 
create table estudios (
    numero int, 
    planta int, 
    numero_matricula int, 
    denominacion varchar2(50), 
    ciclo varchar2(50),
    hora varchar2(50),
    primary key( numero, planta, numero_matricula, denominacion, ciclo)
);

alter table estudios add foreign key (numero, planta) references aulas(numero, planta); 
alter table estudios add foreign key (numero_matricula) references estudiantes(numero_matricula); 
alter table estudios add foreign key (denominacion, ciclo) references asignaturas(denominacion, ciclo); 



-- Ejercicio 4 

drop table estudios cascade constraints; 
create table estudios (
    id int, 
    numero int, 
    planta int, 
    numero_matricula int, 
    denominacion varchar2(50), 
    ciclo varchar2(50),
    hora varchar2(50),
    primary key( id) 
);

alter table estudios add foreign key (numero, planta) references aulas(numero, planta); 
alter table estudios add foreign key (numero_matricula) references estudiantes(numero_matricula); 
alter table estudios add foreign key (denominacion, ciclo) references asignaturas(denominacion, ciclo); 

-- Ejercicio 5 

drop table representantes cascade constraints; 
create table representantes (
        id_licencia int, 
        nombre varchar2(60),
        primary key (id_licencia)
);

drop table actores cascade constraints; 
create table actores (
        id_carne int, 
        nombre_a varchar2(50),
        nombre_r varchar2(50), 
        id_licencia_rep int, 
        contrato varchar2(50),
        primary key (id_carne)
);

alter table actores add constraint fk_repre foreign key (id_licencia_rep) references representantes(id_licencia); 


-- Ejercicio 6 

drop table empleados cascade constraints; 
create table empleados (
        dni char(9),
        nombre varchar2(50), 
        dni_supervisor char(9), 
        primary key (dni) 
);


-- Ejercicio 7 

drop table piezas cascade constraints;
create table piezas (
        codigo int, 
        descripcion varchar2(50), 
        primary key (codigo)
);

drop table compuestos cascade constraints; 
create table compuestos (
        codigo int,
        codigo_c int, 
        primary key (codigo, codigo_c)
);

alter table compuestos add constraint fk_codigo foreign key (codigo) references piezas(codigo);



-- Ejercicio 8 

drop table actores cascade constraints; 
create table actores (
    identificador int, 
    nombre varchar2(50),
    identificadorPersonaje int,
    primary key (identificador)
); 

drop table personajes cascade constraints;
create table personajes (
        identificador int, 
        nombre varchar2(50), 
        pelicula varchar2(50),
        identificadorActor int, 
        primary key (identificador)
);

alter table actores add constraint fk_actor foreign key (identificadorPersonaje) references personajes(identificador);
alter table personajes add constraint fk_personaje foreign key (identificadorActor) references actores(identificador);
