drop table empleados cascade constraints; 
create table empleados (
        dni char(9) primary key,
        nombre varchar2(50),
        especialidad varchar2(50), 
        experiencia varchar2(50), 
        tipo_empleado varchar2(50), 
        dni_veterinario_supervisor char(9)
);

drop table clientes cascade constraints; 
create table clientes (
        dni char(9) primary key,
        nombre varchar2(50),
        telefono int,
        forma_pago varchar2(50),
        direccion varchar2(50) 
);

drop table consultas_pasadas cascade constraints; 
create table consultas_pasadas (
        dni_veterinario char(9),
        id_mascota int,
        fecha date, 
        importe int ,
        primary key (dni_veterinario, id_mascota)
);

drop table clientes_y_mascotas cascade constraints; 
create table clientes_y_mascotas (
    dni_cliente char(9),
    id_mascota int, 
    primary key (dni_cliente, id_mascota)
);

drop table mascotas cascade constraints;
create table mascotas (
    id int primary key, 
    nombre varchar2(50), 
    sexo varchar2(50),
    color varchar2(50),
    tipo varchar2(50), 
    raza varchar2(50), 
    fecha_nacimiento date, 
    dni_auxiliar_datosini char(9),
    fecha_datosini date, 
    importe_datosini int
);

alter table empleados add foreign key (dni_veterinario_supervisor) references empleados(dni);
alter table consultas_pasadas add foreign key (dni_veterinario) references empleados(dni);
alter table consultas_pasadas add foreign key (id_mascota) references mascotas(id);
alter table clientes_y_mascotas add foreign key (dni_cliente) references clientes(dni);
alter table clientes_y_mascotas add foreign key (id_mascota) references mascotas(id);
alter table mascotas add foreign key (dni_auxiliar_datosini) references empleados(dni);