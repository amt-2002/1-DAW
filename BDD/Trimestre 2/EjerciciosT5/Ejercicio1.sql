drop table barcos cascade constraints;

create table barcos(
    matricula char(7) check(regexp_like(matricula,'[A-Z]{2}-[0-9]{4}')) primary key,
    nombre varchar2(50),
    clase varchar2(50),
    armador varchar2(50),
    capacidad int,
    nacionalidad varchar2(50)
);


drop table lotes cascade constraint; 

create table lotes (
    codigo int primary key, 
    matricula char(7) check(regexp_like(matricula,'[A-Z]{2}-[0-9]{4}')),
    num_kg int,
    precio_kg_salida int,
    precio_kg_vendido int,
    fecha_venta date not null,
    cod_especie int 
); 

drop table especies cascade constraint;
create table especies (
    codigo int primary key, 
    nombre varchar2(50),
    tipo varchar2(50),
    cupo_barcho int, 
    caladero_ppal int 
);

drop table caladeros cascade constraint;
create table caladeros (
    codigo int primary key, 
    nombre varchar2(50),
    ubicacion varchar2(50),
    especie_ppal varchar2(50)
);

drop table fechas_capturas cascade constraint;
create table fechas_capturas (
    cod_especie int, 
    cod_caladero int, 
    fecha_inicio date, 
    fecha_fin date,
    primary key (cod_especie, cod_caladero)
);

alter table lotes add foreign key (matricula) references barcos(matricula) on delete cascade;
alter table lotes add foreign key (cod_especie) references especies(codigo) on delete cascade;
alter table especies add foreign key (caladero_ppal) references caladeros(codigo);

alter table lotes add check(precio_kg_vendido > precio_kg_salida and precio_kg_salida < precio_kg_vendido);
alter table lotes add check(num_kg > 0 and precio_kg_vendido > 0 and precio_kg_salida > 0);
alter table caladeros add check(nombre = UPPER(nombre) and ubicacion = UPPER(ubicacion));


